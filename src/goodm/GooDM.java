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

/**
 * NPCs initiative can't be changed through the usual method, because I used some retarded trickery where
 * initiative textBoxes switch purposes depending on whether it's NPC or PC.
 * TODO: (VITAL) Fix initiative textBoxes for the NPCs.
 */
//TODO: (IMPORTANT)Let a users save a group of characters and add/remove from that list whenever they want.
//TODO: Add a window, which will be attached to the main window, where you can roll skill checks of single or a group of units (for example a sneak check against the threshold of a boss). You can also save these groups of dicepools (for example, "party's perception checks" (Check RL notes).
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
                    gui.getInitiativeText().setVisible(true);
                    gui.getForceRollButton().setEnabled(true);
                } else {
                    gui.getInitiativeBonusLabel().setVisible(false);
                    gui.getInitiativeText().setVisible(false);
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
                // TODO: Turn this into a method so it's accessed by both nextInitiativePass and makeHisTurnButton, except the ops.updateJList(); part, which will be done by the mentioned methods.
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
        gui.getAdd5IniButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                gui.getInitiativeBonusText().setText(Integer.toString(Integer.parseInt(gui.getInitiativeBonusText().getText()) + 5));
            }
        });
        gui.getSubstract5IniButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                gui.getInitiativeBonusText().setText(Integer.toString(Integer.parseInt(gui.getInitiativeBonusText().getText()) - 5));
                if (Integer.parseInt(gui.getInitiativeBonusText().getText()) < 0){
                    gui.getInitiativeBonusText().setText("0");
                }
            }
        });
        gui.getNextTurnButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ops.nextInitiativePass();
            }
        });
        SelectOnFocus selectOnFocus = new SelectOnFocus();
        gui.getNameText().addFocusListener(selectOnFocus);
        gui.getPhysicalText().addFocusListener(selectOnFocus);
        gui.getStunText().addFocusListener(selectOnFocus);
        gui.getInitiativeText().addFocusListener(selectOnFocus);
        gui.getInitiativeBonusText().addFocusListener(selectOnFocus);
        
        // PENDING: Add an 'Add/Substract Initiative' button which will roll the dice
        // you wrote and add it to the initiative of the selected character,
        // but will not modify its original initiative die. This will open
        // a new window with 2 text boxes, an add and a substract button. The first being
        // the initiative bonus and the second being the initiative die. If you
        // leave the second blank, it will add/substract a solid number, and if
        // you leave the second with a number, it will add/substract the number +
        // the die. For example, if you put 2 in the first textbox and 6 in the second,
        // then click substract, it will substract 2+6d6 from the initiative of the
        // selected character.
    }
}