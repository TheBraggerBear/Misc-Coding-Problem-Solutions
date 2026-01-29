import java.util.Scanner;

public class KatissASecondOpinion {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int hold = s.nextInt();
        int hours = hold / 3600;
        hold %= 3600;
        int minutes = hold / 60;
        hold %= 60;
        int seconds = hold;
        System.out.println(hours + " : " + minutes + " : " + seconds);
    }
}