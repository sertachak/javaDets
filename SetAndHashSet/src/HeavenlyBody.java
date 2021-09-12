import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod, BodyType bodyType) {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }

    public static Key makeKey(String name, BodyType bodyType) {
        return new Key(name, bodyType);
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellites(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    @Override
    public final boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj instanceof  HeavenlyBody){
            return this.key.equals(((HeavenlyBody) obj).getKey());
        }
        return false;
    }

    @Override
    public final int hashCode(){
        return key.hashCode();
    }

    @Override
    public String toString() {
        return  key.getName() + ": " + '\'' +
                ", bodyType=" + key.getBodyType() +
                ", orbitalPeriod=" + orbitalPeriod +
                ", satellites=" + satellites +
                '}';
    }

    public static final class Key {
        private String name;
        private BodyType bodyType;

        private Key(String name, BodyType bodyType) {
            this.bodyType = bodyType;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public BodyType getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode()  {
            return name.hashCode() + bodyType.hashCode() + 57;
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key)obj;
            if(this.name.equals(key.getName())){
                return (this.bodyType==key.getBodyType());
            }
            return false;
        }
    }

}
