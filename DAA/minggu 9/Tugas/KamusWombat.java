// package Tugas;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class KamusWombat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("[\n]+");
        Map<String, String> kamus = new HashMap<String,String>();
        
        while(sc.hasNext()){
            String dodo = sc.next();
            if(dodo.isEmpty()){
                String search = sc.next();
                System.out.println(kamus.getOrDefault(search, "dodo"));
            }
            else{
                String wombat = sc.next();
                kamus.put(wombat, dodo);
            }
        }
    }
}
