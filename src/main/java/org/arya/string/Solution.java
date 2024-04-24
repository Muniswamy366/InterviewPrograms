package org.arya.string;

class Solution {

  public static void main(String[] args) {
    System.out.println(breakPalindrome("aaa"));
  }
  public static String breakPalindrome(String palindrome) {
    boolean all = true;
    if (palindrome.length() == 1) {
      return "";
    }
    for (int i = 0; i < palindrome.length(); i++) {
      if(palindrome.charAt(i) != 'a') {
        all = false;
      }
      if (palindrome.charAt(i) != 'a' && 
          (palindrome.length() % 2 == 0 || i != palindrome.length() / 2)) {
        return palindrome.substring(0, i) + "a" + palindrome.substring(i + 1);
      }
    }
    if(all ){
      return "IMPOSSIBLE";
    } else {
      return palindrome.substring(0, palindrome.length() - 1) + "b";
    }

  }
}