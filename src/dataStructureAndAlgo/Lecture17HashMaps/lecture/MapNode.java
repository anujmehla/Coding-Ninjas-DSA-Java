package dataStructureAndAlgo.Lecture17HashMaps.lecture;

public class MapNode<K,V> {
    K key;
    V value;
    MapNode<K,V> next;

    public MapNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
