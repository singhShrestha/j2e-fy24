package array;

import java.util.Scanner;

public class twelve {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tempLen = m;
            m = n;
            n = tempLen;
        }
        
        int low = 0;
        int high = m;
        int halfLen = (m + n + 1) / 2;
        
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = halfLen - partitionX;
            
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        
        throw new IllegalArgumentException("Arrays are not sorted!");
    }
    
     public static void main(String[] args) {
         
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array1: ");
        int size1 = scanner.nextInt();
        int[] nums1 = new int[size1];

        System.out.println("Enter the array 1 elements:");
        for (int i = 0; i < size1; i++) {
            nums1[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the size of the array1: ");
        int size2 = scanner.nextInt();
        int[] nums2 = new int[size2];

        System.out.println("Enter the array 1 elements:");
        for (int i = 0; i < size2; i++) {
            nums2[i] = scanner.nextInt();
        }
       
        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println("Median: " + median);
    }
}