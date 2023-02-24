public class Pair<K,V> {
    K key;
    V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return this.key;
    }
    public V getValue() {
        return this.value;
    }
    public void setKey(K key) {
        this.key = key;
    }
    public void setValue(V value) {
        this.value = value;
    }
    public String toString() {
        return "key is of type: " + key.getClass() + " and value is of type " +
                value.getClass() + " | Key: " + key + " - Value: " + value;
    }
}