package cn.gshkb.data_structure.binarySearch;

import java.util.*;

/**
 * 二分查找
 *
 * @author hkb
 * @create 2019-07-16 16:58 v1.0
 **/
public class MybinarySearch {


	public static int search(int[] nums, int target) {
		int left = 0,right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{-1, 0, 3, 5, 9, 12};

		int target = 9;
		System.out.println(search(nums, target));
	}
}
