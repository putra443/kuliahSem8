// package Tugas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KamusWombat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> kamus = new HashMap<String,String>();
    
        String bahasa_dodo = sc.next();
        String bahasa_wombat = sc.next();

        while(!bahasa_dodo.isEmpty()){
            kamus.put(bahasa_wombat, bahasa_dodo);

            bahasa_dodo = sc.next();
            bahasa_wombat = sc.next();
        }
        // sc.nextLine();
        while(sc.hasNext()){
            String search = sc.next();
            if(!kamus.containsKey(search)){
                System.out.println("dodo");
            }
            else{
                System.out.println(kamus.get(search));
            }
        }

    }
}
