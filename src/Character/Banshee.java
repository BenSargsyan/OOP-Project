package Character;
import Interface.GameService;
import Player.Player;
import java.util.Scanner;

public class Banshee extends Hero {
    public Banshee()
    {
        this.name="Banshee";
        this.healthBar=180.0;
        this.gender='f';
    }

    @Override
    public void attacks(Player[] arr) {
        System.out.println("Chose your opponent");
        Scanner sc=new Scanner(System.in);
        GameService.printPlayerTeam(arr[0]);
        int y=sc.nextInt()-1;
        System.out.println("Chose your attack type");
        listOfAttacks();

        int x=sc.nextInt();


        switch (x)
        {
            case 1 :
            {
                arr[1].team[y].setHealthBar(arr[1].team[y].getHealthBar()-19.8);
                break;
            }
            case 2 :
            {
                arr[1].team[y].setHealthBar(arr[1].team[y].getHealthBar()-28.1);
                break;
            }
            case 3:
            {

                arr[1].team[y].setHealthBar(arr[1].team[y].getHealthBar()-25.3);
                break;
            }

            case 4:
                arr[1].team[y].setHealthBar(arr[1].team[y].getHealthBar()-39.5);

        }
    }



    @Override
    public void listOfAttacks() {
        System.out.println("1: SuperSonic scream (decreases opponents health by 24.8)");
        System.out.println("2: Cursed strike  (decreases opponents health by 28.1)");
        System.out.println("3: SuperKick  (decreases opponents health by 25.3)");
        System.out.println("4: Banshees scream  (decreases opponents health by 39.5)");
    }
}