/*
Given a string, return a new string made of 3 copies of the last 2 chars of the original string. The string length will be at least 2.

extraEnd("Hello") → "lololo"
extraEnd("ab") → "ababab"
extraEnd("Hi") → "HiHiHi"
*/

import java.util.Collections;

public class ExtraEnd {
    public String extraEnd(String str) {
        return String.join("", Collections.nCopies(3, str.substring(str.length() - 2, str.length())));
    }
}
