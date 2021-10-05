import java.util.Collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if(item != null) {
            StockItem inStock = list.getOrDefault(item.getName(), item);
            //if there are already stocks on this item, adjust the quantity
            if(inStock != item) {
                item.adjustStock(inStock.getQuantityStock());
            }
            list.put(item.getName(), item);
            return item.getQuantityStock();
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if((inStock != null) && inStock.getQuantityStock() >= quantity && quantity > 0) {
            inStock.adjustStock(-quantity);
            return inStock.getQuantityStock();
        }
        return 0;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for(Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.getQuantityStock();

            s = s + stockItem + ". There are: " + stockItem.getQuantityStock() + " costs " + itemValue + "\n";
            totalCost += itemValue;
        }
        return s;
    }
}
