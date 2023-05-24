import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Wybierz tryb gry: \n-rozegraj pełną lige(wybierz 1)\n-zagraj mecz wybranymi zespołami(wybierz 2)\n-zagraj mecz losowymi zespołami(wybierz 3)\n");
        int choice = scanner.nextInt();
        if(choice==1){
            RunLigue runLigue = new RunLigue();
            runLigue.roundRobin();
        }
        else if(choice==2){
            RunMatch runMatch = new RunMatch();
            runMatch.runMatch(false);
        } else if (choice==3) {
            RunMatch runMatch = new RunMatch();
            runMatch.runMatch(true);
        }

    }
}
