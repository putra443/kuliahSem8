import java.util.*;
public class agenRahasia{
    public static double [] moduloStringHash(String input){
        char[] arr_input = input.toCharArray();
        double[] arr_value = new double[arr_input.length];
        double j = 1;
        for(int i =0; i<arr_value.length;i++){
            // System.out.println((double)arr_input[i]-65);
            arr_value[i] = ((double)arr_input[i]-65)*(Math.pow(26,(arr_value.length-j)));
            j+=1;
        }
        return arr_value;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        int kasus = sc.nextInt();
        for(int i =0; i< kasus ;i++){
            String kata =sc.next();
            int hashValue = sc.nextInt();
            double[] arr_value = moduloStringHash(kata);
            int res = 0;
            for(int k = 0; k<arr_value.length;k++){
                res += arr_value[k];
            }
            System.out.println(res%17551);

            int selisih = (res%17551) - hashValue;
            System.out.println(selisih);
        }

        
    }
}