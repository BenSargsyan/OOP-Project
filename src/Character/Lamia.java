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
        System.out.println("Chose your opponent");
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<arr.length;++i)
        {
            System.out.println((i+1) +": " + arr[1].team[i].getName());
        }
        int y=sc.nextInt()-1;
        System.out.println("Chose your attack type");
        listOfAttacks();

        int x=sc.nextInt();

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

            case 4:
                int countOfFemales=0;
                for(int i=0;i<3;++i)
                {
                    if(arr[1].team[i].getGender()=='f')
                    {
                        ++countOfFemales;
                    }
                }
               Hero[] females=new Hero[countOfFemales];
                for(int i=0,j=0;i<3;++i,j++)
                {
                    if(arr[1].team[i].getGender()=='f')
                    {
                        females[j]=arr[1].team[i];
                    }
                }
                System.out.println("Choose whichCharacters power you want to use");
                for(int i=0;i<countOfFemales;++i)
                {
                    System.out.println(i + ": " +females[i]);
                }
                int choice=sc.nextInt();
                females[choice].attacks(arr);
                //later
        }
    }

    @Override
    public void listOfAttacks() {
        System.out.println("1: Tail attack (decreases opponents health by 23.0)");
        System.out.println("2: Deadly Kiss (decreases opponents health by 10.0 and adds it to its own ");
        System.out.println("3: Blade  Strike(decreases opponents health by 25.5)");
        System.out.println("4: super move Don't hit yourself(selects one of opponents femaleCharacters and " +
                                "shapeshifts into thatCharacter and uses its super)");
    }


}
