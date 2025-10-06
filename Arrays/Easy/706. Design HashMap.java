// Using Two Arrays
class MyHashMap {
    boolean[] keys;
    int[] values;
    public MyHashMap() {
        keys = new boolean[1000001];
        values = new int[1000001];
    }
    
    public void put(int key, int value) {
        keys[key] = true;
        values[key] = value;
    }
    
    public int get(int key) {
        if(keys[key]) return values[key];
        return -1;
    }
    
    public void remove(int key) {
        keys[key] = false;
    }
}

// Using Single Array
class MyHashMap {
    int[] vals;
    public MyHashMap() {
        vals = new int[1000001];
        Arrays.fill(vals, -1);
    }
    
    public void put(int key, int value) {
        vals[key] = value;
    }
    
    public int get(int key) {
        return vals[key];
    }
    
    public void remove(int key) {
        vals[key] = -1;
    }
}