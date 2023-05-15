import java.util.*;

public class KamusDodo{
    public static void main(String[]args){
        Map<String, String> kamus = new HashMap<String, String>();
        Scanner sc = new Scanner(System.in);
        

        for(String input = sc.nextLine();!input.isEmpty(); input = sc.nextLine()){
            String [] kata = input.split(" ");
            kamus.put(kata[1], kata[0]);
            
        }

        while(sc.hasNext()){
            String search = sc.next();
            if(kamus.get(search)==null){
                System.out.println("dodo");
            }
            else{
            System.out.println(kamus.get(search));
            }
        }
    }
}