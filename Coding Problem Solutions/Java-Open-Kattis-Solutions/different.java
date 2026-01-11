import java.math.BigInteger;
import java.util.Scanner;
public class different {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            BigInteger b1 = new BigInteger(s.next());
            BigInteger b2 = new BigInteger(s.next());
            System.out.println(b1.subtract(b2).abs());
        }
    }
}