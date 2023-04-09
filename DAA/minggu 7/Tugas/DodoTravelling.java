import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

abstract class HashTable<K,V>{
    protected Data[] table;
    protected int capacity;
    protected double c1, c2;
    protected Data tombstone = new Data(null, null);

    public class Data{
        TravelPlan key;
        V value;

        Data (TravelPlan key, V value){
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

    abstract protected int hashFunction(TravelPlan key);
    abstract protected int quadraticProbing(int k0, int i);

    
    public boolean insert(TravelPlan key, V value){
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

}

class TravelPlan{
    String waktu;
    String tempat;
    String jenisKegiatan;

    TravelPlan(String waktu, String tempat, String jenisKegiatan){
        this.waktu = waktu;
        this.tempat = tempat;
        this.jenisKegiatan = jenisKegiatan;    
    }
    public String StringTravelPlan(){
        String key = this.tempat + "-" + this.waktu + "-" + this.jenisKegiatan;
        return key;
    }
    public boolean equals(TravelPlan tp){
        if(this.waktu==tp.waktu && this.tempat == tp.tempat && this.jenisKegiatan == tp.jenisKegiatan){
            return true;
        }
        else{
            return false;
        }
    }

}

class ModularHashTravel<V> extends HashTable<TravelPlan,V>{
    public ModularHashTravel(int capacity, double c1, double c2){
        super(capacity,c1,c2);
    }

    protected int hashFunction(TravelPlan Key){
        String key = Key.StringTravelPlan();
        int res = key.hashCode();
        return res;
    }

    protected int quadraticProbing(int k0, int i){
        return((int)(k0 + this.c1*i + this.c2*i*i))%this.capacity;
    }

}
public class DodoTravelling {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int kasus = sc.nextInt();
        int capacity = 25;
        double c1 = 3;
        double c2 = 7;
        ModularHashTravel<String> h = new ModularHashTravel(capacity, c1, c2);
        for(int i=0; i<kasus;i++){
            String tempat = (sc.next().toUpperCase());
            String waktu = sc.next();
            String kegiatan = sc.next().toUpperCase();
            String tanggal = sc.next();

            TravelPlan tp = new TravelPlan(tempat, waktu,kegiatan);
            h.insert(tp,tanggal);
        }

        System.out.println(h.toString());
    }
}
