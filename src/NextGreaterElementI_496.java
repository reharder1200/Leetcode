import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/*
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
Note:
All elements in nums1 and nums2 are unique.
The length of both nums1 and nums2 would not exceed 1000.
 */
public class NextGreaterElementI_496 {

public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
       HashMap<Integer,Integer> num=new HashMap<Integer,Integer>();
       Stack<Integer> temp=new Stack<Integer>();
       
       //这一步就过滤出来nums2数组中哪些数字可以输出比他大的数
		for (int i = 0; i < nums2.length; i++) {
			while (!temp.isEmpty() && temp.peek()<nums2[i]) {
				num.put(temp.pop(), nums2[i]);
			}
			temp.push(nums2[i]);
		}
		
		for (int i = 0; i < nums1.length; i++)
			nums1[i] = num.getOrDefault(nums1[i], -1);
        return nums1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(nextGreaterElement(new int[] {2,4},new int[] {1,2,3,4}));
	}

}
