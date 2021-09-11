import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {
    private final String name;
    private final BodyType bodyType;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod, BodyType bodyType) {
        this.name = name;
        this.bodyType = bodyType;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public BodyType getBodyType() {
        return bodyType;
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
            HeavenlyBody theObject = (HeavenlyBody) obj;
            if(this.name.equals(theObject.getName())){
                return this.getBodyType() == theObject.getBodyType();
            }
        }
        return false;
    }

    @Override
    public final int hashCode(){
        return this.name.hashCode() + this.bodyType.hashCode() + 57;
    }

    @Override
    public String toString() {
        return  name + ": " + '\'' +
                ", bodyType=" + bodyType +
                ", orbitalPeriod=" + orbitalPeriod +
                ", satellites=" + satellites +
                '}';
    }
}
