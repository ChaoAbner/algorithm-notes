package com.fosuchao.random;

import java.util.*;

/**
 * @Description: leetcode������֮��
 * @Auther: Joker Ye
 * @Date: 2019/11/9 13:51
 */
public class Sum {

    public static void main(String[] args) {
        // ����֮��
//        int[] inList = new int[]{2,7,11,15,9};
//        int[] res = Solution.twoSum1(inList, 11);
//        int[] res = Solution.twoSum2(inList, 11);
//        System.out.println(Arrays.toString(res));

        // ����֮��
        int[] nums = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> lists = Solution.threeSum(nums);
        System.out.println(Arrays.toString(new List[]{lists}));
    }
}

class Solution {
    /*����֮��*/
    // hashMap����
    public static int[] twoSum1(int[] nums, int target) {
        int[] resList = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                resList[0] = map.get(nums[i]);
                resList[1] = i;
                System.out.println(map);
                return resList;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return resList;
    }

    // ��������
    public static int[] twoSum2(int[] nums, int target) {
        int[] resList = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    resList[0] = i;
                    resList[1] = j;
                    return resList;
                }
            }
        }
        return resList;
    }
    /*����֮��*/


    /*����֮��*/

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 1) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        int target = 0;
        int targetCount = 0;
        // �����������
        int spilt0 = -1;
        // ������С����
        int spilt2 = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                spilt0 = i;
            } else if (nums[i] == target) {
                targetCount++;
            } else if (nums[i] > target) {
                spilt2 = i;
                break;
            }
        }

        // ���ֳ�������0���Ϳ϶���һ������000
        List<List<Integer>> result = new ArrayList<>();
        if (targetCount >= 3) {
            result.add(Arrays.asList(0,0,0));
        }

        // ����ʱ��ֻ�зǸ���������ֻ�з�����������000�������Ǵղ����
        if (spilt0 == -1 || spilt2 == -1) {
            // �����п���ȫ������0,��Ȼ�Ϳ϶��޷���������
            return result;
        }

        // ���������������и����ͱ��������ͺ�
        // Ȼ��ʹ�û����б�
        // �Ը����ľ���ֵΪĿ�꣬����2�����С��Ŀ�꣬�����ƣ���������
        for (int i = 0; i <= spilt0; i++) {
            // �����֮ǰ�Ǹ�������ͬ��������ظ��¼�
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}
            int val = nums[i] * -1;
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;
            while (leftIndex < rightIndex) {
                int tmpVal = nums[leftIndex] + nums[rightIndex];
                if (tmpVal > val) {
                    rightIndex--;
                } else if (tmpVal < val) {
                    leftIndex++;
                } else {

                    result.add(Arrays.asList(nums[i], nums[leftIndex], nums[rightIndex]));
                    // ��nums[leftIndex] == nums[leftIndex + 1]�����ظ�
                    while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex + 1]) {
                        leftIndex++;
                    }
                    while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex - 1]) {
                        rightIndex--;
                    }
                    leftIndex++;
                    rightIndex--;
                }
            }
        }
        return result;
    }

//    public static List<List<Integer>> threeSum(int[] nums) {
//        if (nums.length < 3) {
//            return Collections.emptyList();
//        }
//        List<List<Integer>> res = new ArrayList<>();
//        int minValue = Integer.MAX_VALUE;
//        int maxValue = Integer.MIN_VALUE;
//        int negSize = 0;
//        int posSize = 0;
//        int zeroSize = 0;
//        for (int v : nums) {
//            if (v < minValue) {
//                minValue = v;
//            }
//            if (v > maxValue) {
//                maxValue = v;
//            }
//            if (v > 0) {
//                posSize++;
//            } else if (v < 0) {
//                negSize++;
//            } else {
//                zeroSize++;
//            }
//        }
//        if (zeroSize >= 3) {
//            res.add(Arrays.asList(0, 0, 0));
//        }
//        if (negSize == 0 || posSize == 0) {
//            return res;
//        }
//        if (minValue * 2 + maxValue > 0) {
//            maxValue = -minValue * 2;
//        } else if (maxValue * 2 + minValue < 0) {
//            minValue = -maxValue * 2;
//        }
//
//        int[] map = new int[maxValue - minValue + 1];
//        int[] negs = new int[negSize];
//        int[] poses = new int[posSize];
//        negSize = 0;
//        posSize = 0;
//        for (int v : nums) {
//            if (v >= minValue && v <= maxValue) {
//                if (map[v - minValue]++ == 0) {
//                    if (v > 0) {
//                        poses[posSize++] = v;
//                    } else if (v < 0) {
//                        negs[negSize++] = v;
//                    }
//                }
//            }
//        }
//        Arrays.sort(poses, 0, posSize);
//        Arrays.sort(negs, 0, negSize);
//        int basej = 0;
//        for (int i = negSize - 1; i >= 0; i--) {
//            int nv = negs[i];
//            int minp = (-nv) >>> 1;
//            while (basej < posSize && poses[basej] < minp) {
//                basej++;
//            }
//            for (int j = basej; j < posSize; j++) {
//                int pv = poses[j];
//                int cv = 0 - nv - pv;
//                if (cv >= nv && cv <= pv) {
//                    if (cv == nv) {
//                        if (map[nv - minValue] > 1) {
//                            res.add(Arrays.asList(nv, nv, pv));
//                        }
//                    } else if (cv == pv) {
//                        if (map[pv - minValue] > 1) {
//                            res.add(Arrays.asList(nv, pv, pv));
//                        }
//                    } else {
//                        if (map[cv - minValue] > 0) {
//                            res.add(Arrays.asList(nv, cv, pv));
//                        }
//                    }
//                } else if (cv < nv) {
//                    break;
//                }
//            }
//        }
//        return res;
//    }

    /*����֮��*/

}
