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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author HERMES
 */
//TODO: (COOL FEATURE) Add a Remove Dead button.
//TODO: (IMPORTANT FEATURE) Make the UI not cause blindness, vomits and psychosis.
public class GUI extends javax.swing.JFrame {
    
    List<Character> characters = new ArrayList<Character>();
    DefaultListModel<String> dieJListModel = new DefaultListModel();
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

        jPanel1 = new javax.swing.JPanel();
        rollDieSpinner = new javax.swing.JSpinner();
        rollDieButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        dieJList = new javax.swing.JList<>();
        massPerceptionRollButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        substract5IniButton = new javax.swing.JButton();
        add5IniButton = new javax.swing.JButton();
        pcInitiativeText = new javax.swing.JTextField();
        equalsLabel = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        healthRadioButton = new javax.swing.JRadioButton();
        initiativeBonusLabel = new javax.swing.JLabel();
        initiativeBonusText = new javax.swing.JTextField();
        rollRadioButton = new javax.swing.JRadioButton();
        updateButton = new javax.swing.JButton();
        perceptionTextField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        physicalLabel = new javax.swing.JLabel();
        initiativeLabel = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        physicalText = new javax.swing.JTextField();
        npcInitiativeText = new javax.swing.JTextField();
        stunLabel = new javax.swing.JLabel();
        stunText = new javax.swing.JTextField();
        saveCharacterButton = new javax.swing.JButton();
        perceptionLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        loadCharacterButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        loadableCharactersList = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        sortListButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        characterJList = new javax.swing.JList<>();
        nextTurnButton = new javax.swing.JButton();
        makeHisTurnButton = new javax.swing.JButton();
        forceRollButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Die rolls"));

        rollDieButton.setText("Roll");

        jScrollPane2.setViewportView(dieJList);

        massPerceptionRollButton.setText("Mass Perception Roll");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(rollDieSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rollDieButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(massPerceptionRollButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rollDieSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rollDieButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(massPerceptionRollButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Character Editor"));

        substract5IniButton.setName(""); // NOI18N

        pcInitiativeText.setBackground(new java.awt.Color(214, 217, 223));
        pcInitiativeText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pcInitiativeText.setText("0");
        pcInitiativeText.setAlignmentX(1.0F);
        pcInitiativeText.setBorder(null);

        equalsLabel.setText("=");

        deleteButton.setText("Delete");

        healthRadioButton.setSelected(true);
        healthRadioButton.setText("Simplified");
        healthRadioButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        healthRadioButton.setBorderPainted(true);
        healthRadioButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        initiativeBonusLabel.setText("d6    +");

        initiativeBonusText.setBackground(new java.awt.Color(214, 217, 223));
        initiativeBonusText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        initiativeBonusText.setText("0");
        initiativeBonusText.setBorder(null);

        rollRadioButton.setSelected(true);
        rollRadioButton.setText("Roll");
        rollRadioButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        rollRadioButton.setBorderPainted(true);
        rollRadioButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        updateButton.setLabel("Add/Update");

        nameLabel.setText("Name");

        physicalLabel.setText("Health");

        initiativeLabel.setText("Initiative");

        physicalText.setBackground(new java.awt.Color(214, 217, 223));
        physicalText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        physicalText.setText("0");
        physicalText.setAlignmentX(0.0F);
        physicalText.setAlignmentY(0.0F);
        physicalText.setBorder(null);

        npcInitiativeText.setBackground(new java.awt.Color(214, 217, 223));
        npcInitiativeText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        npcInitiativeText.setText("0");
        npcInitiativeText.setAlignmentX(0.0F);
        npcInitiativeText.setBorder(null);
        npcInitiativeText.setOpaque(false);

        stunLabel.setText("Stun");

        stunText.setBackground(new java.awt.Color(214, 217, 223));
        stunText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        stunText.setText("0");
        stunText.setBorder(null);

        saveCharacterButton.setText("Save To Disk");

        perceptionLabel.setText("Perception");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(updateButton)
                        .addGap(4, 4, 4)
                        .addComponent(deleteButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(nameLabel)
                        .addGap(4, 4, 4)
                        .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(perceptionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(perceptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveCharacterButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(healthRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(physicalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(physicalText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stunLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stunText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rollRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(initiativeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(npcInitiativeText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(initiativeBonusLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(initiativeBonusText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(equalsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pcInitiativeText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(add5IniButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(substract5IniButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(nameLabel))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(perceptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(saveCharacterButton)
                        .addComponent(perceptionLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stunLabel)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(healthRadioButton)
                        .addComponent(physicalLabel)
                        .addComponent(physicalText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(stunText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rollRadioButton)
                        .addComponent(initiativeLabel)
                        .addComponent(npcInitiativeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(initiativeBonusLabel)
                        .addComponent(initiativeBonusText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pcInitiativeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(equalsLabel))
                    .addComponent(add5IniButton, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(substract5IniButton, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(deleteButton)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Character Loader"));

        loadCharacterButton.setText("Load Selected");

        jScrollPane3.setViewportView(loadableCharactersList);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadCharacterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loadCharacterButton))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Round Manager"));

        sortListButton.setText("Sort List");
        sortListButton.setActionCommand("sortListButton");

        characterJList.setMaximumSize(new java.awt.Dimension(215, 80));
        characterJList.setMinimumSize(new java.awt.Dimension(200, 80));
        jScrollPane1.setViewportView(characterJList);

        nextTurnButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nextTurnButton.setText("Next Pass");

        makeHisTurnButton.setText("Make Selected's Turn");
        makeHisTurnButton.setActionCommand("Turn to this char");

        forceRollButton.setText("Force Roll");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(nextTurnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sortListButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makeHisTurnButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(forceRollButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextTurnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortListButton)
                    .addComponent(makeHisTurnButton)
                    .addComponent(forceRollButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public JFrame getJFrame() {
        return (JFrame) SwingUtilities.getWindowAncestor(getHealthRadioButton());
    }
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

    public JTextField getInitiativeBonusText() {
        return initiativeBonusText;
    }

    public void setInitiativeBonusText(JTextField initiativeText) {
        this.initiativeBonusText = initiativeText;
    }
    
    public void setPcInitiativeText(JTextField initiativeText) {
        this.pcInitiativeText = initiativeText;
    }
    
    public JTextField getPcInitiativeText() {
        return pcInitiativeText;
    }

    public JLabel getInitiativeLabel() {
        return initiativeLabel;
    }

    public void setInitiativeLabel(JLabel initiativeLabel) {
        this.initiativeLabel = initiativeLabel;
    }

    public JTextField getNpcInitiativeText() {
        return npcInitiativeText;
    }

    public void setNpcInitiativeText(JTextField initiativeBonusText) {
        this.npcInitiativeText = initiativeBonusText;
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
    
    public JButton getSaveCharacterButton(){
        return this.saveCharacterButton;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }
    
    public JLabel getEqualsLabel(){
        return equalsLabel;
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
    
    public JButton getDeleteButton() {
        return deleteButton;
    }
    
    public JButton getRollDieButton(){
        return rollDieButton;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add5IniButton;
    private javax.swing.JList<String> characterJList;
    private javax.swing.JButton deleteButton;
    private javax.swing.JList<String> dieJList;
    private javax.swing.JLabel equalsLabel;
    private javax.swing.JButton forceRollButton;
    private javax.swing.JRadioButton healthRadioButton;
    private javax.swing.JLabel initiativeBonusLabel;
    private javax.swing.JTextField initiativeBonusText;
    private javax.swing.JLabel initiativeLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton loadCharacterButton;
    private javax.swing.JList<String> loadableCharactersList;
    private javax.swing.JButton makeHisTurnButton;
    private javax.swing.JButton massPerceptionRollButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameText;
    private javax.swing.JButton nextTurnButton;
    private javax.swing.JTextField npcInitiativeText;
    private javax.swing.JTextField pcInitiativeText;
    private javax.swing.JLabel perceptionLabel;
    private javax.swing.JTextField perceptionTextField;
    private javax.swing.JLabel physicalLabel;
    private javax.swing.JTextField physicalText;
    private javax.swing.JButton rollDieButton;
    private javax.swing.JSpinner rollDieSpinner;
    private javax.swing.JRadioButton rollRadioButton;
    private javax.swing.JButton saveCharacterButton;
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

    public JList<String> getDieJList() {
        return dieJList;
    }

    public JButton getForceRollButton() {
        return forceRollButton;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public JButton getMakeHisTurnButton() {
        return makeHisTurnButton;
    }
    
    JButton getAdd5IniButton() {
        return substract5IniButton;
    }
    
    JButton getSubstract5IniButton() {
        return add5IniButton;
    }
    
    JButton getLoadCharacterButton(){
        return loadCharacterButton;
    }
    
    JTextField getPerceptionText(){
        return perceptionTextField;
    }
    JButton getMassPerceptionRollButton(){
        return massPerceptionRollButton;
    }
    
    JSpinner getRollDieSpinner(){
        return rollDieSpinner;
    }
    
    JList getLoadableCharactersList(){
        return loadableCharactersList;
    }
}
