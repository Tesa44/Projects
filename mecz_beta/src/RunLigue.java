import java.util.HashSet;

public class RunLigue {
//    public Team[] teamsDataBase;

    public RunLigue() {
    }

    public void roundRobin() {
        GetTeams getTeam = new GetTeams();
        Team myTeam = getTeam.makeTeam();
//        HashSet<Team> DataBase = new HashSet<>();
//        DataBase = getTeam.dataBaseTeams(myTeam);
//        Team[] teamsDataBase = DataBase.toArray(new Team[DataBase.size()]);
        Team[] teamsDataBase = getTeam.dataBaseTeams(myTeam);
        int n = teamsDataBase.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.println("Round " + (i + 1));
            for (int j = 0; j < n / 2; j++) {
                int team1 = (i + j) % (n - 1);
                int team2 = (n - 1 - j + i) % (n - 1);
                if (j == 0) {
                    team2 = n - 1;
//                    System.out.println(teamsDataBase[team1].getName() + " vs " + teamsDataBase[team2].getName());
                    SoccerMatch soccerMatch = new SoccerMatch(teamsDataBase[team1], teamsDataBase[team2]);
                    if (teamsDataBase[team1].ifPlayer || teamsDataBase[team2].ifPlayer) {
                        soccerMatch.simulate(true);
                        soccerMatch.getWinner();
                    } else {
                        soccerMatch.simulate(false);
                        soccerMatch.getWinner();
                    }
                }
                else {
//                    System.out.println(teamsDataBase[team1].getName() + " vs " + teamsDataBase[team2].getName());
                    SoccerMatch soccerMatch = new SoccerMatch(teamsDataBase[team1], teamsDataBase[team2]);
                    if (teamsDataBase[team1].ifPlayer || teamsDataBase[team2].ifPlayer) {
                        soccerMatch.simulate(true);
                        soccerMatch.getWinner();
                    } else {
                        soccerMatch.simulate(false);
                        soccerMatch.getWinner();
                    }
                }
            }
//            rotateTeams(teamsDataBase,i);
        }
        Table table = new Table(teamsDataBase[0], teamsDataBase[1], teamsDataBase[2], teamsDataBase[3], teamsDataBase[4], teamsDataBase[5]);
        table.printTable();
    }


}
