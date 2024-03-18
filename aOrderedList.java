
public class aOrderedList {
     private static final int SIZE_INCREMENT = 20;
    private Comparable[] oList;
    private int listSize;
    private int numObjects;

    public aOrderedList() {
        numObjects = 0;
        listSize = SIZE_INCREMENT;
        oList = new Comparable[SIZE_INCREMENT];
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
}
