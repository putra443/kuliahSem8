// package modul;

import java.util.*;

abstract class HashTable<K,V>{
    protected Data[] table;
    protected int capacity;
    protected double c1, c2;
    protected Data tombstone = new Data(null, null);

    private class Data{
        K key;
        V value;

        Data (K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    public HashTable(int capacity, double c1, double c2){
        this.capacity = capacity;
        this.table = (Data[]) new HashTable.Data[capacity];
        this.c1 = c1;
        this.c2 = c2;
    }

    abstract protected int hashFunction(K key);
    abstract protected int quadraticProbing(int k0, int i);

    public V search(K key){
        int k0 = this.hashFunction(key);
        int idx;
        for(int i=0; i<this.capacity;i++){
            idx = this.quadraticProbing(k0, i);
            if(this.table[idx]!=null && this.table[idx].key.equals(key)){
                return this.table[idx].value;
            }
        }
        return null;
    }
    
    public boolean insert(K key, V value){
        //lengkapi....
        Data d = new Data(key, value);
        
        int k0 = this.hashFunction(key);
        int idx ;
        for(int i=0; i<this.capacity; i++){
            idx = this.quadraticProbing(k0,i);
            if(this.table[idx]==null){
                this.table[idx] = d;
                return true;
            }
        }
        return false;
    }

    
    public V delete(K key){
        int k0 = this.hashFunction(key);
        int idx;
        for(int i=0; i<this.capacity;i++){
            idx = this.quadraticProbing(k0,i);
            if(this.table[idx]==null){
                return null;
            }
            else if(this.table[idx].key.equals(key)){
                V result = this.table[idx].value;
                this.table[idx] = null;
                return result;
            }
        }
        return null;
    }

}

class ModularHashInteger<V> extends HashTable<Integer,V>{
    public ModularHashInteger(int capacity, double c1, double c2){
        super(capacity,c1,c2);
    }

    protected int hashFunction(Integer Key){
        return Key%this.capacity;
    }
    protected int quadraticProbing(int k0, int i){
        return((int)(k0 + this.c1*i + this.c2*i*i))%this.capacity;
    }
}

public class TesterHash{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        double c1 = sc.nextDouble();
        double c2 = sc.nextDouble();
        ModularHashInteger<String>h = new ModularHashInteger(capacity, c1, c2);
        
        while(sc.hasNext()){
            String input = sc.next();
            if(input.equals("insert")){
                int key = sc.nextInt();
                String value = sc.next();
                boolean hasil = h.insert(key, value);
                if(hasil==true){
                    System.out.println("true");
                }
                else{
                    System.out.println("false");
                }
            }
            else if(input.equals("search")){
                int key = sc.nextInt();
                if(h.search(key)==null){
                    System.out.println("null");
                }
                else{
                    System.out.println(h.search(key));
                }
            }
            else if(input.equals("delete")){
                int key = sc.nextInt();
                if(h.search(key)!=null){
                    String value = h.search(key);
                    System.out.println(value);
                    h.delete(key);
                }
                else{
                    System.out.println("null");
                }
            }
        }

    }
}