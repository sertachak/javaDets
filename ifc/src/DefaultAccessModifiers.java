interface DefaultAccessModifiers {   //without public it becomes package-private
    int GENERAL_USAGE_INT = 100; // public static final
    void playable(); // public
    public void done(); // unnecessary usage of public;
    //because of having interface package private interface and its methods only visible in this package
}
