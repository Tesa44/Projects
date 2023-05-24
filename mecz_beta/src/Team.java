import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Team {
    private String name;
    private int attackStrength;
    private int defenceStrength;
    private int form;
    private int tactics;
    public int gkAccurity;
    private int wins;
    private int loses;
    private int goalsScored;
    private int goalsLosed;
    private int draw;
    private int points;
    public boolean ifPlayer;
    private int games;

    public Team(String name, int attackStrength, int defenceStrength, int form, int tactics,int gkAccurity, boolean ifPlayer) {
        this.name = name;
        this.attackStrength = attackStrength;
        this.defenceStrength = defenceStrength;
        this.form = form;
        this.tactics = tactics;
        this.gkAccurity=gkAccurity;
        this.wins = 0;
        this.loses = 0;
        this.goalsScored = 0;
        this.goalsLosed = 0;
        this.draw = 0;
        this.points = 0;
        this.ifPlayer = ifPlayer;
        this.games=0;
    }

    public String getName() {
        return name;
    }

    public int getAttackStrength() {
        return attackStrength;
    }

    public int getDefenceStrength() {
        return defenceStrength;
    }

    public int getForm() {
        return form;
    }

    public int getTactics() {
        return tactics;
    }

    public int getGames() {
        return games;
    }

    public HashSet<Integer> wypelnijObrone(){
        HashSet<Integer> defencePoints=new HashSet<Integer>();
        Random generator = new Random();
        int i = 0;
        while (defencePoints.size() < gkAccurity) {
            defencePoints.add(generator.nextInt(18) + 1);
        }
        return defencePoints;
    }
    public void wyswietlObrone(HashSet<Integer> defencePoints){
        Iterator itr = defencePoints.iterator();
        while (itr.hasNext()) {
            System.out.printf("%d ",itr.next());
        }
        System.out.printf("\n");

    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsLosed() {
        return goalsLosed;
    }

    public void setGoalsLosed(int goalsLosed) {
        this.goalsLosed = goalsLosed;
    }

    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setForm(int form) {
        this.form = form;
    }

    public void setGames(int games) {
        this.games = games;
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