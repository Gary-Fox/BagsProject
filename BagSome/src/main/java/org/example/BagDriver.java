package org.example;

import java.util.Arrays;

public class BagDriver
{
    public static void main(String[] args)
    {
        ResizableArrayBag<Integer> aBag1 = new ResizableArrayBag<>();
        ResizableArrayBag<Integer> aBag2 = new ResizableArrayBag<>();
        LinkedBag<Integer> lBag3 = new LinkedBag<>();
        LinkedBag<Integer> emptyLinked = new LinkedBag<>();
        ResizableArrayBag<Integer> emptyArray = new ResizableArrayBag<>();

        // contents: 1, 2, 3, 4,
        aBag1.add(1);
        aBag1.add(3);
        aBag1.add(2);
        aBag1.add(4);

        // contents: 4, 4, 4,
        aBag2.add(4);
        aBag2.add(4);
        aBag2.add(4);

        // contents: 1
        lBag3.add(5);

        // contents: [empty]
        emptyArray.add(1500);
        emptyArray.remove();

        // Union
        BagInterface<Integer> unionBag21 = aBag2.union(aBag1);
        BagInterface<Integer> unionBag12 = aBag1.union(aBag2);
        System.out.println("########## * Union * ##########");
        System.out.println("aBag1: " + Arrays.toString(aBag1.toArray()));
        System.out.println("aBag2: " + Arrays.toString(aBag2.toArray()));
        System.out.println("lBag3: " + Arrays.toString(lBag3.toArray()));
        System.out.println("emptyArray: " + Arrays.toString(emptyArray.toArray()));
        System.out.println("emptyLinked: " + Arrays.toString(emptyLinked.toArray()));
        System.out.println("--------------------");
        System.out.println("bag1 U bag2: " + Arrays.toString(unionBag12.toArray()));
        System.out.println("bag2 U bag1: " + Arrays.toString(unionBag21.toArray()));
        System.out.println("[Array]bag12 U [Linked]bag3: " + Arrays.toString(unionBag12.union(lBag3).toArray()));
        System.out.println("Emptybag U bag12: " + Arrays.toString(emptyArray.union(unionBag12).toArray()));
        System.out.println("[Array]Emptybag U [Linked]Emptybag: " + Arrays.toString(emptyArray.union(emptyLinked).toArray()));
        System.out.print('\n');

        //Intersection
        BagInterface<Integer> intsectBag21 = aBag2.intersection(aBag1);
        BagInterface<Integer> intsectBag12 = aBag1.intersection(aBag2);
        System.out.println("########## * Intersection * ##########");
        System.out.println("aBag1: " + Arrays.toString(aBag1.toArray()));
        System.out.println("aBag2: " + Arrays.toString(aBag2.toArray()));
        System.out.println("lBag3: " + Arrays.toString(lBag3.toArray()));
        System.out.println("emptyArray: " + Arrays.toString(emptyArray.toArray()));
        System.out.println("emptyLinked: " + Arrays.toString(emptyLinked.toArray()));
        System.out.println("--------------------");
        System.out.println("bag1 n bag2: " + Arrays.toString(intsectBag12.toArray()));
        System.out.println("bag2 n bag1: " + Arrays.toString(intsectBag21.toArray()));
        System.out.println("bag12 n bag2: " + Arrays.toString(unionBag12.intersection(aBag2).toArray()));
        System.out.println("(bag12 n bag2) n bag1: " + Arrays.toString(aBag1.intersection(unionBag12.intersection(aBag2)).toArray()));
        System.out.println("[Linked]bag3 n [Array]Emptybag: " + Arrays.toString(lBag3.intersection(emptyArray).toArray()));
        System.out.println("[Linked]Emptybag n [Array]Emptybag: " + Arrays.toString(emptyLinked.intersection(emptyArray).toArray()));

        System.out.print('\n');

        //Difference
        BagInterface<Integer> diffBag12 = aBag1.difference(aBag2);
        BagInterface<Integer> diffBag21 = aBag2.difference(aBag1);
        System.out.println("########## * Difference * ##########");
        System.out.println("aBag1: " + Arrays.toString(aBag1.toArray()));
        System.out.println("aBag2: " + Arrays.toString(aBag2.toArray()));
        System.out.println("lBag3: " + Arrays.toString(lBag3.toArray()));
        System.out.println("emptyArray: " + Arrays.toString(emptyArray.toArray()));
        System.out.println("emptyLinked: " + Arrays.toString(emptyLinked.toArray()));
        System.out.println("--------------------");
        System.out.println("bag1 - bag2: " + Arrays.toString(diffBag12.toArray()));
        System.out.println("bag2 - bag1: " + Arrays.toString(diffBag21.toArray()));
        System.out.println("bag12 - bag2: " + Arrays.toString(unionBag12.difference(aBag2).toArray()));
        System.out.println("bag2 - bag12: " + Arrays.toString(aBag2.difference(unionBag12).toArray()));
        System.out.println("bag123 - bag3:" + Arrays.toString(unionBag12.union(lBag3).difference(lBag3).toArray()));
        System.out.println("bag12 - bag3: " + Arrays.toString(unionBag12.difference(lBag3).toArray()));
        System.out.println("Emptybag - bag2: " + Arrays.toString(emptyLinked.difference(aBag2).toArray()));
        System.out.println("bag2 - Emptybag: " + Arrays.toString(aBag2.difference(emptyLinked).toArray()));
        System.out.println("Emptybag - Emptybag: " + Arrays.toString(emptyArray.difference(emptyLinked).toArray()));

    }
}
