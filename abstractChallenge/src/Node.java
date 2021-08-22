public class Node extends ListItem{
    private ListItem rightNode;
    private ListItem leftNode;

    public Node(Object object) {
        super(object);
    }

    @Override
   public ListItem next() {
        return rightNode;
    }

    @Override
    ListItem setNext(ListItem item) {
        rightNode = item;
        return rightNode;
    }

    @Override
    ListItem prev() {
        return leftNode;
    }

    @Override
    ListItem setPrev(ListItem item) {
        leftNode = item;
        return leftNode;
    }

    @Override
    int compareTo(ListItem item) {
       if(item != null) {
           return ((String)this.getValue()).compareTo((String)item.getValue());
       }
       else{
            return -1;
       }
    }
}
