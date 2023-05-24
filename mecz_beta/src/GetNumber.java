import java.util.Scanner;

public class GetNumber {

    public int getNumberWhereToShot(){
        System.out.println("Wyceluj w bramke podając odpowiednia liczbe: ");
        Scanner scan = new Scanner(System.in);
        int shot = scan.nextInt();
        if(shot > 18 || shot < 1){
            System.out.println("Liczba poza zakresem, spróbuj wpisać inną");
            return getNumberWhereToShot();
        }
        else{
            return shot;
        }
    }
    public int getNumberOfSkill(){
        System.out.println("Wpisz wartość 0 - 100");
        Scanner scan = new Scanner(System.in);
        int skill = scan.nextInt();
        if(skill > 100 || skill < 0){
            System.out.println("Liczba poza zakresem, spróbuj wpisać inną");
            return getNumberOfSkill();
        }else{
            return skill;
        }
    }
    public String getNameOfMyTeam(){
        System.out.println("Wpisz nazwe twojej drużyny");
        Scanner scan = new Scanner(System.in);
        String nameOfMyTeam = scan.nextLine();
        return nameOfMyTeam;
    }
    public int getGoalkeeperSkill(){
        System.out.println("Wpisz wartość skillu bramkarza 0 - 18");
        Scanner scan = new Scanner(System.in);
        int skill = scan.nextInt();
        if(skill > 18 || skill < 0){
            System.out.println("Liczba poza zakresem, spróbuj wpisać inną");
            return getGoalkeeperSkill();
        }
        else{
            return skill;
        }
    }
}
