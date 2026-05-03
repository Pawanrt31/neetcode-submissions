class DynamicArray {

    private int[] data;

    private int size;

    private int capacity;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.data = new int[this.capacity];
        this.size = 0;
    }

    public int get(int i) {
        return data[i];
    }

    public void set(int i, int n) {
        data[i] = n;
    }

    public void pushback(int n) {
        if(size == capacity) {
            resize();
        }

        data[size] = n;
        size++;
    }

    public int popback() {
        if (size > 0) {
            // soft delete the last element
            size--;
        }
        return data[size];
    }

    private void resize() {
        capacity *= 2;
        int[] newData = new int[capacity];

        for(int i=0;i<this.size;i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
