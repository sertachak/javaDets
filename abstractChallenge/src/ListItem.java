public abstract class ListItem {
    private ListItem next = null;
    private ListItem prev = null;
    private Object value;

    public ListItem(Object object) {
        this.value = object;
    }

    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem prev();
    abstract ListItem setPrev(ListItem item);

    abstract int compareTo(ListItem comparison);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
