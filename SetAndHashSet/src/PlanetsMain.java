import java.util.*;

public class PlanetsMain {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp = new HeavenlyBody("Mercury", 88, BodyType.PLANET);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Venus", 255, BodyType.PLANET);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Earth", 365, BodyType.PLANET);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27 ,BodyType.MOON);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addSatellites(tempMoon);

        temp = new HeavenlyBody("Mars", 687 ,BodyType.PLANET);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Deimos", 1.3, BodyType.MOON);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellites(tempMoon); // temp is still Mars

        tempMoon = new HeavenlyBody("Phobos", 0.3, BodyType.MOON);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellites(tempMoon); // temp is still Mars

        temp = new HeavenlyBody("Jupiter", 4332, BodyType.PLANET);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Io", 1.8, BodyType.MOON);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellites(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Europa", 3.5, BodyType.MOON);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellites(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Ganymede", 7.1, BodyType.MOON);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellites(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Callisto", 16.7, BodyType.MOON);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellites(tempMoon); // temp is still Jupiter

        temp = new HeavenlyBody("Saturn", 10759, BodyType.PLANET);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Uranus", 30660,  BodyType.PLANET);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Neptune", 165,  BodyType.PLANET);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Pluto", 248,  BodyType.PLANET);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println("Planets");
        for(HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getName());
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All moons");
        for(HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getName());
        }

        HeavenlyBody pluto = new HeavenlyBody("Pluto", 842,  BodyType.PLANET);
        planets.add(pluto);

        for(HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getName() + " " + planet.getOrbitalPeriod());
        }

        Set<String> divine = new HashSet<>();
        Set<String> notDivine = new HashSet<>();
        String[] divineWords = {"ad", "1", "23423", "dsada"};
        divine.addAll(Arrays.asList(divineWords));

        for(String word : divine) {
            System.out.println(word);
        }

        String[] notDivineWords = {"ad", "dsada"};
        divine.retainAll(Arrays.asList(notDivineWords));

        System.out.println("After retain");
        divine.stream().forEach((word)-> System.out.println(word));
        

    }
}
