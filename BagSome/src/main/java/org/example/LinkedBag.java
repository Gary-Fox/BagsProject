package org.example;

public class LinkedBag<T> implements BagInterface<T>
{
    private Node firstNode;
    private int numberOfEntries;

    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }

    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

    public T remove() {
        T result = null;
        if (firstNode != null) {
            result = firstNode.getData();
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
        }
        return result;
    }

    public boolean remove(T anEntry) {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);
        if (nodeN != null) {
            nodeN.setData(firstNode.getData());
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
            result = true;
        }
        return result;
    }

    private Node getReferenceTo(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && currentNode != null) {
            if (anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }

    public void clear() {
        while (!isEmpty())
            remove();
    }

    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        int counter = 0;
        Node currentNode = firstNode;
        while (counter < numberOfEntries && currentNode != null) {
            if (anEntry.equals(currentNode.getData()))
                frequency++;
            counter++;
            currentNode = currentNode.getNextNode();
        }
        return frequency;
    }

    public boolean contains(T anEntry) {
        return getReferenceTo(anEntry) != null;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;
        Node currentNode = firstNode;
        while (index < numberOfEntries && currentNode != null) {
            result[index] = currentNode.getData();
            index++;
            currentNode = currentNode.getNextNode();
        }
        return result;
    }

    private class Node {
        private T data;
        private Node next;

        private Node(T dataPortion) {
            this(dataPortion, null);
        }

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        private T getData() {
            return data;
        }

        private void setData(T newData) {
            data = newData;
        }

        private Node getNextNode() {
            return next;
        }
    }

    public T[] union()
    {
        return null;
    }

    public BagInterface<T> intersection(BagInterface<T> bagIn)
    {
        T[] bagA = this.toArray();
        T[] bagB = bagIn.toArray();
        ResizableArrayBag<T> result = new ResizableArrayBag<>();
        //T searchVar;
        if (this.isEmpty() || bagIn.isEmpty())
        {
            return result;
        }

        for (int i = 0; i < bagB.length; i++)
        {
            if (bagB[i] != null)
            {
                for (int j = 0; j < bagA.length; j++)
                {
                    if(bagB[i] == bagA[j] && bagA[j] != null)
                    {
                        result.add(bagB[i]);
                        bagB[i] = null;
                        bagA[j] = null;
                    }
                }
            }
        }


        return result;
    }

    public BagInterface<T> difference(BagInterface<T> bagIn)
    {
        T[] bagA = this.toArray();
        T[] bagB = bagIn.toArray();

        java.util.ArrayList<T> resultList = new java.util.ArrayList<>();
        java.util.Collections.addAll(resultList, bagA);

        for (T otherItem : bagB) {
            if (otherItem == null) continue;
            boolean removed = false;
            for (int k = 0; k < resultList.size() && !removed; k++) {
                T candidate = resultList.get(k);
                if (candidate != null && otherItem.equals(candidate)) {
                    resultList.remove(k);
                    removed = true;
                }
            }
        }

        BagInterface<T> result = new ResizableArrayBag<>();
        for (T element : resultList) {
            result.add(element);
        }
        return result;
    }
}