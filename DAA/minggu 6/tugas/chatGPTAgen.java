import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class chatGPTAgen {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        input.nextLine(); // membaca karakter newline yang tersisa

        for (int i = 0; i < T; i++) {
            String line = input.nextLine();
            String[] tokens = line.split(" ");
            String s = tokens[0];
            int targetHash = Integer.parseInt(tokens[1]);

            String modifiedString = modifyString(s, targetHash);
            System.out.println(modifiedString);
        }
    }

    public static String modifyString(String s, int targetHash) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        int currentHash = Math.abs(new String(md.digest(s.getBytes())).hashCode() % 17551);

        if (currentHash == targetHash) {
            return s;
        }

        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == 'Z') {
            i--;
        }

        if (i < 0) {
            return "A" + s;
        }

        char[] charArray = s.toCharArray();
        charArray[i]++;
        for (int j = i + 1; j < charArray.length; j++) {
            charArray[j] = 'A';
        }

        return new String(charArray);
    }
}