import java.util.Arrays;

public class aOrderedList {
    private static final int SIZE_INCREMENT = 20;
    private Comparable[] oList;
    private int listSize;
    private int numObjects;
    private int curr;

    public aOrderedList() {
        numObjects = 0;
        listSize = SIZE_INCREMENT;
        oList = new Comparable[SIZE_INCREMENT];
        curr =-1;
    }
    public void remove(int index) {
        if(index < 0 || index >= numObjects) {
            throw new IndexOutOfBoundsException();
        }
        for(int i = index; i < numObjects - 1; i++) {
            oList[i] = oList[i + 1];
        }
        oList[numObjects -1] = null;
        numObjects--;

        if(numObjects == listSize) {
            listSize -= SIZE_INCREMENT;
            oList = Arrays.copyOf(oList, listSize);
        }
    }

    public void add(Comparable newObject) {
        if (numObjects == listSize) {
            resizeList();
        }
        int index = numObjects;
        while (index > 0 && oList[index - 1].compareTo(newObject) > 0) {
            oList[index] = oList[index - 1];
            index--;
        }
        oList[index] = newObject;
        numObjects++;
    }

    private void resizeList() {
        listSize += SIZE_INCREMENT;
        Comparable[] newArray = new Comparable[listSize];
        System.arraycopy(oList, 0, newArray, 0, numObjects);
        oList = newArray;
    }

    public int size() {
        return numObjects;
    }

    public Comparable get(int index) {
        return oList[index];
    }

    public void remove() {
        if (curr >= 0) {
            remove(curr);
            curr--;
        }
        }
        public void reset() {
            curr = -1;
        }
        public boolean hasNext() {
            return(curr + 1) <numObjects;
        }
        public Comparable next() {
            if(hasNext()) {
                curr++;
                return oList[curr];
            }
            return null;
        }
    }

