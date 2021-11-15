package com.tjcloud.match.api.utils;

/**
 * 
 * @author WongBen
 *
 * @param <K>
 * @param <V>
 */
public class Tuple<K, V> {
    public final K key;
    public final V value;
     
    public Tuple(K k, V v) {
        this.key = k;
        this.value = v;
    }
}