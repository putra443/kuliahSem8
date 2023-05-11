package Tugas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KamusWombat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> kamus = new HashMap<String,String>();
    
        String baris_input = sc.nextLine();

        while(!baris_input.isEmpty()){
            String[] kata = baris_input.split(" ");

            kamus.put(kata[1], kata[0]);

            baris_input = sc.nextLine();
        }

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
