/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodm;

import java.util.Collections;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import java.util.Random;

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
                if( !charToList.rollInitiative ) { 
                    charToList.setInitiative(charToList.initiativeDie);
                } else {
                    charToList.setInitiative(temp.getInitiative());
                }
                if( temp.isHisTurn ) { charToList.isHisTurn = true; }
                gui.characters.set(gui.characters.lastIndexOf(temp), charToList);
            }
        }
        
        if( !characterAlreadyExists ) {
            if ( charToList.rollInitiative ) {
            
                charToList.setInitiative(rollInitiative(charToList.initiativeDie, charToList.initiativeBonus));
                
            }
            gui.characters.add(charToList); 
        }
                
        updateJList();
    }
    
    void sortCharacterList(){
        Collections.sort(gui.characters);
    }
    
    Character getCharacterOnScreen(){
        String name = getCuratedString(gui.getNameText());
        boolean simplifiedHealth = gui.getHealthRadioButton().isSelected();
        boolean rollInitiative = gui.getRollRadioButton().isSelected();
        int physical = getCuratedInt(gui.getPhysicalText());
        int stun = getCuratedInt(gui.getStunText());
        int initiativeDie = getCuratedInt(gui.getInitiativeText());
        int initiativeBonus = getCuratedInt(gui.getInitiativeBonusText());

        return new Character(name, stun, physical, simplifiedHealth, rollInitiative, initiativeDie, initiativeBonus);
    }
    
    void setCharacterOnScreen(Character charToScreen){
        gui.getNameText().setText(charToScreen.getName());
        gui.getHealthRadioButton().setSelected(charToScreen.simplifiedHealth);
        gui.getRollRadioButton().setSelected(charToScreen.rollInitiative);
        gui.getPhysicalText().setText(Integer.toString(charToScreen.getPhysical()));
        gui.getStunText().setText(Integer.toString(charToScreen.getStun()));
        gui.getInitiativeText().setText(Integer.toString(charToScreen.getInitiativeDie()));
        gui.getInitiativeBonusText().setText(Integer.toString(charToScreen.getInitiativeBonus()));
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
