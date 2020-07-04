package com.fosuchao.hot;

/** https://leetcode-cn.com/problems/move-zeroes/
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2020/1/23 16:01
 */
public class MoveZero {
    public static void main(String[] args) {
        MoveZero moveZero = new MoveZero();
        int[] nums = {2, 1};
        moveZero.moveZeroes(nums);
    }

    public void moveZeroes(int[] nums) {
        int index = 0;
        // 将n个不等于0的值，赋给nums的前n个位置中
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }

        // 将n后面的值全部置为0
        for(; index < nums.length; index++){
            nums[index] = 0;
        }
    }
}
