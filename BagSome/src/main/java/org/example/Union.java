public BagInterface<T> union(BagInterface<T> addBag) {
    T[] bagA = this.toArray();
    T[] bagB = addBag.toArray();

    java.util.ArrayList<T> unifylist = new java.util.ArrayList<>();

    for (int 1 = 0; i < bagA.length; i++) {
        unifylist.add(bagA[i]);
    }
    for (int j = 0; j < bagB.length; j++) {
        unifylist.add(bagB[j]);
    }
    T[] union = (T[]) new Object[unifylist.size()];
    for (int k = 0; k < unifylist.size(); k++) {
        union[k] = unifylist.get(k);
    }
    