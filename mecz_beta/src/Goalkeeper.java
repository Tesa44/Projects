import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

public class Goalkeeper {
    private String name,surname;
    public int defence;

    public Goalkeeper(String name, String surname, int defence) {
        this.name = name;
        this.surname = surname;
        this.defence = defence;
    }

    public HashSet wypelnijObrone(int defence){
        HashSet defencePoints=new HashSet();
        Random generator = new Random();
        for(int i=0;defencePoints.size()<defence;i++){
            defencePoints.add(generator.nextInt(18));

        }
        return defencePoints;
    }
}
