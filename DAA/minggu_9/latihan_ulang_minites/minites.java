// package DAA.minggu_9.latihan_ulang_minites;
import java.util.*;
public class minites {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,Buku> map = new HashMap<String,Buku>();
        long totalHarga = 0;
        while(sc.hasNext()){
            String command = sc.next();
            
            if(command.equals("input")){
                String isbn = sc.next();
                long harga = sc.nextLong();
                String judul = sc.nextLine().trim();
                Buku buku = new Buku(judul, harga);
                if(map.containsKey(isbn)){
                    System.out.println("Input buku "+ judul + " gagal.");
                }
                else{
                    map.put(isbn,buku);
                    System.out.println("Input buku "+ judul + " berhasil.");
                }
            }
            if(command.equals("cari")){
                String isbn = sc.next();
                if(map.containsKey(isbn)){
                    Buku buku = map.get(isbn);
                    System.out.println("Buku " + buku.judul + " dijual dengan harga "+ buku.Harga + " euro.");
                }
                else{
                    System.out.println("Buku dengan ISBN: " + isbn + " tidak ditemukan.");
                }
            }
            if(command.equals("total")){
                System.out.println("Jumlah buku saat ini: " + map.size() + " buah.");
            }
            if(command.equals("jual")){
                String isbn = sc.next();
                if(map.containsKey(isbn)){
                    Buku buku = map.get(isbn);
                    map.remove(isbn);
                    totalHarga+= buku.Harga;
                    System.out.println("Buku " + buku.judul + " berhasil dijual dengan harga " + buku.Harga + " euro.");
                }
                else{
                    System.out.println("Buku dengan ISBN: " + isbn + " tidak ditemukan.");
                }
            }
        }
        System.out.println("Total penjualan: " + totalHarga + " euro.");

    }
}
class Buku{
    String judul;
    long Harga;
    
    public Buku(String judul, long harga){
        this.judul = judul;
        this.Harga = harga;
    }
}