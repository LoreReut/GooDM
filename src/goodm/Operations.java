/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author HERMES
 */
public class Operations {
    GUI gui;
    
    public Operations(GUI gui){
        this.gui = gui;
    }
    
    void updateCharacterList(){
        boolean characterAlreadyExists = false;
        //Creates a character regardless if it exists or not, which will replace
        //another existing character in case the name is the same. Actual
        //initiative will be added later to charToList (because, when you
        //create a character, you don't put the initiative in the constructor
        //and starting initiative is 0)
        Character charToList = getCharacterOnScreen();
        
        //Check if the character already exists
        Iterator<Character> iterator = gui.characters.iterator();
        while ( iterator.hasNext() ){
            Character temp = iterator.next();
            // If the name is the same as one of the characters in the list,
            // it means the user wants to modify it, so we will replace
            // its initiative with the new one
            if( temp.getName().equals(charToList.name) ) { 
                characterAlreadyExists = true;
                // Check if the initiative is being modified, regardless of
                // autoroll.
                if( temp.isHisTurn ) { charToList.isHisTurn = true; }
                gui.characters.set(gui.characters.lastIndexOf(temp), charToList);
            }
        }
        
        if( !characterAlreadyExists ) {
            if ( charToList.rollInitiative ) {
            
                charToList.setInitiative(rollInitiative(charToList.initiativeDie, charToList.initiativeBonus));
                
            }
            if (!gui.characters.iterator().hasNext()){
                charToList.isHisTurn = true;
            }
            gui.characters.add(charToList); 
        }
                
        updateJList();
    }
    
    void sortCharacterList(){
        Collections.sort(gui.characters);
        Iterator<Character> iterator = gui.characters.iterator();
        while (iterator.hasNext()) iterator.next().isHisTurn = false;
        gui.characters.get(0).isHisTurn = true;
        updateJList();
    }
    
    Character getCharacterOnScreen(){
        String name = getCuratedString(gui.getNameText());
        boolean simplifiedHealth = gui.getHealthRadioButton().isSelected();
        boolean rollInitiative = gui.getRollRadioButton().isSelected();
        int physical = getCuratedInt(gui.getPhysicalText());
        int stun = getCuratedInt(gui.getStunText());
        int initiativeDie = getCuratedInt(gui.getNpcInitiativeText());
        int initiativeBonus = getCuratedInt(gui.getInitiativeBonusText());
        int initiative = getCuratedInt(gui.getPcInitiativeText());

        return new Character(name, stun, physical, simplifiedHealth, rollInitiative, initiativeDie, initiativeBonus, initiative);
    }
    
    void setCharacterOnScreen(Character charToScreen){
        gui.getNameText().setText(charToScreen.getName());
        gui.getHealthRadioButton().setSelected(charToScreen.simplifiedHealth);
        gui.getRollRadioButton().setSelected(charToScreen.rollInitiative);
        if( gui.getRollRadioButton().isSelected() ){
            gui.getNpcInitiativeText().setText(Integer.toString(charToScreen.getInitiativeDie()));
            gui.getInitiativeBonusText().setText(Integer.toString(charToScreen.getInitiativeBonus()));
            gui.getInitiativeBonusLabel().setVisible(true);
            gui.getInitiativeBonusText().setVisible(true);
            gui.getForceRollButton().setEnabled(true);
            gui.getPcInitiativeText().setVisible(true);
            gui.getPcInitiativeText().setText(Integer.toString(charToScreen.getInitiative()));
            gui.getEqualsLabel().setVisible(true);
            gui.getNpcInitiativeText().setVisible(true);
        } else {
            gui.getInitiativeBonusLabel().setVisible(false);
            gui.getInitiativeBonusText().setVisible(false);
            gui.getNpcInitiativeText().setVisible(false);
            gui.getForceRollButton().setEnabled(false);
            gui.getPcInitiativeText().setText(Integer.toString(charToScreen.getInitiative()));
            gui.getPcInitiativeText().setVisible(true);
            gui.getEqualsLabel().setVisible(false);
        }
        if( gui.getHealthRadioButton().isSelected() ){
            gui.getPhysicalLabel().setText("Health");
            gui.getStunLabel().setVisible(false);
            gui.getStunText().setVisible(false);
        } else {
            gui.getPhysicalLabel().setText("Physical");
            gui.getStunLabel().setVisible(true);
            gui.getStunText().setVisible(true);
        }
        gui.getPhysicalText().setText(Integer.toString(charToScreen.getPhysical()));
        gui.getStunText().setText(Integer.toString(charToScreen.getStun()));
    }
    
    int rollInitiative(int initiativeDie, int initiativeBonus){
        Random rand = new Random();
        int result = 0;
        
        for (int i = 0; i < initiativeDie; i++){
            result += rand.nextInt(6)+1;
        }
        
        return result + initiativeBonus;
    }
    
    String getCuratedString(JTextField textField){
        if (textField.getText().equals(null)){ return "Empty"; }
        else { return textField.getText(); }
    }
    
    int getCuratedInt(JTextField textField){
        if (textField.getText().equals("")){ return 0; }
        else if (Integer.parseInt(textField.getText()) != (Integer) Integer.parseInt(textField.getText())) {
            return 0;
        }
        else { return Integer.parseInt(textField.getText()); }
    }
    
    void nextInitiativePass(){
        // Initiative is more complex than it sounds. It should be rolled
        // ONLY when it's the end of all turns and everyone is rolling, that way
        // the user can modify the initiative dice without modifying the actual
        // initiative.
        Iterator<Character> iterator = gui.characters.iterator();
        while(iterator.hasNext()){
            Character thisCharacter = iterator.next();

            if (thisCharacter.isHisTurn) {
                if (iterator.hasNext()){
                    thisCharacter.isHisTurn = false;
                    iterator.next().isHisTurn = true;
                } else if (!iterator.hasNext()) {
                    thisCharacter.isHisTurn = false;
                    Iterator<Character> redundantIterator = gui.characters.iterator();
                    Character redundantCharacter = redundantIterator.next();
                    redundantCharacter.isHisTurn = true;
                    nextTurn();
                }
            }
        }
        updateJList();
    }

    /**
     * Begins a new turn (that happens when all characters have 0 initiative and everything restarts).
     */
    void nextTurn(){
        Iterator<Character> iterator = gui.characters.iterator();
        int numberOfCharacters = 0;
        int numberOfZeros = 0;

        while (iterator.hasNext()){
            Character thisCharacter = iterator.next();
            int thisInitiative = thisCharacter.getInitiative();
            numberOfCharacters += 1;
            if (thisInitiative <= 10){
                thisCharacter.setInitiative(0);
                numberOfZeros += 1;
            } else {
                thisCharacter.setInitiative(thisInitiative - 10);
            }
        }
        //Checks if everyone has 0 initiative, then rerolls the NPCs and asks for PC inis.
        if (numberOfCharacters == numberOfZeros) {
           iterator = gui.characters.iterator();
            // TODO: (VISUAL) Make the initiative window appear neatly after the main window.
           JFrame initiativeWindow = new JFrame("Input Character Initiative");
           initiativeWindow.setLayout(new BoxLayout(initiativeWindow.getContentPane(), BoxLayout.Y_AXIS));
           initiativeWindow.setVisible(true);
           List<JTextArea> textFieldList = new ArrayList<>();
           int numberOfPCs = 0;

           while (iterator.hasNext()){
               Character thisCharacter = iterator.next();
               if (thisCharacter.isRollInitiative()){
                   thisCharacter.setInitiative(rollInitiative(thisCharacter.getInitiativeDie(),thisCharacter.getInitiativeBonus()));
                   System.out.println("Rolling initaitive die for character = " + thisCharacter.getName());
               } else if (!thisCharacter.isRollInitiative()){
                   JTextArea tempTextArea = new JTextArea();
                   JPanel row = new JPanel();

                   row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));
                   textFieldList.add(numberOfPCs, tempTextArea);
                   row.add(new JLabel(thisCharacter.getName()));
                   row.add(tempTextArea);
                   numberOfPCs++;
                   initiativeWindow.add(row);
                   initiativeWindow.pack();

               }
           }
           //Create the SET INITIATIVE button of the window
           JButton setInitiativeButton = new JButton("Set Initiative");
           if (numberOfPCs > 0){


               setInitiativeButton.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e){
                       Iterator<Character> iterator = gui.characters.iterator();
                       int numberOfPCs = 0;
                       while (iterator.hasNext()){
                           Character thisCharacter = iterator.next();
                           if (!thisCharacter.isRollInitiative()){
                               thisCharacter.setInitiative(Integer.parseInt(textFieldList.get(numberOfPCs).getText()));
                               numberOfPCs++;
                           }
                       }
                       sortCharacterList();
                       initiativeWindow.dispose();
                   }
               });
           }
           initiativeWindow.add(setInitiativeButton);
           initiativeWindow.pack();
        }
    }

    public void updateJList(){
        Iterator<Character> iterator = gui.characters.iterator();
        //gui.getCharacterJList().removeAll();
        DefaultListModel<String> model = new DefaultListModel<>();
        while (iterator.hasNext()){
            Character temp = iterator.next();
            String tempString = "<html>";
            
            if ( temp.isHisTurn ) {tempString += ">> ";}
            tempString += "<b>" + temp.getName() + "</b> ";
            if ( temp.simplifiedHealth ) {
                tempString += "Health: " + temp.getPhysical() + " ";
            } else {
                tempString += "Ph: " + temp.getPhysical() + " " +
                                "St: "+temp.getStun() + " ";
            }
            tempString += "In: <b>" + temp.getInitiative() + "</b></html>";
            
            model.addElement(tempString);
        }
        gui.getCharacterJList().setModel(model);
    }
}
