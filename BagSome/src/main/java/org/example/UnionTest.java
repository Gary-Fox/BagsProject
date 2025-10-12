import java.util.Arrays;

public class UnionTest {
    public static void main(String[] args) {
        LinkedBag<String> bag1 = new LinkedBag<>();
        ResizableArrayBag<String> bag2 = new ResizableArrayBag<>();

        bag1.add("apple");
        bag1.add("banana");
        bag1.add("orange");
        bag1.add("apple");
        bag1.add("banana");
        bag1.add("orange");

        bag2.add("banana");
        bag2.add("kiwi");
        bag2.add("apple");
        bag2.add("apple");
        bag2.add("apple");
        bag2.add("dragonfruit");

        BagInterface<String> unionBag = bag1.union(bag2);

        System.out.println("Union: " + Arrays.toString(bag1.union(bag2).toArray()));
        System.out.println("Union var: " + Arrays.toString(unionBag.toArray()));
    }
}

