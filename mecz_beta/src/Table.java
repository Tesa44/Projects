import java.util.Arrays;

public class Table {
    private Team[] sortingTeams = new Team[6];
    public Table(Team firstTeam,Team secondTeam,Team thirdTeam,Team fourthTeam,Team fifthTeam,Team sixthTeam){
        this.sortingTeams[0] = firstTeam;
        this.sortingTeams[1] = secondTeam;
        this.sortingTeams[2] = thirdTeam;
        this.sortingTeams[3] = fourthTeam;
        this.sortingTeams[4] = fifthTeam;
        this.sortingTeams[5] = sixthTeam;
    }
    void printTable(){

        int k = 0;
        for(int j = 0; j < sortingTeams.length - 1; j++){
            for (int i = 0; i < sortingTeams.length - 1; i++){
                if(sortingTeams[i].getPoints() < sortingTeams[i+1].getPoints()){
                    Team a = sortingTeams[i];
                    sortingTeams[i] = sortingTeams[i+1];
                    sortingTeams[i+1] = a;
                }
                else if (sortingTeams[i].getPoints() == sortingTeams[i+1].getPoints()){
                    if(sortingTeams[i].getGoalsScored()-sortingTeams[i].getGoalsLosed() < sortingTeams[i+1].getGoalsScored()-sortingTeams[i+1].getGoalsLosed()){
                        Team a = sortingTeams[i];
                        sortingTeams[i] = sortingTeams[i+1];
                        sortingTeams[i+1] = a;
                    }
                }
            }
        }
        System.out.printf("Team             | games | points | wins | loses | draws | goals | \n");
        System.out.printf("%-16s | %5d | %6d | %4d | %5d | %5d | %+5d |\n",sortingTeams[0].getName(),sortingTeams[0].getGames(),sortingTeams[0].getPoints(),sortingTeams[0].getWins(),sortingTeams[0].getLoses(),sortingTeams[0].getDraw(),sortingTeams[0].getGoalsScored()-sortingTeams[0].getGoalsLosed());
        System.out.printf("%-16s | %5d | %6d | %4d | %5d | %5d | %+5d |\n",sortingTeams[1].getName(),sortingTeams[1].getGames(),sortingTeams[1].getPoints(),sortingTeams[1].getWins(),sortingTeams[1].getLoses(),sortingTeams[1].getDraw(),sortingTeams[1].getGoalsScored()-sortingTeams[1].getGoalsLosed());
        System.out.printf("%-16s | %5d | %6d | %4d | %5d | %5d | %+5d |\n",sortingTeams[2].getName(),sortingTeams[2].getGames(),sortingTeams[2].getPoints(),sortingTeams[2].getWins(),sortingTeams[2].getLoses(),sortingTeams[2].getDraw(),sortingTeams[2].getGoalsScored()-sortingTeams[2].getGoalsLosed());
        System.out.printf("%-16s | %5d | %6d | %4d | %5d | %5d | %+5d |\n",sortingTeams[3].getName(),sortingTeams[3].getGames(),sortingTeams[3].getPoints(),sortingTeams[3].getWins(),sortingTeams[3].getLoses(),sortingTeams[3].getDraw(),sortingTeams[3].getGoalsScored()-sortingTeams[3].getGoalsLosed());
        System.out.printf("%-16s | %5d | %6d | %4d | %5d | %5d | %+5d |\n",sortingTeams[4].getName(),sortingTeams[4].getGames(),sortingTeams[4].getPoints(),sortingTeams[4].getWins(),sortingTeams[4].getLoses(),sortingTeams[4].getDraw(),sortingTeams[4].getGoalsScored()-sortingTeams[4].getGoalsLosed());
        System.out.printf("%-16s | %5d | %6d | %4d | %5d | %5d | %+5d |\n",sortingTeams[5].getName(),sortingTeams[5].getGames(),sortingTeams[5].getPoints(),sortingTeams[5].getWins(),sortingTeams[5].getLoses(),sortingTeams[5].getDraw(),sortingTeams[5].getGoalsScored()-sortingTeams[5].getGoalsLosed());
    }
}
