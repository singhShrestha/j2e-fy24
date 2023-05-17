package array;

import java.util.Scanner;

public class fourteen {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
        }
        
        return maxCount;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] nums = new int[size];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }
        
        int maxConsecutiveOnes = findMaxConsecutiveOnes(nums);
        System.out.println("Maximum consecutive ones: " + maxConsecutiveOnes);
    }
    
}
