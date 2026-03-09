/*
Return true if the given string contains between 1 and 3 'e' chars.

stringE("Hello") → true
stringE("Heelle") → true
stringE("Heelele") → false
*/

public class StringE {
    public boolean stringE(String str) {
        return (int) str.chars().filter(ch -> ch == 'e').count() >= 1 && (int) str.chars().filter(ch -> ch == 'e').count() <= 3;
    }
}
