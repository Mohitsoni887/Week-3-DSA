/*
 * Remove Duplicates from a String Using StringBuilder
Problem:
Write a program that uses StringBuilder to remove all duplicate characters from a given string while maintaining the original order.
Approach:
Initialize an empty StringBuilder and a HashSet to keep track of characters.
Iterate over each character in the string:
If the character is not in the HashSet, append it to the StringBuilder and add it to the HashSet.
Return the StringBuilder as a string without duplicates.
 */
import java.util.HashSet;

public class RemoveDuplicates {
    public static String removeDuplicates(String input) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "programming";
        String result = removeDuplicates(input);
        System.out.println("String without duplicates: " + result);  // Output: "progamin"
    }
}
