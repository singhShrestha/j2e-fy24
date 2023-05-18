package strings;
import java.util.*;
import java.io.*;
public class pgm7 
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        System.out.println("Enter the string:");
        String s = br.readLine();
        int count = countNonRepeatingSubstrings(s);
        System.out.println(count);
    }

    public static int countNonRepeatingSubstrings(String s) 
    {
        int n = s.length();
        Set<Character> window = new HashSet<>();
        int count = 0;
        int left = 0;
        int right = 0;

        while (right < n) 
        {
            char c = s.charAt(right);
            if (!window.contains(c)) 
            {
                window.add(c);
                count += right - left + 1;
                right++;
            } 
            else 
            {
                window.remove(s.charAt(left));
                left++;
            }
        }

        return count;
    }
}
