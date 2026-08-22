package Zepto.utils;

// Simple helper Pair class (JavaFX / Android Pair is not available here)
public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K k, V v) {
        this.key = k;
        this.value = v;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V v) {
        this.value = v;
    }
}
