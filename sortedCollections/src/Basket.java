import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new HashMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item,inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem, Integer> items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "Basket{" +
                "name='" + name + '\'' +
                ", listSize=" + list.size() +
                '}';
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer>  element : list.entrySet() ) {
            totalCost = element.getKey().getPrice() * element.getValue();
        }
        s += "totalCost :" + totalCost;
        return s;
    }
}
