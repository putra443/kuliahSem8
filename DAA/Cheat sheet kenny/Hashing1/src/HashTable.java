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
    
    private class Data{
        K key;
        V value;
        
        Data(K key, V value){
            this.key=key;
            this.value=value;
        }
    }
    
    public HashTable(int capacity){
        this.capacity=capacity;
        this.table=(Data[]) new HashTable.Data[capacity];
    }
    
    abstract protected int hashFunction(K key);
    
    public V search(K key){
        int idx = this.hashFunction(key);
        if (this.table[idx] != null && this.table[idx].key.equals(key)){
            return this.table[idx].value;
        }else{
            return null;
        }
    }
    
    public boolean insert (K key, V value){
        int idx = hashFunction(key);
        if(this.table[idx]==null){
            this.table[idx]= new Data(key,value);
            return true;
        }else{
            return false;
        }
    }
    
    public V delete(K key){
        int idx = hashFunction(key);
        if(this.table[idx] != null && this.table[idx].key.equals(key)){
            V temp = this.table[idx].value;
            return temp;
        }else{
            return null;
        }
    }
}
