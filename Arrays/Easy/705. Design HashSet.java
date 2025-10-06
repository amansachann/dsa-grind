// Using Boolean Array
class MyHashSet {
    boolean[] hash;
    public MyHashSet() {
        hash = new boolean[1000001];
    }
    
    public void add(int key) {
        hash[key] = true;
    }
    
    public void remove(int key) {
        hash[key] = false;
    }
    
    public boolean contains(int key) {
        return hash[key];
    }
}
