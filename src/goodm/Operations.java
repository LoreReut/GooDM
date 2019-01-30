/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;
import org.w3c.dom.*;
/**
 *
 * @author HERMES
 */
public class Operations {
    GUI gui;
    
    public Operations(GUI gui){
        this.gui = gui;
    }
    
    void addUpdateCharacters(){
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
                // When you get the Character from screen, the program doesn't
                // really know if it's his turn or not, so...
                charToList.isHisTurn = temp.isHisTurn;
                charToList.maxPhysical = temp.maxPhysical;
                charToList.maxStun = temp.maxStun;
                charToList.perception = temp.perception;
                gui.characters.set(gui.characters.lastIndexOf(temp), charToList);
            }
        }
        
        if( !characterAlreadyExists ) {
            if ( charToList.rollInitiative ) {
                charToList.setInitiative(rollInitiative(charToList.initiativeDie, charToList.initiativeBonus));   
            }
            if (charToList.simplifiedHealth){
                charToList.maxPhysical = charToList.physical;
            } else {
                charToList.maxPhysical = charToList.physical;
                charToList.maxStun =charToList.stun;
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
        int perception = getCuratedInt(gui.getPerceptionText());

        return new Character(name, stun, physical, simplifiedHealth, rollInitiative, initiativeDie, initiativeBonus, initiative, perception);
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
        gui.getPerceptionText().setText(Integer.toString(charToScreen.getPerception()));
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
            String physicalString = String.format("%02d", temp.getPhysical());
            String stunString = String.format("%02d", temp.getStun());
            String maxPhysicalString = String.format("%02d", temp.getMaxPhysical());
            String maxStunString = String.format("%02d", temp.getMaxStun());
            String initiativeString = String.format("%02d", temp.getInitiative());
            if ( temp.isHisTurn ) {tempString += ">> ";}
            tempString += initiativeString + " - ";
            tempString += "<b>" + temp.getName() + "</b> - ";
            if ( temp.simplifiedHealth ) {
                tempString += "Condition Monitor: " + physicalString + "/" + maxPhysicalString + " ";
            } else {
                tempString += "Condition Monitor: P " + physicalString + "/" + maxPhysicalString + " " +
                                "S "+ stunString + "/" + maxStunString + "</html>";
            }
            
            
            model.addElement(tempString);
        }
        gui.getCharacterJList().setModel(model);
    }
    
    public int rollADice(){
        return (int) (Math.random()*6) + 1;
    }
    
    public void saveToXML(Character character){ 
        // The file is saved on the folder above the program folder
        String fileName = "Characters/" + character.getName();
        // This will be used to hold each xml element
        Element element = null;
        
        try {
            DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document dom = docBuilder.newDocument();
            Element rootElement = dom.createElement("Character");
            
            element = dom.createElement("Name");
            element.appendChild(dom.createTextNode(character.getName()));
                rootElement.appendChild(element);
            element = dom.createElement("isHealthSimplified");
            element.appendChild(dom.createTextNode(Boolean.toString(character.isSimplifiedHealth())));
                rootElement.appendChild(element);
            element = dom.createElement("isAutorollEnabled");
            element.appendChild(dom.createTextNode(Boolean.toString(character.isRollInitiative())));
                rootElement.appendChild(element);
            element = dom.createElement("initiativeDie");
            element.appendChild(dom.createTextNode(character.getInitiativeDie()+""));
                rootElement.appendChild(element);
            element = dom.createElement("initiativeBonus");
            element.appendChild(dom.createTextNode(character.getInitiativeBonus()+""));
                rootElement.appendChild(element);
            element = dom.createElement("physicalOrSimplifiedHealth");
            element.appendChild(dom.createTextNode(character.getPhysical()+""));
                rootElement.appendChild(element);
            element = dom.createElement("stunHealth");
            element.appendChild(dom.createTextNode(character.getStun()+""));
                rootElement.appendChild(element);
            element = dom.createElement("perception");
            element.appendChild(dom.createTextNode(character.getPerception()+""));
                rootElement.appendChild(element);
            dom.appendChild(rootElement);
                
            try {
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT,    "yes");
                transformer.setOutputProperty(OutputKeys.METHOD,    "xml");
                transformer.setOutputProperty(OutputKeys.ENCODING,  "UTF-8");
                transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "characters.dtd");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                
                transformer.transform(new DOMSource(dom), new StreamResult(new FileOutputStream(fileName)));
            } catch (TransformerException te){
                System.out.println(te);
            } catch (FileNotFoundException fnfe){
                System.out.println(fnfe);
            }
        } catch (ParserConfigurationException pos){
            System.out.println(pos);
        }
    }
    
    public Character loadFromXML(String fileName){
        Character result = null;
        try {
            Document dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("Characters/" + fileName);
            Element doc = dom.getDocumentElement();
            String name = getTextValueXML(doc, "Name");
            String isHealthSimplified = getTextValueXML(doc, "isHealthSimplified");
            String isAutorollEnabled = getTextValueXML(doc, "isAutorollEnabled");
            String initiativeDie = getTextValueXML(doc, "initiativeDie");
            String physicalOrSimplifiedHealth = getTextValueXML(doc, "physicalOrSimplifiedHealth");
            String stunHealth = getTextValueXML(doc, "stunHealth");
            String initiativeBonus = getTextValueXML(doc, "initiativeBonus");
            String perception = getTextValueXML(doc, "perception");
            
            result = new Character(name, Integer.valueOf(stunHealth), Integer.valueOf(physicalOrSimplifiedHealth), Boolean.valueOf(isHealthSimplified), Boolean.valueOf(isAutorollEnabled), Integer.valueOf(initiativeDie), Integer.valueOf(initiativeBonus), 0, Integer.valueOf(perception));
        } catch (SAXException se){
            System.out.println(se);
        } catch (ParserConfigurationException poe){
            System.out.println(poe);
        } catch (IOException ioe){
            System.out.println(ioe);
        }
        
        return result;
    }
    
    private String getTextValueXML(Element doc, String tag){
        String result = "";
        NodeList nodeList;
        nodeList = doc.getElementsByTagName(tag);
        
        // Check that there's actually something in it and let's go
        if (nodeList.getLength() > 0 && nodeList.item(0).hasChildNodes()){
            result = nodeList.item(0).getFirstChild().getNodeValue();
        }
        
        return result;
    }
    
    void loadLoadableCharacters(){
        JList loadablesJList = gui.getLoadableCharactersList();
        File loadablesFile = new File("Characters/");
        File[] loadablesList = loadablesFile.listFiles();
        DefaultListModel<String> model = new DefaultListModel();
        String tempString, currentName;
        
        for (int i = 0; i < loadablesList.length;i++){
            currentName = loadablesList[i].getName();
            
            if (!currentName.equals("characters.dtd")){
                model.addElement(currentName);
            }
        }
            
        gui.getLoadableCharactersList().setModel(model);
    }
}
