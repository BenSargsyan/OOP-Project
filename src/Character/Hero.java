package Character;
import Player.Player;

public abstract class  Hero {
    protected char gender;
    protected double healthBar;
    protected String name;
    protected  short singleUseOfSuper;
    public abstract void attacks(Player[] arr);
    public abstract  void listOfAttacks();

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getHealthBar() {
        return healthBar;
    }

    public void setHealthBar(double healthBar) {
        this.healthBar = healthBar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean dead()
    {
        return this.getHealthBar()<=0;
    }
}