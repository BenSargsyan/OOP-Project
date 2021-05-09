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

            int singleUseInOneTurn1=0;
            int singleUseInOneTurn2=0;
            System.out.println("Start");
            Player[] playerList=new Player[2];
            playerList[0]=player1;
            playerList[1]=player2;
            while(!(GameService.checkLost(player1)) ||!(GameService.checkLost(player2)))
            {
                    System.out.println(playerList[0].getName()+"'s turn");
                    System.out.println(player1.getName()+ ": Select a character to attack");
                    GameService.printPlayerTeam(player1);

                    int selection=sc.nextInt();
                        playerList[0].team[selection].attacks(playerList);
                        singleUseInOneTurn1=selection;

                    System.out.println(player1.getName()+ ": Select a character to attack");
                    GameService.printPlayerTeam(player1);
                            selection=sc.nextInt();

                    if(singleUseInOneTurn1==selection)
                    {
                            System.out.println("Choose another character you have already played with this one");
                            selection=sc.nextInt();
                    }
                    playerList[0].team[selection].attacks(playerList);
                    singleUseInOneTurn2=selection;

                    if(singleUseInOneTurn1==selection || singleUseInOneTurn2==selection)
                    {
                            System.out.println("Choose another character you have already played with this two");
                            selection=sc.nextInt();
                    }
                    playerList[0].team[selection].attacks(playerList);

                    //////////////////////////////////////////////////

                    System.out.println(playerList[1].getName()+"'s turn");
                    System.out.println(player2.getName()+ ": Select a character to attack");
                    GameService.printPlayerTeam(player2);

                    int selectionqPlayer2=sc.nextInt();
                    playerList[1].team[selection].attacks(playerList);
                    singleUseInOneTurn1=selection;

                    System.out.println(player2.getName()+ ": Select a character to attack");
                    GameService.printPlayerTeam(player2);
                    selection=sc.nextInt();

                    if(singleUseInOneTurn1==selection)
                    {
                            System.out.println("Choose another character you have already played with this one");
                            selection=sc.nextInt();
                    }
                    playerList[1].team[selection].attacks(playerList);
                    singleUseInOneTurn2=selection;

                    if(singleUseInOneTurn1==selection || singleUseInOneTurn2==selection)
                    {
                            System.out.println("Choose another character you have already played with this two");
                            selection=sc.nextInt();
                    }
                    playerList[1].team[selection].attacks(playerList);

                    GameService.deleteDeadCharacter(playerList[0]);
                    GameService.deleteDeadCharacter(playerList[1]);

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
