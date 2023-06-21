import java.util.Scanner;

public class TopScoreG {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        input.nextLine();

        int maxScore = 100;
        int prevLevel = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String monsterName = input.nextLine();
            int monsterLevel = calculateMonsterLevel(monsterName);

            if (monsterLevel < prevLevel) {
                maxScore += 100;
                prevLevel = monsterLevel;
            }
        }

        System.out.println(maxScore);
    }

    private static int calculateMonsterLevel(String monsterName) {
        int level = 0;
        for (char c : monsterName.toCharArray()) {
            if(c=='a'){
                level+=1;
            }
            if(c=='i'){
                level+=10;
            }
            if(c=='u'){
                level+=100;
            }
            if(c=='e'){
                level+=1000;
            }
            if(c=='o'){
                level+=10000;
            }
        }
        return level;
    }
}