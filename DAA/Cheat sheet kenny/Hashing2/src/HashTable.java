/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author i18051
 */
abstract class HashTable<K, V> {
    protected Data[] table;
    protected int capacity;
    protected double c1, c2;
    protected Data tombstone = new Data(null,null);
    
    private class Data{
        K key;
        V value;
        
        Data(K key, V value){
            this.key=key;
            this.value=value;
        }
    }
    
    public HashTable(int capacity, double c1, double c2){
        this.capacity=capacity;
        this.table=(Data[]) new HashTable.Data[capacity];
        this.c1=c1;
        this.c2=c2;
    }
    
    abstract protected int hashFunction(K key);
    
    public V search(K key){
        int k0 = this.hashFunction(key);
        int idx;
        for (int i = 0; i<this.capacity; i++){
            idx = this.quadraticProbing(k0, i);
            if (this.table[idx]==null){
                return null;
            }else if (this.table[idx]!=this.tombstone && this.table[idx].key.equals(key)){
                V result = this.table[idx].value;
                return result;
            }
        }
        return null;
    }
    
    public boolean insert (K key, V value){
        Data newData = new Data(key, value);
        int k0 = this.hashFunction(key);
        int idx;
        for (int i = 0; i<this.capacity; i++){
            idx = this.quadraticProbing(k0, i);
            if (this.table[idx]==this.tombstone || this.table[idx]==null){
                this.table[idx]=newData;
                return true;
            }
        }
        return false;
    }
    
    public V delete(K key){
        int k0 = this.hashFunction(key);
        int idx;
        for (int i = 0; i<this.capacity; i++){
            idx = this.quadraticProbing(k0, i);
            if (this.table[idx]==null){
                return null;
            }else if (this.table[idx]!=this.tombstone && this.table[idx].key.equals(key)){
                V result = this.table[idx].value;
                this.table[idx]=this.tombstone;
                return result;
            }
        }
        return null;
    }
    
    protected int quadraticProbing(int k0, int i){
        return ((int)(k0+this.c1*i+this.c2*i*i))%this.capacity;
    }
}
