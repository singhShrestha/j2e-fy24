package strings;
import java.util.*;
import java.io.*;
public class pgm6 
{
    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        System.out.println("enter the string:");
        int[] securityValues = {1, 2, 1, 3, 1, 3, 5, 7, 1, 1, 5, 5, 8, 10, 11, 1, 23, 2, 3, 7, 8, 9, 1, 6, 5, 9};
        String msg = br.readLine();
        int minSum = minimumSumDifference(securityValues, msg);
        System.out.println(minSum);
    }
    public static int minimumSumDifference(int[] securityValues, String msg) 
    {
        char[] charArray = msg.toCharArray();
        int n = charArray.length;

        // Create a custom class to store characters and their corresponding security values
        CharacterSecurity[] charSecurities = new CharacterSecurity[n];
        for (int i = 0; i < n; i++) 
        {
            char c = charArray[i];
            int securityValue = securityValues[c - 'a'];
            charSecurities[i] = new CharacterSecurity(c, securityValue);
        }

        // Sort the characters based on their security values
        Arrays.sort(charSecurities);

        int minSum = 0;
        for (int i = 0; i < n - 1; i++) 
        {
            int diff = Math.abs(charSecurities[i].securityValue - charSecurities[i + 1].securityValue);
            minSum += diff;
        }

        return minSum;
    }

    // Custom class to store characters and their corresponding security values
    static class CharacterSecurity implements Comparable<CharacterSecurity>
    {
        char character;
        int securityValue;

        public CharacterSecurity(char character, int securityValue) 
        {
            this.character = character;
            this.securityValue = securityValue;
        }

        @Override
        public int compareTo(CharacterSecurity other) 
        {
            return Integer.compare(this.securityValue, other.securityValue);
        }
    }
}
