package strings;
import java.util.*;
import java.io.*;
public class pgm5 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        System.out.println("Enter a string containing  only the characters '(' and ')' and same in number:");
        String s = br.readLine();
        int minSwaps = minimumSwaps(s);
        System.out.println(minSwaps);
    }

    public static int minimumSwaps(String s) 
    {
        Stack<Character> stack = new Stack<>();
        int swaps = 0;

        for (char c : s.toCharArray()) 
        {
            if (c == '(') 
            {
                stack.push(c);
            } 
            else 
            {
                if (!stack.isEmpty() && stack.peek() == '(') 
                {
                    stack.pop();
                } 
                else 
                {
                    swaps++;
                }
            }
        }

        return swaps;
    }
}