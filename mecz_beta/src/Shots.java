import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;



public class Shots {
    public void goalPicture(){
        System.out.println("=====================");
        System.out.println("|| 1  2  3  4  5  6||");
        System.out.println("|| 7  8  9 10 11 12||");
        System.out.println("||13 14 15 16 17 18||");

    }
    public static boolean czyGol(HashSet<Integer> defencePoints, boolean ifPlayer, boolean playerIsShooting){
        if (ifPlayer && playerIsShooting) {
            GetNumber getNumberWhereToShot = new GetNumber();
            int strzal = getNumberWhereToShot.getNumberWhereToShot();
            if (defencePoints.contains(strzal)) {
                System.out.println("Nie ma gola, bramkarz swietnie obronił");
                System.out.println();
                return false;
            } else {
                System.out.println("Gooool!!!");
                System.out.println();
                return true;
            }
        }
        else if (ifPlayer){
            Random random = new Random();
            int strzal = random.nextInt(18) + 1;
            System.out.println("Druzyna przeciwna strzelila w punkt "+ strzal);

            //        if (city.getName()!=null){name = city.getName();}else{name="N/A"}

            if(defencePoints.contains(strzal)) {
                { System.out.println("nie ma gola, bramkarz swietnie obronił \n");}
                return false;
            }
            else{
                {System.out.println("gooool!!!\n");}
                return true;
            }
        }
        else{
            Random random = new Random();
            int strzal = random.nextInt(18) + 1;
            return !defencePoints.contains(strzal);
        }
    }
//    public static boolean czyGolGoscie(HashSet defencePoints,boolean ifPlayer){
//
//        Random random = new Random();
//                 int strzal = random.nextInt(18) + 1;
//                 if (ifPlayer){ System.out.println("Druzyna przeciwna strzelila w punkt "+ strzal);}
//
//         //        if (city.getName()!=null){name = city.getName();}else{name="N/A"}
//
//                 if(defencePoints.contains(strzal)) {
//                     if (ifPlayer){ System.out.println("nie ma gola, bramkarz swietnie obronił \n");}
//                     return false;
//                 }
//                 else{
//                     if(ifPlayer){System.out.println("gooool!!!\n");}
//                     return true;
//                 }
//    }
}
