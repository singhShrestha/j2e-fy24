package strings;
import java.util.*;
import java.io.*;
public class pgm10 
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        System.out.println("Enter the word:");
        String word = br.readLine();
        String nextPermutation = findNextPermutation(word);
        System.out.println(nextPermutation);
    }

    public static String findNextPermutation(String word) 
    {
        char[] charArray = word.toCharArray();
        int n = charArray.length;

        int k = n - 2;
        while (k >= 0 && charArray[k] >= charArray[k + 1]) 
        {
            k--;
        }

        if (k < 0) 
        {
            return "no answer";
        }

        // Find the largest index l such that charArray[l] > charArray[k]
        int l = n - 1;
        while (l > k && charArray[l] <= charArray[k]) 
        {
            l--;
        }

        char temp = charArray[k];
        charArray[k] = charArray[l];
        charArray[l] = temp;

        reverse(charArray, k + 1, n - 1);

        return new String(charArray);
    }

    public static void reverse(char[] arr, int start, int end) 
    {
        while (start < end) 
        {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}