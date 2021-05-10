package Interface;
import Player.Player;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {

            System.out.println("Welcome Player1");
            System.out.println("Please enter your name");
            Scanner sc=new Scanner(System.in);
            String name=sc.next();
            Player player1=new Player();
            player1.setName(name);
            Player player2 =new Player();
            System.out.println("Welcome Player2");
            System.out.println("Please enter your name");
            String name2=sc.next();
            player2.setName(name2);


            GameService.selectYourCharacter(GameService.getCharacteList("src\\List.txt"),player1);
            GameService.selectYourCharacter(GameService.getCharacteList("src\\List.txt"),player2);

            int singleUseOfCharacterInOneTurn1=0;
            int singleUseInOneTurn2=0;
            int selectCharacter=0;
            System.out.println("Start");
            Player[] playerList=new Player[2];

            while(!(GameService.checkLost(player1)) && !(GameService.checkLost(player2)))
            {
                    playerList[0]=player1;
                    playerList[1]=player2;

                    GameService.deleteDeadCharacter(playerList[0]);
                    System.out.println("--------------------------");
                    System.out.println(playerList[0].getName() + "'s turn" );
                    System.out.println(playerList[0].getName()+" please select a character from your team to attack " +
                            "(enter a number available from 1 to 3)");
                    GameService.printPlayerTeam(player1);
                    System.out.println("--------------------------");
                     selectCharacter=sc.nextInt()-1;
                    for(int i=0;selectCharacter+1>3 || selectCharacter+1<1;++i)
                    {
                            if(i>=3)
                            {
                                    throw new RuntimeException();
                            }
                            System.out.println("Invalid input please enter a valid number from 1 to 3");
                            selectCharacter=sc.nextInt()-1;
                    }
                    playerList[0].team[selectCharacter].attacks(playerList);

                    singleUseOfCharacterInOneTurn1 = selectCharacter;

                    System.out.println(playerList[0].getName()+" please select a character from your team to attack");
                    System.out.println("You can choose one of this characters");
                    for(int i=0;i<3;++i)
                    {
                            if(i==singleUseOfCharacterInOneTurn1 || playerList[0].team[selectCharacter]==null)
                            {
                                    continue;
                            }
                            System.out.println((i+1)+": " +(playerList[0].team[i].getName() +" "
                                    + playerList[0].team[i].getHealthBar()));

                    }
                    selectCharacter=sc.nextInt()-1;
                    while(selectCharacter==singleUseOfCharacterInOneTurn1 || playerList[0].team[selectCharacter]==null)
                    {
                            if(playerList[0].team[selectCharacter]==null)
                            {
                                    continue;
                            }
                            if(selectCharacter==singleUseOfCharacterInOneTurn1) {
                                    System.out.println("Please a choose another character you have already played with " +
                                            playerList[0].team[selectCharacter].getName());
                                    selectCharacter = sc.nextInt() - 1;
                            }
                    }



                    playerList[0].team[selectCharacter].attacks(playerList);
                    singleUseInOneTurn2=selectCharacter;


                    System.out.println("Only one character left befor " + playerList[1].getName()+"'s turn");
                            for (int i = 0; i < 3; ++i) {
                                    if (i == singleUseOfCharacterInOneTurn1 || i == singleUseInOneTurn2) {
                                            continue;
                                    }
                                    System.out.println("You character is  " +playerList[0].team[i].getName() + " " +
                                            playerList[0].team[i].getHealthBar());
                                    selectCharacter=i;
                            }
                    playerList[0].team[selectCharacter].attacks(playerList);

                    GameService.deleteDeadCharacter(playerList[1]);
                /////////////////////////////////////////////////////////////// Player2 turn

                    playerList[0]=player2;
                    playerList[1]=player1;


                    GameService.deleteDeadCharacter(playerList[0]);

                    System.out.println("--------------------------");
                    System.out.println(playerList[0].getName() + "'s turn" );
                    System.out.println(playerList[0].getName()+" please select a character from your team to attack " +
                            "(enter an available number from 1 to 3)");
                    GameService.printPlayerTeam(playerList[0]);
                    System.out.println("--------------------------");
                    selectCharacter=sc.nextInt()-1;
                    for(int i=0;selectCharacter+1>3 || selectCharacter+1<1;++i)
                    {
                            if(i>=3)
                            {
                                    throw new RuntimeException();
                            }
                            System.out.println("Invalid input please enter a valid number from 1 to 3");
                            selectCharacter=sc.nextInt();
                            if(playerList[0].team[selectCharacter]==null)
                            {
                                    System.out.println("Chose another character this one is dead");
                                    selectCharacter=sc.nextInt();
                            }
                    }
                    playerList[0].team[selectCharacter].attacks(playerList);

                    singleUseOfCharacterInOneTurn1 = selectCharacter;

                    System.out.println(playerList[0].getName()+" please select a character from your team to attack");
                    System.out.println("You can choose one of this characters");
                    for(int i=0;i<3;++i)
                    {
                            if(i==singleUseOfCharacterInOneTurn1)
                            {
                                    continue;
                            }
                            if(playerList[0].team[i]==null)
                            {
                                    continue;
                            }
                            System.out.println((i+1)+": " +(playerList[0].team[i].getName() +" "
                                    + playerList[0].team[i].getHealthBar()));

                    }
                    selectCharacter=sc.nextInt()-1;
                    if(selectCharacter==singleUseOfCharacterInOneTurn1)
                    {
                            System.out.println("Please a choose another character you have already played with "+
                                    playerList[0].team[selectCharacter].getName() );
                            selectCharacter=sc.nextInt()-1;
                    }



                    playerList[0].team[selectCharacter].attacks(playerList);
                    singleUseInOneTurn2=selectCharacter;


                    System.out.println("Only one character left befor " + playerList[1].getName()+"'s turn");
                    for (int i = 0; i < 3; ++i) {
                            if (i == singleUseOfCharacterInOneTurn1 || i == singleUseInOneTurn2 ||
                                    playerList[0].team[selectCharacter]==null) {
                                    continue;
                            }
                            System.out.println("You character is  " +playerList[0].team[i].getName() + " " +
                                    playerList[0].team[i].getHealthBar() + " the automatically selects it for you");
                            selectCharacter=i;
                    }
                    playerList[0].team[selectCharacter].attacks(playerList);
                    GameService.deleteDeadCharacter(playerList[0]);

            }

            if(GameService.checkLost(player1))
            {
                    System.out.println("Congratulations "+ player2.getName()+ " won. :)");
                    player2.setPoints(player2.getPoints()+100);
                    player2.leveUp();
            }
            if(GameService.checkLost(player2))
            {
                    System.out.println("Congratulations "+ player1.getName()+ " won. :)");
                    player1.setPoints(player1.getPoints()+100);
                    player1.leveUp();
            }

            player1.printPlayerInfo();
            System.out.println();
            player2.printPlayerInfo();

            GameService.savePlayerProgress(player1,"src\\PlayerProgress.txt");
    }
    }
