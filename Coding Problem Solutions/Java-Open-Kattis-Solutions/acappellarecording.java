import java.util.Arrays;
import java.util.Scanner;
public class acappellarecording {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int max = s.nextInt();
        int count = 1;
        int[] val = new int[num];
        for (int i = 0; i < num; i++) {
            val[i] = s.nextInt();
        }
        Arrays.sort(val);
        int hold = val[0];
        for (int i = 0; i < val.length -1; i++) {
            if (Math.abs(hold - val[i+1]) > max) {
                hold = val[i+1];
                count++;
            }
        }
        System.out.println(count);
    }
}
