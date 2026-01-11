import java.util.HashMap;
import java.util.Scanner;
public class anewalphabet {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] hold = s.nextLine().toLowerCase().toCharArray();
        HashMap<Character,String> key = new HashMap<>();
        String[] alph = {"@","8","(","|)","3","#","6","[-]","|","_|","|<","1","[]\\/[]","[]\\[]","0","|D","(,)","|Z","$","']['","|_|","\\/","\\/\\/","}{","`/","2"};
        for (int i = 97; i < 123; i++) {
            key.put((char)i,alph[i-97]);
        }
        String product = "";
        for (int i = 0; i < hold.length; i++) {
            if (key.containsKey(hold[i])) {
                product += key.get(hold[i]);
            } else {
                product += hold[i];
            }
        }
        System.out.println(product);
    }
}