/*
Given two strings, append them together (known as "concatenation") and return the result. 
However, if the concatenation creates a double-char, then omit one of the chars, so "abc" and "cat" yields "abcat".

conCat("abc", "cat") → "abcat"
conCat("dog", "cat") → "dogcat"
conCat("abc", "") → "abc"
*/

public class ConCat {
    public String conCat(String a, String b) {
        boolean aempty = a.isEmpty();
        boolean bempty = b.isEmpty();
        if (aempty || bempty) {
            if (aempty && !bempty) {
                return b;
            }
            if (!aempty && bempty) {
                return a;
            }
            return "";
        }
        return a.charAt(a.length()-1) == b.charAt(0) ? a + b.substring(1) : a+b;
    }
}
