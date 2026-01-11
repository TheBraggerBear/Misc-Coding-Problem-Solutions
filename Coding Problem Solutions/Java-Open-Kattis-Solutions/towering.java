import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class towering {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> boxes = new ArrayList<>();
        String toPrint = "";
        for (int i = 0; i < 6; i++) { // add first six inputs into boxes
            boxes.add(s.nextInt());
        }
        ArrayList<Integer> towers = new ArrayList<>(Arrays.asList(s.nextInt(), s.nextInt()));
        Boolean passed = false;
        while (!passed) { // While either of the towers have not been solved
            int num = towers.get(0) - boxes.get(0);
            int hold = boxes.get(0);
            boxes.remove(0);
            for (int x = 0; x < boxes.size(); x++) {
                for (int z = 0; z < boxes.size(); z++) {
                    if (x != z && boxes.get(x) + boxes.get(z) == num) {
                        int[] hold2 = {hold, boxes.get(x), boxes.get(z)};
                        Arrays.sort(hold2);
                        passed = true;
                        toPrint += hold2[2] + " " + hold2[1] + " " + hold2[0] + " ";
                        boxes.remove(x);
                        boxes.remove(z - 1);
                        int[] last = {boxes.get(0),boxes.get(1),boxes.get(2)};
                        Arrays.sort(last);
                        toPrint += last[2] + " " + last[1] + " " + last[0] + " ";
                    }
                }
            }
            boxes.add(hold);
        }
        System.out.println(toPrint);
    }
}