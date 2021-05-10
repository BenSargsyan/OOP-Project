package Character;
import Player.Player;

import java.util.Scanner;

public class Lamia extends Hero {
    public Lamia()
    {
        this.name="Lamia";
        this.healthBar=190.23;
        this.gender='f';
    }

    @Override
    public void attacks(Player[] arr) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Chose your attack type");
        listOfAttacks();

        int x=sc.nextInt();
        if(x==4)
        {

            System.out.println("Choose which Characters power you want to use)");
            for(int i=0;i<3;++i)
            {
                System.out.println((i+1)+ ": " +arr[1].team[i].getName());
            }
            int choice=sc.nextInt()-1;
            if(arr[1].team[choice] instanceof Lamia)
            {
                System.out.println("You can't chose this character " +
                        " chose any character except Lamia");

                choice=sc.nextInt()-1;
            }
            arr[1].team[choice].attacks(arr);
            return;
        }

        System.out.println("Chose your opponent");
        for(int i=0;i<3;++i)
        {
            System.out.println((i+1) +": " + arr[1].team[i].getName());
        }
        int y=sc.nextInt();
        switch (x)
        {
            case 1 :
            {
                arr[1].team[y].setHealthBar(arr[1].team[y].getHealthBar()-23.3);
                break;
            }
            case 2 :
            {
                arr[1].team[y].setHealthBar(arr[1].team[y].getHealthBar()-10.0);
                this.setHealthBar(this.getHealthBar()+10.0);
                break;
            }
            case 3:
            {

                arr[1].team[y].setHealthBar(arr[1].team[y].getHealthBar()-25.5);
                break;
            }

        }
    }

    @Override
    public void listOfAttacks() {
        System.out.println("1: Tail attack (decreases opponents health by 23.0)");
        System.out.println("2: Deadly Kiss (decreases opponents health by 10.0 and adds it to its own ");
        System.out.println("3: Blade  Strike(decreases opponents health by 25.5)");
        System.out.println("4: super move Don't hit yourself(selects one of opponents femaleCharacters and " +
                                "shape shifts into thatCharacter and uses its super)");
    }


}
