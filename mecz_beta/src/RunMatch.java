import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class RunMatch {
    public void runMatch(boolean czyLosowy){
        Scanner scanner = new Scanner(System.in);
        GetTeams getTeam = new GetTeams();
        HashSet<Team> DataBase = new HashSet<>();
        DataBase = getTeam.dataBaseTeams();
        Team[] teamsDataBase = DataBase.toArray(new Team[DataBase.size()]);
        if(czyLosowy){
            Random generator = new Random();
            int homeTeam=generator.nextInt(4);
            int awayTeam=homeTeam;
            while (homeTeam==awayTeam){
                awayTeam=generator.nextInt(4);
            }
            SoccerMatch soccerMatch = new SoccerMatch(teamsDataBase[homeTeam],teamsDataBase[awayTeam]);
            soccerMatch.simulate(true);
            soccerMatch.getWinner();
        }
        else{
            System.out.printf("1-Real Madryt\n2-FC Barcelona\n3-Manchester_City\n4-Chelsea\n5-Bayern Monachium\n");
            System.out.println("Wybierz swoją drużyne: ");
            int choice1 = scanner.nextInt();
            System.out.println("Wybierz drużyne rywala: ");
            int choice2 = scanner.nextInt();
            SoccerMatch soccerMatch = new SoccerMatch(teamsDataBase[choice1-1],teamsDataBase[choice2-1]);
            soccerMatch.simulate(true);
            soccerMatch.getWinner();
        }

    }
}
