import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {

        List<String> someNumbers = Arrays.asList( "N1", "S3", "A7", "Z5", "3R", "N4", "N9", "N5");
        someNumbers.stream().filter( n-> n.startsWith("N")).sorted().forEach(System.out::println);
    }
}
