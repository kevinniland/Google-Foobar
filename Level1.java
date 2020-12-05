package google;

/**
 * @author Kevin Niland
 * 
 *         Problem Description: I Love Lance & Janice
 * 
 *         You've caught two of your fellow minions passing coded notes back and
 *         forth - while they're on duty, no less! Worse, you're pretty sure
 *         it's not job-related - they're both huge fans of the space soap opera
 *         ""Lance & Janice"". You know how much Commander Lambda hates waste,
 *         so if you can prove that these minions are wasting her time passing
 *         non-job-related notes, it'll put you that much closer to a promotion.
 * 
 *         Fortunately for you, the minions aren't exactly advanced
 *         cryptographers. In their code, every lowercase letter [a..z] is
 *         replaced with the corresponding one in [z..a], while every other
 *         character (including uppercase letters and punctuation) is left
 *         untouched. That is, 'a' becomes 'z', 'b' becomes 'y', 'c' becomes
 *         'x', etc. For instance, the word ""vmxibkgrlm"", when decoded, would
 *         become ""encryption"".
 * 
 *         Write a function called solution(s) which takes in a string and
 *         returns the deciphered string so you can show the commander proof
 *         that these minions are talking about ""Lance & Janice"" instead of
 *         doing their jobs.
 */

public class Solution {
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    static String alphabetRev = "zyxwvutsrqponmlkjihgfedcba";
    static String plaintext = "";

    public static String solution(String x) {
        /**
         * Iterate over the cipher text. Check if letter at index i is lowercase or not
         * If it is lowercase, decrypt the letter and add it to the plaintext string
         * Else, if it is any other character, ignore it and add to the plaintext string
         */
        for (int i = 0; i < x.length(); i++) {
            if (isLowerCase(x.charAt(i))) {
                plaintext += decrypt(x.charAt(i));
            } else {
                plaintext += x.charAt(i);
            }
        }

        return plaintext;
    }

    // Check if letter is lowercase
    public static boolean isLowerCase(char c) {
        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.charAt(i) == c) {
                return true;
            }
        }

        return false;
    }

    // Decrypt the cipher
    public static char decrypt(char c) {
        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.charAt(i) == c) {
                return alphabetRev.charAt(i);
            }
        }

        return '-';
    }

    public static void main(String[] args) {
        String x = "Yvzs! I xzm'g yvorvev Lzmxv olhg srh qly zg gsv xlolmb!!";

        Solution.solution(x);
    }
}
