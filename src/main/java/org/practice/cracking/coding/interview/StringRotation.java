package org.practice.cracking.coding.interview;

public class StringRotation {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        if(s1 != null && s2 != null && s1.length() == s2.length()) {
            System.out.println(isSubString(s1.concat(s1), s2));
        }

    }

    public static boolean isSubString(String s1, String s2) {

        return  s1.contains(s2);
//        for (int i=0; i < s1.length(); i++) {
//            String s = s1.substring(i, s2.length()+i);
//            if(s2.equals(s)) {
//                return true;
//            }
//
//        }
//        return false;
    }
}
