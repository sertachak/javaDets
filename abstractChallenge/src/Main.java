public class Main {
    public static void main(String[] args) {
        CustomLinkedList customList = new CustomLinkedList();
        Node firstItem = new Node("FirstItem");
        Node secondItem = new Node("SecondItem");
        Node thirdItem = new Node("ThirdItem");
        customList.addItem(firstItem);
        customList.addItem(secondItem);
        customList.addItem(thirdItem);
        customList.traverse(customList.getRoot());
    }
}
