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
            if(this.table[idx]==this.tombstone){
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
            if(this.table[idx]==this.tombstone){
                return null;
            }
            else if(this.table[idx]!= this.tombstone && 
                    this.table[idx].key.equals(key)){
                V result = this.table[idx].value;
                this.table[idx] = this.tombstone;
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


// public class TesterHash{
//     public static void main (String[]args){
//         Scanner sc = new Scanner(System.in);
//         int capacity = sc.nextInt();
//         double c1 = sc.nextDouble();
//         double c2 = sc.nextDouble();
//         String[] output = new String[1000];
//         int operasi = sc.nextInt();
//         ModularHashInteger<String> h = new ModularHashInteger<String>(capacity,c1,c2);
//         int key;
//         String value = "";
//         for(int i = 0; i<operasi;i++){
//             String input = sc.next();

//             if(input.equals("insert")){
//                  key = sc.nextInt();
//                  value = sc.nextLine();
//                 if(h.insert(key, value)==true){
//                     // output[i] =("insert"+" "+"<"+key+","+value.substring(1)+">" + " berhasil");
//                     // output[i] = String.format("insert <%s,%s> berhasil", key,value.replaceFirst("^\\s+", ""));
//                     System.out.println("insert"+" "+"<"+key+","+value.substring(1)+">" + " berhasil");
//                 }
//                 else{
//                     // output[i] =("insert"+" "+"<"+key+","+value.substring(1)+">" + " gagal");
//                     // output[i] = String.format("insert <%s,%s> gagal", key,value.replaceFirst("^\\s+", ""));
//                     System.out.println("insert"+" "+"<"+key+","+value.substring(1)+">" + " gagal");
                    
//                 }
//             }
//             else if(input.equals("search")){
//                  key = sc.nextInt();
//                 if(h.search(key)!=null){
//                     // output[i] =("<"+key+","+h.search(key)+">"+" ditemukan");
//                     System.out.println("<"+key+","+h.search(key)+">"+" ditemukan");
//                 }
//                 else{
//                     // output[i] =("<"+key+">"+" tidak ditemukan");
//                     System.out.println("<"+key+">"+" tidak ditemukan");

//                 }
//             }
//             else if(input.equals("delete")){
//                  key = sc.nextInt();
//                 if(h.search(key)!=null){
//                     String value_delete = h.search(key);
//                     // output[i] = input+" "+"<"+key+","+value_delete+">"+" berhasil";
//                     System.out.println(input+" "+"<"+key+","+value_delete+">"+" berhasil");
//                     h.delete(key);
//                 }
//                 else{
//                     // output[i] =input+" "+ "<"+key+">"+" gagal";
//                     System.out.println(input+" "+"<"+key+">"+" gagal");
//                 }
//             }
//         }

//         for(String x : output){
//             if(x != null){
//                 System.out.println(x);
//             }
//         }
//     }
// }
public class TesterHash{
    public static void main(String[]args){
        ModularHashInteger<String>h = new ModularHashInteger(11, 3, 2);
        h.insert(5, "Alice");
        h.insert(16, "Bob");
        h.insert(27, "Charlie");
        h.delete(16);

        System.out.println(h.search(5));
        System.out.println(h.search(16));
        System.out.println(h.search(27));

    }
}