package Player;
import Character.*;
public class Player {
    private static int playerCount=1;
    private String name;
    private short level;
    private int points;
    public Hero[] team=new Hero[3];


    public Player()
    {
        this.name="Player " + playerCount;
        this.level=1;
        this.points=0;
        for(int i=0;i<3;++i)
        {
            team[i]=new Lamia();
        }
    }


    public void leveUp()
    {
        if(points>2000)
        {
            level=(short)(points/1000);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getLevel() {
        return level;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void printPlayerInfo()
    {
        System.out.println("Name: " + this.name);
        System.out.println("Points: " + this.points);
        System.out.println("Level: " + this.level);
    }
}
