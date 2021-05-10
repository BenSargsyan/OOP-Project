package Interface;
import Character.*;
import Player.Player;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class GameService {

    public static void printCharacterList(String[] arr)
    {
        for(int i=0;i<arr.length;++i)
        {
            if(arr[i]==null)
                continue;
            System.out.println((i+1)+": " + arr[i]);
        }
    }

    public static void printPlayerTeam(Player player)
    {
        for(int i=0;i<3;++i)
        {
            if(player.team[i]==null)
            {
                System.out.println( " is dead you can't play with it ");
                continue;
            }
            System.out.println((i+1) + ": " + player.team[i].getName() + "   " + player.team[i].getHealthBar());
        }
    }

    public static String[] getCharacteList(String path) throws IOException
    {
        String[] arr = Files.readAllLines(Paths.get(path)).toArray(new String[0]);
        return arr;
    }

    public static void selectYourCharacter(String[] arr, Player player) throws IOException {

        Scanner sc= new Scanner(System.in);
        System.out.println("Choose 3 characters  for your team" + " " + player.getName());
        System.out.println();
        int choice;
        Hero tmp;
        for(int i=0;i<player.team.length;++i)
        {
            printCharacterList(arr);
            choice=sc.nextInt()-1;
            player.team[i].setName(arr[choice].split(",")[0]);
            setAndCheckChosenCharacterType(player,i);
            arr[choice]=null;
        }
    }

    public static void savePlayerProgress(Player player, String path) throws IOException {
        path="PlayerProgress.txt";
        String playerName="Name: "+player.getName();
        String playerLevel="Level: "+player.getLevel();
        String playerPoints="Points: "+player.getPoints();

      Files.write(Paths.get(path),playerName.getBytes());
      Files.write(Paths.get(path),playerLevel.getBytes());
      Files.write(Paths.get(path),playerPoints.getBytes());

    }

    public  static void setAndCheckChosenCharacterType(Player player,int choice)
    {
            if (player.team[choice].getName().equals("Wizard")) {
                player.team[choice] = new Wizard();
            }
            if (player.team[choice].getName().equals("Lamia")) {
                player.team[choice] = new Lamia();
            }
            if (player.team[choice].getName().equals("Banshee")) {
                player.team[choice] = new Banshee();
            }
            if (player.team[choice].getName().equals("Knight")) {
                player.team[choice] = new Knight();
            }
    }

    public static void deleteDeadCharacter(Player player)
    {
        for(int i=0;i<3;++i)
        {
            if(player.team[i]==null)
            {
                continue;
            }
            if(player.team[i].dead())
            {
                player.team[i]=null;
            }
        }
    }


    public static boolean checkLost(Player player) {
            return player.team[0] == null && player.team[1] == null && player.team[2] == null;
    }
}
