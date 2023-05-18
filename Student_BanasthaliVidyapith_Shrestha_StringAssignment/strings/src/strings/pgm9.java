package strings;
import java.util.*;
import java.io.*;
public class pgm9 
{
    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        System.out.println("Enter the message:");
        String message = br.readLine();
        String compressedString = compressString(message);
        System.out.println(compressedString);
    }

    public static String compressString(String message) 
    {
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        int n = message.length();

        for (int i = 0; i < n; i++) 
        {
            if (i < n - 1 && message.charAt(i) == message.charAt(i + 1)) 
            {
                count++;
            } 
            else 
            {
                compressed.append(message.charAt(i));
                if (count > 1) 
                {
                    compressed.append(count);
                }
                count = 1;
            }
        }

        return compressed.toString();
    }
}