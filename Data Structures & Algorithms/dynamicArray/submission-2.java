class DynamicArray {

    private int[] data;

    private int size;

    private static final int INIT_CAP = 4;

    public DynamicArray() {
        this(INIT_CAP);
    }

    public DynamicArray(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public int get(int i) {
        if(!isValidIndex(i)) {
            throw new IllegalArgumentException("Invalid index: "+ i);
        }
        return data[i];
    }

    public void set(int i, int n) {
        if(!isValidIndex(i)) {
            throw new IllegalArgumentException("Invalid index: "+ i);
        }
        data[i] = n;
    }

    public void pushback(int n) {
        int capacity = data.length;
        if(capacity == size) {
            resize(capacity * 2);
        }
        data[size] = n;
        size++;
    }

    public int popback() {
        int capacity = data.length;
        if(capacity == (size / 4)) {
            resize(capacity / 2);
        }
        int oldValue = data[size - 1];
        data[size - 1] = 0;
        size--;
        return oldValue;
    }

    private void resize(int newCapacity) {
        int[] temp = new int[newCapacity];
        for(int i=0;i<size;i++) {
            temp[i] = data[i]; 
        }
        data = temp;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }
}
