/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodm;

/**
 *
 * @author HERMES
 */
public class Character implements Comparable<Character>{
    String name;
    int stun, physical, initiativeDie, initiativeBonus, maxPhysical, maxStun;
    boolean simplifiedHealth, rollInitiative, isHisTurn;
    // Must be 0 in case a Character is created but hasn't had his initiative
    // rolled yet.
    int initiative;
    
    public Character(String name, int stun, int physical, boolean simplifiedHealth, boolean rollInitiative, int initiativeDie, int initiativeBonus, int initiative){
        this.name = name; this.stun = stun; this.physical = physical;
        this.simplifiedHealth = simplifiedHealth; this.rollInitiative = rollInitiative;
        this.initiativeDie = initiativeDie; this.initiativeBonus = initiativeBonus; this.initiative = initiative;
        if( !rollInitiative ) { this.initiative = initiative; }
    }
    @Override
    public int compareTo(Character charToCompare){
        if( charToCompare.getInitiative() > this.initiative ) { return 1; }
        else { return -1; }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getStun() {
        return stun;
    }

    public int getInitiativeDie() {
        return initiativeDie;
    }

    public void setInitiativeDie(int initiativeDie) {
        this.initiativeDie = initiativeDie;
    }

    public int getInitiativeBonus() {
        return initiativeBonus;
    }

    public void setInitiativeBonus(int initiativeBonus) {
        this.initiativeBonus = initiativeBonus;
    }

    public boolean isSimplifiedHealth() {
        return simplifiedHealth;
    }

    public void setSimplifiedHealth(boolean simplifiedHealth) {
        this.simplifiedHealth = simplifiedHealth;
    }

    public boolean isRollInitiative() {
        return rollInitiative;
    }

    public void setRollInitiative(boolean rollInitiative) {
        this.rollInitiative = rollInitiative;
    }

    public boolean isIsHisTurn() {
        return isHisTurn;
    }

    public void setIsHisTurn(boolean isHisTurn) {
        this.isHisTurn = isHisTurn;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }
    public void setStun(int stun) {
        this.stun = stun;
    }
    public int getPhysical() {
        return physical;
    }
    public void setPhysical(int physical) {
        this.physical = physical;
    }
    int getMaxStun(){
        return maxStun;
    }
    int getMaxPhysical(){
        return maxPhysical;
    }
}
