/*
 * Linear Search Problem 2: Search for a Specific Word in a List of Sentences
Problem:
You are given an array of sentences (strings). Write a program that performs Linear Search to find the first sentence containing a specific word. If the word is found, return the sentence. If no sentence contains the word, return "Not Found".
Approach:
Iterate through the list of sentences.
For each sentence, check if it contains the specific word.
If the word is found, return the current sentence.
If no sentence contains the word, return "Not Found".
 */
public class SentenceSearch {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence; // Return the first sentence that contains the word
            }
        }
        return "Not Found"; // No sentence contains the word
    }

    public static void main(String[] args) {
        String[] sentences = {
            "Java is a powerful programming language.",
            "Data structures are essential for problem-solving.",
            "Machine learning is a trending topic.",
            "I love solving coding challenges."
        };
        String word = "coding"; // Word to search for

        String result = findSentenceWithWord(sentences, word);
        System.out.println("Result: " + result);
    }
}
