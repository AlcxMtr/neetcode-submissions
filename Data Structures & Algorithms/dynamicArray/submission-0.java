class DynamicArray {
    int capacity;
    int size = 0;
    int[] array;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        if (size == capacity) {
            resize();
        }
        size++;
        array[size-1] = n;  
    }

    public int popback() {
        size--;
        return array[size];
    }

    private void resize() {
        int[] new_array = new int[capacity*2];
        int i = 0;
        for (; i < capacity; i++) {
            new_array[i] = array[i];
        }
        capacity = capacity*2;
        array = new_array;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
