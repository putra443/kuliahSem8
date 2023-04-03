// package modul;

import java.util.*;

abstract class HashTable<K,V>{
    protected Data[] table;
    protected int capacity;

    private class Data{
        K key;
        V value;

        Data (K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    public HashTable(int capacity){
        this.capacity = capacity;
        this.table = (Data[]) new HashTable.Data[capacity];
    }

    abstract protected int hashFunction(K key);

    public V search(K key){
        int idx = this.hashFunction(key);
        if(this.table[idx]!=null && this.table[idx].key.equals(key)){
            String value = (String)this.table[idx].value;
            return (V)value.substring(1);
        }
        else{
            return null;
        }
    }
    
    public boolean insert(K key, V value){
        //lengkapi....
        Data d = new Data(key, value);
        int idx = this.hashFunction(key);
        if(this.table[idx] == null){
            this.table[idx] = d;
            return true;
        }
        else{

            return false;
        }
    }

    
    public V delete(K key){
        int idx = this.hashFunction(key);
        V value = this.table[idx].value;
        if(search(key)!=null){
            
            if(this.table[idx].key.equals(key)){
                this.table[idx] = null;
            }
        }
        else{
            value = null;
        }
        return value;
    }

}

class ModularHashInteger<V> extends HashTable<Integer,V>{
    public ModularHashInteger(int capacity){
        super(capacity);
    }

    protected int hashFunction(Integer Key){
        return Key%this.capacity;
    }
}

class ModularHashString<V> extends HashTable<String,V>{
    public ModularHashString(int capacity){
        super(capacity);
    }

    protected int hashFunction(String Key){
        char[] huruf = Key.toCharArray();
        int[] huruf_value = new int[huruf.length];

        for(int i=0; i<huruf_value.length;i++){
            huruf_value[i] = (int)huruf[i];
        }
        int res = 0;
        for(int i=0; i<huruf_value.length;i++){
            res += huruf_value[i];
        }
        
        return (res%capacity);
    }
}

class MultiplicativeHashDouble<V> extends HashTable<Double,V>{
    public MultiplicativeHashDouble(int capacity){
        super(capacity);
    }

    protected int hashFunction(Double Key){
        double d_key =  Key;
        double a = 0.6180339887;
        double res = (d_key*a%1)*this.capacity;
        Math.floor(res);
        return (int)res;
    }
}


public class TesterHash{
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        String[] output = new String[1000];
        int operasi = sc.nextInt();
        ModularHashInteger<String> h = new ModularHashInteger<String>(capacity);
        int key;
        String value = "";
        for(int i = 0; i<operasi;i++){
            String input = sc.next();

            if(input.equals("insert")){
                 key = sc.nextInt();
                 value = sc.nextLine();
                if(h.insert(key, value)==true){
                    // output[i] =("insert"+" "+"<"+key+","+value.substring(1)+">" + " berhasil");
                    // output[i] = String.format("insert <%s,%s> berhasil", key,value.replaceFirst("^\\s+", ""));
                    System.out.println("insert"+" "+"<"+key+","+value.substring(1)+">" + " berhasil");
                }
                else{
                    // output[i] =("insert"+" "+"<"+key+","+value.substring(1)+">" + " gagal");
                    // output[i] = String.format("insert <%s,%s> gagal", key,value.replaceFirst("^\\s+", ""));
                    System.out.println("insert"+" "+"<"+key+","+value.substring(1)+">" + " gagal");
                    
                }
            }
            else if(input.equals("search")){
                 key = sc.nextInt();
                if(h.search(key)!=null){
                    // output[i] =("<"+key+","+h.search(key)+">"+" ditemukan");
                    System.out.println("<"+key+","+h.search(key)+">"+" ditemukan");
                }
                else{
                    // output[i] =("<"+key+">"+" tidak ditemukan");
                    System.out.println("<"+key+">"+" tidak ditemukan");

                }
            }
            else if(input.equals("delete")){
                 key = sc.nextInt();
                if(h.search(key)!=null){
                    String value_delete = h.search(key);
                    // output[i] = input+" "+"<"+key+","+value_delete+">"+" berhasil";
                    System.out.println(input+" "+"<"+key+","+value_delete+">"+" berhasil");
                    h.delete(key);
                }
                else{
                    // output[i] =input+" "+ "<"+key+">"+" gagal";
                    System.out.println(input+" "+"<"+key+">"+" gagal");
                }
            }
        }

        for(String x : output){
            if(x != null){
                System.out.println(x);
            }
        }
    }
}