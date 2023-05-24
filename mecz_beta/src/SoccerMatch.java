import java.util.Random;

import static java.lang.Math.round;

public class SoccerMatch {
    final Team homeTeam;
    final Team awayTeam;
    private int homeGoals;
    private int awayGoals;
    private boolean isFinished;
    private int defense;
    private int goalkeeperHome;
    private int goalkeeperAway;
    public SoccerMatch(Team awayTeam, Team homeTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoals = 0;
        this.awayGoals = 0;
        this.isFinished = false;
        this.goalkeeperAway = awayTeam.gkAccurity;
        this.goalkeeperHome = homeTeam.gkAccurity;
    }

    public void simulate(boolean ifPlayer) {
        double homeAttackStrength = homeTeam.getAttackStrength();
        double awayAttackStrength = awayTeam.getAttackStrength();
        double homeDefenceStrength = homeTeam.getDefenceStrength();
        double awayDefenceStrength = awayTeam.getDefenceStrength();
        double homeForm = homeTeam.getForm();
        double awayForm = awayTeam.getForm();
        double homeTactics = homeTeam.getTactics();
        double awayTactics = awayTeam.getTactics();

        Random random = new Random();
        Shots shots = new Shots();
        if(ifPlayer) System.out.println("Starting match: " + homeTeam.getName() + " vs " + awayTeam.getName());
        double homeScoreChance = ((homeAttackStrength + homeForm + homeTactics) / (awayDefenceStrength + awayForm ));
        double awayScoreChance = ((awayAttackStrength + awayForm + awayTactics) / (homeDefenceStrength + homeForm ));
        System.out.printf("Szanse na sytuacje podbramkowe dla %s %.2f%% w kazdej minucie\n",homeTeam.getName(),homeScoreChance*100/40);
        System.out.printf("Szanse na sytuacje podbramkowe dla %s %.2f%% w kazdej minucie\n",awayTeam.getName(),awayScoreChance*100/40);

        for (int minute = 1; minute <= 90; minute+=1) {



            //MY GRAMY
            if (ifPlayer) {

                if (random.nextDouble(40)  < homeScoreChance) {
//                    awayTeam.wyswietlObrone(awayTeam.wypelnijObrone());

                    //                shots.czyGol(awayTeam.goalkeeper.wypelnijObrone(goalkeeper.defence));
                    System.out.println(minute + " minuta. Szansa na gola dla naszej drużyny!");
                    shots.goalPicture();
                    if (shots.czyGol(homeTeam.wypelnijObrone(),true,true)) {
                        homeGoals++;

                        System.out.println(minute + "': " + homeTeam.getName() + " scores! " +
                                homeTeam.getName() + " " + homeGoals + " - " + awayTeam.getName() + " " + awayGoals);
                    }
                }
                else if (random.nextDouble(40) < awayScoreChance) {
//                    shots.goalPicture();
//                    homeTeam.wyswietlObrone(homeTeam.wypelnijObrone());
                    System.out.println(minute + " minuta. Szansa na gola dla przeciwnej drużyny!");
                    if (shots.czyGol(awayTeam.wypelnijObrone(),false,false)) {
                        awayGoals++;
                        System.out.println(minute + "': " + awayTeam.getName() + " scores! " +
                                homeTeam.getName() + " " + homeGoals + " - " + awayTeam.getName() + " " + awayGoals);
                    }
                }

                //GRAJA BOTY
            } else {
                if (random.nextDouble(40)  < homeScoreChance) {

                    //                shots.czyGol(awayTeam.goalkeeper.wypelnijObrone(goalkeeper.defence));
                    if (shots.czyGol(homeTeam.wypelnijObrone(),false,false)) {
                        homeGoals++;
                    }
                }
                if (random.nextDouble(40)  < awayScoreChance) {
                    if (shots.czyGol(awayTeam.wypelnijObrone(),false,false)) {
                        awayGoals++;
                    }
                }

            }
        }
        System.out.println("Match results: " + homeTeam.getName() + " " + homeGoals + " - " +
                awayTeam.getName() + " " + awayGoals);

        isFinished = true;
        //Aktualizowanie statystyk trafionych i straconych bramek dla pierwszej drużyny
        homeTeam.setGoalsScored(homeTeam.getGoalsScored()+homeGoals);
        homeTeam.setGoalsLosed(homeTeam.getGoalsLosed()+awayGoals);
        //Aktualizowanie statystyk trafionych i straconych bramek dla drugiej drużyny
        awayTeam.setGoalsScored(awayTeam.getGoalsScored()+awayGoals);
        awayTeam.setGoalsLosed(awayTeam.getGoalsLosed()+homeGoals);
        homeTeam.setGames(homeTeam.getGames()+1);
        awayTeam.setGames(awayTeam.getGames()+1);
    }

    public boolean isFinished() {
        return isFinished;
    }

    public String getWinner() {
        if (!isFinished) {
            return null;
        }

        if (homeGoals > awayGoals) {
            homeTeam.setWins(homeTeam.getWins()+1);
            homeTeam.setPoints(homeTeam.getPoints()+3);
            awayTeam.setLoses(awayTeam.getLoses()+1);
            homeTeam.setForm(homeTeam.getForm()+10);
            awayTeam.setForm(awayTeam.getForm()-10);
            return homeTeam.getName();
        } else if (awayGoals > homeGoals) {
            awayTeam.setWins(awayTeam.getWins()+1);
            awayTeam.setPoints(awayTeam.getPoints()+3);
            homeTeam.setLoses(homeTeam.getLoses()+1);
            homeTeam.setForm(homeTeam.getForm()-10);
            awayTeam.setForm(awayTeam.getForm()+10);
            return awayTeam.getName();
        } else {
            awayTeam.setDraw(awayTeam.getDraw()+1);
            homeTeam.setDraw(homeTeam.getDraw()+1);
            awayTeam.setPoints(awayTeam.getPoints()+1);
            homeTeam.setPoints(homeTeam.getPoints()+1);
            return "draw";
        }
    }
}