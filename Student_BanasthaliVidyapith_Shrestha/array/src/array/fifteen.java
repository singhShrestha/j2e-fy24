package array;
import java.util.Random;
import java.util.Scanner;
public class fifteen 
{
    public int findKthLargest(int[] nums, int k) 
    {
        int left = 0;
        int right = nums.length - 1;
        
        // Convert k to index (0-based)
        k = nums.length - k;
        
        Random rand = new Random();
        
        while (left <= right) 
        {
            int pivotIndex = partition(nums, left, right, rand.nextInt(right - left + 1) + left);
            
            if (pivotIndex < k) 
            {
                left = pivotIndex + 1;
            } 
            else if (pivotIndex > k) 
            {
                right = pivotIndex - 1;
            } 
            else 
            {
                return nums[pivotIndex];
            }
        }
        
        return -1; // Return -1 if k is out of bounds
    }
    
    private int partition(int[] nums, int left, int right, int pivotIndex) 
    {
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right); // Move pivot to the end
        int storeIndex = left;
        
        for (int i = left; i < right; i++)
        {
            if (nums[i] < pivotValue) 
            {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        
        swap(nums, right, storeIndex); // Move pivot to its final place
        return storeIndex;
    }
    
    private void swap(int[] nums, int i, int j) 
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] nums = new int[size];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        fifteen solution = new fifteen(); 
        int kthLargest = solution.findKthLargest(nums, k);

        System.out.println("The " + k + "th largest element is: " + kthLargest);
    }
}
