package Character;
import Player.Player;

import java.util.Scanner;

public class Wizard extends Hero {
    public Wizard()
    {
        this.name="Merlin";
        this.healthBar=150.0;
        this.gender='m';
    }



    @Override
    public void attacks(Player[] arr) {
        System.out.println("Chose your opponent");
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<3;++i)
        {
            System.out.println((i)+1 +": " + arr[1].team[i].getName());
        }
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
                for(int i=0;i<3;++i)
                {
                    arr[0].team[i].setHealthBar(arr[0].team[i].getHealthBar() + 20.5);
                }
            }

            case 4:
            {
                for(int i=0;i<arr.length;++i)
                {
                    arr[1].team[i].setHealthBar(arr[1].team[i].getHealthBar()-40.0);
                }
                break;
            }
        }
    }

    @Override
    public void listOfAttacks() {
        System.out.println("Please select one of powers");
        System.out.println("1: Lightning bolt (decreases opponents life by 18.0)");
        System.out.println("2: Fire ball (decreases opponents life by 15.0)");
        System.out.println("3: Healing spell(increases team members  health bars by 20.5)");
        System.out.println("4: Wrath of Gods (super move decreases all opponents health bar by 40.0)");
    }
}
