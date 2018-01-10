/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

/**
 *
 * @author HERMES
 */
public class GUI extends javax.swing.JFrame {
    
    List<Character> characters = new ArrayList<Character>();
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        stunLabel.setVisible(false);
        stunText.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        physicalLabel = new javax.swing.JLabel();
        initiativeLabel = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        physicalText = new javax.swing.JTextField();
        initiativeBonusText = new javax.swing.JTextField();
        stunLabel = new javax.swing.JLabel();
        stunText = new javax.swing.JTextField();
        healthRadioButton = new javax.swing.JRadioButton();
        initiativeBonusLabel = new javax.swing.JLabel();
        initiativeText = new javax.swing.JTextField();
        rollRadioButton = new javax.swing.JRadioButton();
        updateButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        characterJList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        diceJList = new javax.swing.JList<>();
        nextTurnButton = new javax.swing.JButton();
        makeHisTurnButton = new javax.swing.JButton();
        forceRollButton = new javax.swing.JButton();
        sortListButton = new javax.swing.JButton();
        add5IniButton = new javax.swing.JButton();
        substract5IniButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nameLabel.setText("Name");

        physicalLabel.setText("Health");

        initiativeLabel.setText("Initiative");

        physicalText.setText("0");

        initiativeBonusText.setText("0");

        stunLabel.setText("Stun");

        stunText.setText("0");

        healthRadioButton.setSelected(true);
        healthRadioButton.setText("Simplified");
        healthRadioButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        initiativeBonusLabel.setText("d6 +");

        initiativeText.setText("0");

        rollRadioButton.setSelected(true);
        rollRadioButton.setText("Roll");

        updateButton.setText("Add/Update");

        characterJList.setMaximumSize(new java.awt.Dimension(215, 80));
        characterJList.setMinimumSize(new java.awt.Dimension(200, 80));
        jScrollPane1.setViewportView(characterJList);

        jScrollPane2.setViewportView(diceJList);

        nextTurnButton.setText("Next Turn");

        makeHisTurnButton.setText("Make His Turn");
        makeHisTurnButton.setActionCommand("Turn to this char");

        forceRollButton.setText("Force Roll");

        sortListButton.setText("Sort List");
        sortListButton.setActionCommand("sortListButton");

        add5IniButton.setName(""); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rollRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(initiativeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(initiativeText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(initiativeBonusLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(initiativeBonusText, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(add5IniButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(substract5IniButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(nameLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nameText))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(healthRadioButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(physicalLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(physicalText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(stunLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(stunText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(nextTurnButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(updateButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(108, 108, 108)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(makeHisTurnButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(forceRollButton))
                                    .addComponent(sortListButton))))
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(physicalLabel)
                    .addComponent(physicalText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stunLabel)
                    .addComponent(stunText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthRadioButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(add5IniButton)
                            .addComponent(initiativeBonusText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(initiativeLabel)
                                .addComponent(initiativeBonusLabel)
                                .addComponent(initiativeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rollRadioButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(substract5IniButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(makeHisTurnButton)
                    .addComponent(forceRollButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextTurnButton)
                    .addComponent(sortListButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public JRadioButton getHealthRadioButton() {
        return healthRadioButton;
    }

    public JButton getNextTurnButton() {
        return nextTurnButton;
    }

    public void setNextTurnButton(JButton nextTurnButton) {
        this.nextTurnButton = nextTurnButton;
    }

    public JButton getSortListButton() {
        return sortListButton;
    }

    public void setSortListButton(JButton sortListButton) {
        this.sortListButton = sortListButton;
    }

    public void setHealthRadioButton(JRadioButton healthRadioButton) {
        this.healthRadioButton = healthRadioButton;
    }

    public JLabel getInitiativeBonusLabel() {
        return initiativeBonusLabel;
    }

    public void setInitiativeBonusLabel(JLabel initiativeBonusLabel) {
        this.initiativeBonusLabel = initiativeBonusLabel;
    }

    public JTextField getInitiativeText() {
        return initiativeText;
    }

    public void setInitiativeText(JTextField initiativeText) {
        this.initiativeText = initiativeText;
    }

    public JLabel getInitiativeLabel() {
        return initiativeLabel;
    }

    public void setInitiativeLabel(JLabel initiativeLabel) {
        this.initiativeLabel = initiativeLabel;
    }

    public JTextField getInitiativeBonusText() {
        return initiativeBonusText;
    }

    public void setInitiativeBonusText(JTextField initiativeBonusText) {
        this.initiativeBonusText = initiativeBonusText;
    }

    public JList<String> getjList1() {
        return characterJList;
    }

    public void setjList1(JList<String> jList1) {
        this.characterJList = jList1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public JTextField getNameText() {
        return nameText;
    }

    public void setNameText(JTextField nameText) {
        this.nameText = nameText;
    }

    public JLabel getPhysicalLabel() {
        return physicalLabel;
    }

    public void setPhysicalLabel(JLabel physicalLabel) {
        this.physicalLabel = physicalLabel;
    }

    public JTextField getPhysicalText() {
        return physicalText;
    }

    public JList<String> getCharacterJList() {
        return characterJList;
    }

    public void setCharacterJList(JList<String> characterJList) {
        this.characterJList = characterJList;
    }

    public void setPhysicalText(JTextField physicalText) {
        this.physicalText = physicalText;
    }

    public JRadioButton getRollRadioButton() {
        return rollRadioButton;
    }

    public void setRollRadioButton(JRadioButton rollRadioButton) {
        this.rollRadioButton = rollRadioButton;
    }

    public JLabel getStunLabel() {
        return stunLabel;
    }

    public void setStunLabel(JLabel stunLabel) {
        this.stunLabel = stunLabel;
    }

    public JTextField getStunText() {
        return stunText;
    }

    public void setStunText(JTextField stunText) {
        this.stunText = stunText;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(JButton updateButton) {
        this.updateButton = updateButton;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add5IniButton;
    private javax.swing.JList<String> characterJList;
    private javax.swing.JList<String> diceJList;
    private javax.swing.JButton forceRollButton;
    private javax.swing.JRadioButton healthRadioButton;
    private javax.swing.JLabel initiativeBonusLabel;
    private javax.swing.JTextField initiativeBonusText;
    private javax.swing.JLabel initiativeLabel;
    private javax.swing.JTextField initiativeText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton makeHisTurnButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameText;
    private javax.swing.JButton nextTurnButton;
    private javax.swing.JLabel physicalLabel;
    private javax.swing.JTextField physicalText;
    private javax.swing.JRadioButton rollRadioButton;
    private javax.swing.JButton sortListButton;
    private javax.swing.JLabel stunLabel;
    private javax.swing.JTextField stunText;
    private javax.swing.JButton substract5IniButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public JList<String> getDiceJList() {
        return diceJList;
    }

    public void setDiceJList(JList<String> diceJList) {
        this.diceJList = diceJList;
    }

    public JButton getForceRollButton() {
        return forceRollButton;
    }

    public void setForceRollButton(JButton forceRollButton) {
        this.forceRollButton = forceRollButton;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JButton getMakeHisTurnButton() {
        return makeHisTurnButton;
    }

    public void setMakeHisTurnButton(JButton makeHisTurnButton) {
        this.makeHisTurnButton = makeHisTurnButton;
    }
    
    JButton getAdd5IniButton() {
        return add5IniButton;
    }
    
    void setAdd5IniButton(JButton add5IniButton){
        this.add5IniButton = add5IniButton;
    }
    
    JButton getSubstract5IniButton() {
        return substract5IniButton;
    }
    
    void setSubstract5IniButton(JButton substract5IniButton){
        this.substract5IniButton = substract5IniButton;
    }
}
