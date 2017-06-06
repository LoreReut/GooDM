/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author HERMES
 */
public class GooDM {
    GUI gui = new GUI();
    Operations ops = new Operations(gui);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        GooDM main = new GooDM();
        main.gui.setVisible(true);
        main.setActionListeners();
    }
    private void setActionListeners(){
        // Roll Radio Button: Will show "d6 + [TextField]" in case the user
        // chooses to have the initiative automatically rolled instead of manual.
        gui.getRollRadioButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if( gui.getRollRadioButton().isSelected() ){
                    gui.getInitiativeBonusLabel().setVisible(true);
                    gui.getInitiativeBonusText().setVisible(true);
                    gui.getForceRollButton().setEnabled(true);
                } else {
                    gui.getInitiativeBonusLabel().setVisible(false);
                    gui.getInitiativeBonusText().setVisible(false);
                    gui.getForceRollButton().setEnabled(false);
                }
            }
        });
        gui.getHealthRadioButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if( gui.getHealthRadioButton().isSelected() ){
                    gui.getPhysicalLabel().setText("Health");
                    gui.getStunLabel().setVisible(false);
                    gui.getStunText().setVisible(false);
                } else {
                    gui.getPhysicalLabel().setText("Physical");
                    gui.getStunLabel().setVisible(true);
                    gui.getStunText().setVisible(true);
                }
            }
        });
        gui.getUpdateButton().addActionListener(new ActionListener(){
            @Override public void actionPerformed(ActionEvent e){
                ops.updateCharacterList();
            }
        });
        gui.getMakeHisTurnButton().addActionListener(new ActionListener(){
            @Override public void actionPerformed(ActionEvent e){
                Iterator<Character> iterator = gui.characters.iterator();
                int index = 0;
                while (iterator.hasNext()){
                    Character temp = iterator.next();
                    index = gui.characters.lastIndexOf(temp);
                    if( temp.getName().equals(gui.getNameText().getText())){
                        temp.isHisTurn = true;
                        gui.characters.set(index, temp);
                    } else {
                        temp.isHisTurn = false;
                        gui.characters.set(index, temp);
                    }
                }
                ops.updateJList();
            }
        });
        gui.getForceRollButton().addActionListener(new ActionListener(){
            @Override public void actionPerformed(ActionEvent e){
                Character charToReroll = ops.getCharacterOnScreen();
                Iterator<Character> iterator = gui.characters.iterator();
            while ( iterator.hasNext() ){
                Character temp = iterator.next();
                // If the name is the same as one of the characters in the list,
                // it means the user wants to modify it, so we will replace
                // its initiative with the new one
                if( temp.getName().equals(charToReroll.name) ) { 
                    // Check if the initiative is being modified, regardless of
                    // autoroll.
                    charToReroll.initiative = ops.rollInitiative(charToReroll.initiativeDie, charToReroll.initiativeBonus);
                    charToReroll.isHisTurn = temp.isHisTurn;
                    gui.characters.set(gui.characters.lastIndexOf(temp), charToReroll);
                }
            }
            ops.updateJList();
                // TODO: Somewhere else, I should do that
                // the forceRollButton as well as the makeHisTurnButton
                // is grey when the character written does
                // not exist.
            }
        });
        gui.getSortListButton().addActionListener(new ActionListener(){
            @Override public void actionPerformed(ActionEvent e){
                ops.sortCharacterList();
                ops.updateJList();
            }
        });
        gui.getCharacterJList().addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe){
                int index = gui.getCharacterJList().getSelectedIndex();
                System.out.println("Index is " + index);
                gui.getCharacterJList().setFocusable(false);
                gui.getCharacterJList().setFocusable(true);
                List<Character> chars = gui.getCharacters();
                ops.setCharacterOnScreen(chars.get(index));
            }
            @Override
            public void focusLost(FocusEvent fe){
                
            }
        });
        SelectOnFocus selectOnFocus = new SelectOnFocus();
        gui.getNameText().addFocusListener(selectOnFocus);
        gui.getPhysicalText().addFocusListener(selectOnFocus);
        gui.getStunText().addFocusListener(selectOnFocus);
        gui.getInitiativeBonusText().addFocusListener(selectOnFocus);
        gui.getInitiativeText().addFocusListener(selectOnFocus);
        
        // TODO: Add an 'Add/Substract Initiative' button which will roll the dice
        // you wrote and add it to the initiative of the selected character,
        // but will not modify its original initiative die. This will open
        // a new window with 2 text boxes, an add and a substract button. The first being
        // the initiative bonus and the second being the initiative die. If you
        // leave the second blank, it will add/substract a solid number, and if
        // you leave the second with a number, it will add/substract the number +
        // the die. For example, if you put 2 in the first textbox and 6 in the second,
        // then click substract, it will substract 2+6d6 from the initiative of the
        // selected character.
        // TODO: Add +5 and -5 buttons for the initiative
    }
}