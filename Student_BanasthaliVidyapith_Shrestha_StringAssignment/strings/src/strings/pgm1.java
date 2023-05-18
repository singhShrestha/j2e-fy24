package strings;
import java.util.*;
public class pgm1 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string 1");
        String s1 = sc.next();
        System.out.println("Enter the string 2");
        String s2 = sc.next();

        boolean result = backspaceCompare(s1, s2);
        System.out.println(result ? 1 : 0);
    }

    public static boolean backspaceCompare(String s1, String s2) 
    {
        return buildString(s1).equals(buildString(s2));
    }

    private static String buildString(String s) 
    {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) 
        {
            if (c != '#') 
            {
                stack.push(c);
            } 
            else if (!stack.isEmpty()) 
            {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) 
        {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}