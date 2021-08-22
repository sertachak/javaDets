public class CustomLinkedList implements NodeList{
    private ListItem root;

    public CustomLinkedList() {
        root = null;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if(root == null){
            root = item;
            return true;
        }
        ListItem currentItem = this.root;
        while(currentItem != null){
            int comparison = currentItem.compareTo(item);
            if(comparison < 0){
                if(currentItem.next() != null){
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNext(item);
                    item.setPrev(currentItem);
                    return true;
                }
            } else if(comparison > 0) {
                if (currentItem.prev() != null) {
                    currentItem.prev().setNext(item);
                    item.setPrev(currentItem.prev());
                    item.setNext(currentItem);
                    currentItem.setPrev(item);
                } else {
                    item.setNext(this.root);
                    this.root.setPrev(item);
                    this.root = item;
                }
                return true;
            } else {
                System.out.println("Not added");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        return false;
    }

    @Override
    public void traverse(ListItem root) {

    }
}
