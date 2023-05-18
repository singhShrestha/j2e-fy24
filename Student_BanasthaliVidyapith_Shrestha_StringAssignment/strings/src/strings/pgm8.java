package strings;
import java.util.*;
import java.io.*;
public class pgm8 
{
    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        System.out.println("enter the string:");
        String s = br.readLine();
        int count = countPalindromicSubstrings(s);
        System.out.println(count);
    }

    public static int countPalindromicSubstrings(String s) 
    {
        int count = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) 
        {
            count += expandAroundCenter(s, i, i); // odd length palindromes
            count += expandAroundCenter(s, i, i + 1); // even length palindromes
        }

        return count;
    }

    private static int expandAroundCenter(String s, int left, int right) 
    {
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) 
        {
            count++;
            left--;
            right++;
        }

        return count;
    }
}
