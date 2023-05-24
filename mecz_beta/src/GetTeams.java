import java.util.HashSet;
import java.util.Scanner;

public class GetTeams {
    public Team makeTeam() {
        GetNumber getNumber = new GetNumber();
        System.out.println("Stwórz własną drużyne!");
        String name = getNumber.getNameOfMyTeam();
        System.out.println("Dobra nazwa");
        System.out.println("Atak siła: ");
        int attackStrength = getNumber.getNumberOfSkill();
        System.out.println("Defensywna siła: ");
        int defensePoints = getNumber.getNumberOfSkill();
        System.out.println("Forma drużyny: ");
        int form = getNumber.getNumberOfSkill();
        System.out.println("Umiejętności taktyczne: " );
        int tactics = getNumber.getNumberOfSkill();
        System.out.println("Umiejętności bramkarza: ");
        int gkAccurity = getNumber.getGoalkeeperSkill();
        Team myTeam = new Team(name,attackStrength,defensePoints,form,tactics,gkAccurity,true);
        return myTeam;
    }

    public Team[] dataBaseTeams(Team myTeam) {

        HashSet<Team> DataBase = new HashSet<>();

        Team team1 = new Team("Real_Madryt", 90, 35, 90, 70, 9,false);
        Team team2 = new Team("FC_Barcelona", 70, 80, 90, 80, 10,false);
        Team team3 = new Team("Chelsea", 60, 75, 85, 50, 11,false);
        Team team4 = new Team("Manchester_City", 80, 45, 80, 90, 7,false);
        Team team5 = new Team("Bayern_Monachium", 40, 23, 60, 60, 9,false);
        DataBase.add(team1);
        DataBase.add(team2);
        DataBase.add(team3);
        DataBase.add(team4);
        DataBase.add(team5);
        DataBase.add(myTeam);
        Team[] test = {team1,team2,team3,team4,team5,myTeam};
        return test;
    }
    public HashSet<Team> dataBaseTeams() {

        HashSet<Team> DataBase = new HashSet<>();
        Team team1 = new Team("Real_Madryt", 90, 35, 90, 70, 9, false);
        Team team2 = new Team("FC_Barcelona", 70, 80, 90, 80, 10, false);
        Team team3 = new Team("Chelsea", 60, 75, 85, 50, 11, false);
        Team team4 = new Team("Manchester_City", 80, 45, 80, 90, 7, false);
        Team team5 = new Team("Bayern_Monachium", 40, 23, 60, 60, 9, false);
        DataBase.add(team1);
        DataBase.add(team2);
        DataBase.add(team3);
        DataBase.add(team4);
        DataBase.add(team5);
        return DataBase;
    }
}

