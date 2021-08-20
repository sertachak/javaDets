import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player implements Saveable{
    private String name;
    private int hitPoints;
    private int strength;
    private String weapon;

    public Player(String name, int hitPoints, int strength, String weapon) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<>();
        values.add(0, this.name);
        values.add(1, "" + this.hitPoints);
        values.add(2, "" + this.strength);
        values.add(3,  this.weapon);
        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if( savedValues != null && savedValues.size() > 0) {
            this.name = savedValues.get(0);
            this.hitPoints =  Integer.parseInt(savedValues.get(1));
            this.strength = Integer.parseInt(savedValues.get(2));
        }

    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return hitPoints == player.hitPoints && strength == player.strength && Objects.equals(name, player.name) && Objects.equals(weapon, player.weapon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hitPoints, strength, weapon);
    }
}
