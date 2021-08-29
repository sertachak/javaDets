public class SIBTest {
    private static final String owner;

    static {
        owner = "COKO";
        System.out.println("Called 1st static initialization block");
    }

    public SIBTest() {
        System.out.println("SIB Constructor called");
    }

    static {
        System.out.println("After contructor second static initialization block");
    }
}
