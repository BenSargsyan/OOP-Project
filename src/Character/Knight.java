package Character;

import Player.Player;

import java.util.Scanner;

public class Knight extends Hero {

    public Knight()
    {
        this.healthBar=140.0;
        this.gender='m';
        this.name="Knight";
    }

    @Override
    public void attacks(Player[] arr) {
        System.out.println("Chose your opponent");
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<3;++i)
        {
            System.out.println(i+1+": " + arr[1].team[i].getName());
        }
        int y=sc.nextInt()-1;
        System.out.println("Chose your attack type");
        listOfAttacks();
        int x=sc.nextInt();

        switch (x)
        {
            case 1 :
            {
                arr[1].team[y].setHealthBar(arr[1].team[y].getHealthBar()-25.5);
                break;
            }
            case 2 :
            {
                for(int i=0;i<3;++i)
                {
                    arr[1].team[y].setHealthBar(arr[1].team[y].getHealthBar()-16.5);                }
                break;
            }
            case 3:
            {

                this.setHealthBar(this.getHealthBar()+25.0);
                break;
            }

            case 4:
            {
                arr[1].team[y].setHealthBar(arr[1].team[y].getHealthBar()-40);
            }
        }
    }

    @Override
    public void listOfAttacks() {
        System.out.println("1: attack with sword (decreases opponents health by 25.6)");
        System.out.println("2: attack with arrows (attacks the hole team decreases each opponents health by 13.5)");
        System.out.println("3: defense by shield  (Character gets covered by shield with 25.0 strength)");
        System.out.println("4: attack by cavalry (super move can only be used once decreases opponents health by 40.0)");
    }

}
