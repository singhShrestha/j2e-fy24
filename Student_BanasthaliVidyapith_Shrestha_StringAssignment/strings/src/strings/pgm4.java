package strings;
import java.io.*;
import java.util.*;
public class pgm4 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        System.out.println("Enter the number: ");
        int n=Integer.parseInt(br.readLine());
        System.out.println("Enter a list of strings:");
        String[] pangram = new String[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter string "+(i+1));
            pangram[i]=br.readLine();
        }
        String result = checkPangrams(pangram);
        System.out.println(result);
    }

    public static String checkPangrams(String[] pangram) 
    {
        StringBuilder result = new StringBuilder();

        for (String str : pangram) 
        {
            boolean[] letterPresent = new boolean[26];
            int count = 0;

            for (char c : str.toCharArray()) 
            {
                if (c >= 'a' && c <= 'z') 
                {
                    int index = c - 'a';
                    if (!letterPresent[index]) 
                    {
                        letterPresent[index] = true;
                        count++;
                    }
                }
            }

            if (count == 26) 
            {
                result.append("1");
            } 
            else 
            {
                result.append("0");
            }
        }

        return result.toString();
    }
}