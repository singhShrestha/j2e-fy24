package strings;
import java.util.*;
public class pgm2 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string:");
        String inputStr = sc.next();
        int minPackets = find(inputStr);
        System.out.println(minPackets);
    }

    public static int find(String str) 
    {
        int count = 0;
        for (int i = 1; i < str.length(); i++) 
        {
            if (str.charAt(i) != str.charAt(i - 1)) 
            {
                count++;
            }
        }
        return count + 1;
    }
}
