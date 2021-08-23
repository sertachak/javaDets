import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList items = new ArrayList();// without generics raw type
        items.add(1); //autoboxing
        items.add(2);
        items.add(3);
        items.add(4);
        printDoubled(items);
    }

    public static void printDoubled(ArrayList list){
        for(Object item : list){
            System.out.println((Integer)item*2);
        }
    }
}
