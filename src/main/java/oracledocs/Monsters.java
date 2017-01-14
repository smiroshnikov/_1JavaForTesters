package oracledocs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monsters {
    Random R = new Random();
    private List<String> monsters = new ArrayList<>();

    public void addNewMonster(String monster) {
        monsters.add(monster);
    }

    public String pickRandomMonsterFromList() {
        int randomSeed = R.nextInt(monsters.size());
        return monsters.get(randomSeed);
    }


}
