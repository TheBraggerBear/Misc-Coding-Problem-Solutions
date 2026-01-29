import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class hydrasheads {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> heads = new ArrayList<>();
        List<Integer> tails = new ArrayList<>();

        while (sc.hasNext()) {
            heads.add(sc.nextInt());
            tails.add(sc.nextInt());
            sc.nextLine(); // Consume the newline character
        }
        
        int moves = 0;
        String print = "";
        int hydra = 0;
        while (heads.size() > 0 && tails.size() > 0) {
            if (heads.get(hydra) > 1) {
                heads.set(hydra, heads.get(hydra) - 2);
                moves++;
                continue;
            }
            if (tails.get(hydra) > 1) {
                tails.set(hydra, tails.get(hydra) - 2);
                heads.set(hydra, heads.get(hydra) + 1);
                moves++;
                continue;
            }
            if (heads.get(hydra) == 0 && tails.get(hydra) == 0) {
                hydra++;
                print += moves;
                print += "\n";
                moves = 0;
            }
        }
    }
}
