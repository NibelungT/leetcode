package leetcode;

import java.util.Arrays;

/**
 * @author: liushitao
 * @description:
 * @date: 2024/4/25 14:38
 * @version: 1.0
 */
public class 合并两个有序数组88 {
    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     *
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     *
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
     * 示例 2：
     *
     * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
     * 输出：[1]
     * 解释：需要合并 [1] 和 [] 。
     * 合并结果是 [1] 。
     * 示例 3：
     *
     * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
     * 输出：[1]
     * 解释：需要合并的数组是 [] 和 [1] 。
     * 合并结果是 [1] 。
     * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
     */

     public static void main(String[] args) {
         merge3(new int[]{0},0,new int[]{1},1);
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int z = 0;

        int i = 0;

        int j = 0;

        int [] num3 = new int [m+n];


        while (i != m || j != n) {
            if (j == n) {
                for (; z < m + n; z++) {
                    num3[z] = nums1[i++];
                }
                break;
            }

            if (i == m) {
                for (; z < m + n; z++) {
                    num3[z] = nums2[j++];
                }
                break;
            }

            if (nums1[i] <= nums2[j] && i < m) {
                num3[z] = nums1[i];
                i++;
            } else if (j < n) {
                num3[z] = nums2[j];
                j++;
            }
            z++;
        }

        if (m + n >= 0) System.arraycopy(num3, 0, nums1, 0, m + n);
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {

         int j = 0;
         for (int i = m; i<m+n ; i++){
             nums1[i] = nums2[j++];
         }

        Arrays.sort(nums1);

    }


    public static void merge3(int[] nums1, int m, int[] nums2, int n) {

         int c = m+n-1;

         int b = n-1;

         int a = m-1;

         while (c>=0){

             if (b<0){
                 nums1[c] = nums1[a];
                 c--; a--;
             }

             else if (a<0){
                 nums1[c] = nums2[b];
                 c--; b--;
             }


             else if (nums1[a] < nums2[b]) {
                 nums1[c] = nums2[b];
                 c--;
                 b--;
             }


             else if (nums1[a] >= nums2[b]) {
                 nums1[c] = nums1[a];
                 c--;
                 a--;
             }

         }
    }


    public static void merge4(int[] nums1, int m, int[] nums2, int n) {

        int c = m+n-1;

        int b = n-1;

        int a = m-1;

        while (c>=0){
            int temp = a >= 0 && (b < 0 || nums1[a] >= nums2[b]) ? nums1[a--] : nums2[b--];
            nums1[c--] = temp;
        }
    }
}
