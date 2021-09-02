import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("Java","platform indepentdent language");
        System.out.println(languages.put("Algol", "an algoritmic language"));

        System.out.println(languages.get("Java"));
        if(languages.containsKey("Java")) {
            System.out.println("Already in the map");
        } else {
            languages.put("Java", "this course about java");
        }
        System.out.println(languages.get("Java"));

        for(String key: languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }

    }
}
