/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodm;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author HERMES
 */
public class SelectOnFocus implements FocusListener {
    @Override
    public void focusGained(FocusEvent fe){
        JTextField textField = (JTextField)fe.getSource();
        textField.selectAll();
    }
    @Override public void focusLost(FocusEvent fe){
        JTextField textField = (JTextField)fe.getSource();
        textField.selectAll();
    }
}
