package oracledocs;

import java.util.Objects;

class Main {

    public static void main(String[] args) {
        Monsters monsterList = new Monsters();
        monsterList.addNewMonster("Cacodemon");
        monsterList.addNewMonster("Goblin Warrior");
        monsterList.addNewMonster("Kobold Sorcerer");
        monsterList.addNewMonster("Ogre-mage");
        monsterList.addNewMonster("Dracolich");
        monsterList.addNewMonster("Sewer Rat");

        String desiredEnemy;
        do {
            desiredEnemy = monsterList.pickRandomMonsterFromList();
            System.out.println(desiredEnemy);
        } while (!Objects.equals(desiredEnemy, "Dracolich"));
        System.out.println("Tada!");

    }

}
