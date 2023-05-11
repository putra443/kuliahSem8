// package Tugas;
import java.util.*;
public class kamusGPT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> kamus = new HashMap<>();

        String bahasa_dodo = sc.next();
        String bahasa_wombat = sc.next();

        while (!bahasa_dodo.isEmpty()) {
            kamus.put(bahasa_wombat, bahasa_dodo);

            bahasa_dodo = sc.next();
            bahasa_wombat = sc.next();
        }

        sc.nextLine(); // Membaca baris kosong setelah kamus

        while (sc.hasNext()) {
            String search = sc.next();
            String translation = kamus.getOrDefault(search, "dodo");
            System.out.println(translation);
        }
    }
}
