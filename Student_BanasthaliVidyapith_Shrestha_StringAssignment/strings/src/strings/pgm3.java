package strings;
import java.util.*;
public class pgm3 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string:");
        String word = sc.next();
        int minMoves = find(word);
        System.out.println(minMoves);
    }
    public static int find(String word) 
    {
        StringBuilder sb = new StringBuilder(word);
        int moves = 0;
        int i = 0;

        while (i < sb.length()) 
        {
            char currentChar = sb.charAt(i);
            int leftIndex = sb.lastIndexOf(Character.toString(currentChar), i - 1);
            int rightIndex = sb.indexOf(Character.toString(currentChar), i + 1);

            if (leftIndex != -1 && rightIndex != -1) 
            {
                sb.deleteCharAt(rightIndex);
                sb.deleteCharAt(leftIndex);
                sb.deleteCharAt(i-1);
                moves += 3;
                i = Math.max(i - 2, 0);
            } 
            else 
            {
                i++;
            }
        }

        return moves;
    }
}
