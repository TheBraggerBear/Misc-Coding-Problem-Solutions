import java.util.Scanner;

public class areal {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        double hold = Double.valueOf(s.nextLine());
        hold = Math.sqrt(hold) * 4;
        System.out.println(hold);
    }
}
