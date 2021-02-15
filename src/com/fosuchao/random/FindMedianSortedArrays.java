package com.fosuchao.random;



import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2019/11/16 23:13
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {2, 3};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        int cursor1 = 0;
        int cursor2 = 0;
        int[] newList = new int[nums1.length + nums2.length];
        int resCur = 0;
        while (cursor1 != nums1.length || cursor2 != nums2.length) {
            if(cursor1 == nums1.length){
                newList[resCur++] = nums2[cursor2];
                cursor2++;
                continue;
            }
            if(cursor2 == nums2.length){
                newList[resCur++] = nums1[cursor1];
                cursor1++;
                continue;
            }
            if(nums1[cursor1] > nums2[cursor2]){
                newList[resCur++] = nums2[cursor2];
                cursor2++;
            } else if(nums1[cursor1] < nums2[cursor2]){
                newList[resCur++] = nums1[cursor1];
                cursor1++;
            } else {
                newList[resCur++] = nums2[cursor2];
                newList[resCur++] = nums2[cursor2];
                cursor1++;
                cursor2++;
            }
        }

        if(newList.length % 2 == 1){
            result = newList[newList.length / 2];
        } else {
            result = (newList[newList.length / 2 - 1] + newList[newList.length / 2]) / 2.0;
        }
        return result;
    }

    /**
     * ?????????
     * ?????????????????????? ??????????????????????????????????????????
     *
     * ????????????????????????????????????????????????????????????????????
     *
     * ????????????????????????????????????
     *
     * ??????????????????? ii ?? \text{A}A ??????????????
     *
     *           left_A             |        right_A
     *     A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
     * ???? \text{A}A ???? mm ?????? ?????????? m+1m+1 ???????????i = 0 \sim mi=0?m????
     *
     * ?????????
     *
     * \text{len}(\text{left\_A}) = i, \text{len}(\text{right\_A}) = m - ilen(left_A)=i,len(right_A)=m?i.
     *
     * ????? i = 0i=0 ???\text{left\_A}left_A ?????? ???? i = mi=m ?, \text{right\_A}right_A ??????
     *
     * ????????????????????????? jj ?? \text{B}B ??????????????
     *
     *           left_B             |        right_B
     *     B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
     * ?? \text{left\_A}left_A ?? \text{left\_B}left_B ???????????????? \text{right\_A}right_A ?? \text{right\_B}right_B ?????????????? ?????????????????????? \text{left\_part}left_part ?? \text{right\_part}right_part??
     *
     *           left_part          |        right_part
     *     A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
     *     B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
     * ??????????????
     *
     * \text{len}(\text{left\_part}) = \text{len}(\text{right\_part})len(left_part)=len(right_part)
     * \max(\text{left\_part}) \leq \min(\text{right\_part})max(left_part)??min(right_part)
     * ?????????????? \{\text{A}, \text{B}\}{A,B} ??????????????????????????????????????????????????????????????????????????
     *
     * \text{median} = \frac{\text{max}(\text{left}\_\text{part}) + \text{min}(\text{right}\_\text{part})}{2}
     * median=
     * 2
     * max(left_part)+min(right_part)
     * ?
     *
     *
     * ?????????????????????????????
     *
     * i + j = m - i + n - ji+j=m?i+n?j????m - i + n - j + 1m?i+n?j+1??
     * ??? n \geq mn??m??????? \ i = 0 \sim m,\ j = \frac{m + n + 1}{2} - i \\?i=0?m,?j=
     * 2
     * m+n+1
     * ?
     *  ?i
     *
     * \text{B}[j-1] \leq \text{A}[i]B[j?1]??A[i] ??? \text{A}[i-1] \leq \text{B}[j]A[i?1]??B[j]
     *
     * ps.1 ?????????????? \text{A}[i-1], \text{B}[j-1], \text{A}[i], \text{B}[j]A[i?1],B[j?1],A[i],B[j] ??????????????? i=0i=0??i=mi=m??j=0j=0?????? j=nj=n ???????????????
     * ???????????????????????????
     *
     * ps.2 ??? n \geq mn??m??????0 \leq i \leq m0??i??m ?? j = \frac{m + n + 1}{2} - ij=
     * 2
     * m+n+1
     * ?
     *  ?i?????????? jj ???????????? n < mn<m????? jj ???????????????????????????
     *
     * ???????????????????
     *
     * ?? [0??m][0??m] ????????????????? ii???????
     *
     * \qquad \text{B}[j-1] \leq \text{A}[i]B[j?1]??A[i] ?? \text{A}[i-1] \leq \text{B}[j],A[i?1]??B[j], ???? j = \frac{m + n + 1}{2} - ij=
     * 2
     * m+n+1
     * ?
     *  ?i
     *
     * ???????????????????????????????????????
     *
     * ?? \text{imin} = 0imin=0??\text{imax} = mimax=m, ?????? [\text{imin}, \text{imax}][imin,imax] ???????????
     *
     * ?? i = \frac{\text{imin} + \text{imax}}{2}i=
     * 2
     * imin+imax
     * ?
     *  ?? j = \frac{m + n + 1}{2} - ij=
     * 2
     * m+n+1
     * ?
     *  ?i
     *
     * ?????????? \text{len}(\text{left}\_\text{part})=\text{len}(\text{right}\_\text{part})len(left_part)=len(right_part)?? ????????????????????????
     *
     * \text{B}[j-1] \leq \text{A}[i]B[j?1]??A[i] ?? \text{A}[i-1] \leq \text{B}[j]A[i?1]??B[j]??
     * ?????????????????????? ii?????????????????
     *
     * \text{B}[j-1] > \text{A}[i]B[j?1]>A[i]??
     * ??????? \text{A}[i]A[i] ?????????????? ii ??? \text{B}[j-1] \leq \text{A}[i]B[j?1]??A[i]??
     * ??????????? ii ??
     * ??????????????? ii ??????????jj ????????
     * ????????? \text{B}[j-1]B[j?1] ???????? \text{A}[i]A[i] ????????? \text{B}[j-1] \leq \text{A}[i]B[j?1]??A[i] ??????????
     * ????????? ii ??
     * ???????????????? ii ??????????jj ???????
     * ????????? \text{B}[j-1]B[j?1] ??????? \text{A}[i]A[i] ????????? \text{B}[j-1] \leq \text{A}[i]B[j?1]??A[i] ??????????
     * ??????????????? ii????????????????????????????? [i+1, \text{imax}][i+1,imax]??
     * ?????? \text{imin} = i+1imin=i+1??????????? 2??
     *
     * \text{A}[i-1] > \text{B}[j]A[i?1]>B[j]??
     * ??????? \text{A}[i-1]A[i?1] ???????????? ii ??? \text{A}[i-1]\leq \text{B}[j]A[i?1]??B[j]??
     * ??????????????????????????? [\text{imin}, i-1][imin,i?1]??
     * ?????? \text{imax} = i-1imax=i?1??????????? 2??
     *
     * ??????????? ii ???????????
     *
     * \max(\text{A}[i-1], \text{B}[j-1]),max(A[i?1],B[j?1]), ?? m + nm+n ??????
     *
     * \frac{\max(\text{A}[i-1], \text{B}[j-1]) + \min(\text{A}[i], \text{B}[j])}{2},
     * 2
     * max(A[i?1],B[j?1])+min(A[i],B[j])
     * ?
     *  , ?? m + nm+n ?????
     *
     * ???????????????????????? i=0,i=m,j=0,j=ni=0,i=m,j=0,j=n????? \text{A}[i-1],\text{B}[j-1],\text{A}[i],\text{B}[j]A[i?1],B[j?1],A[i],B[j] ??????????
     * ??????????????????????????
     *
     * ???????????????? \text{max}(\text{left}\_\text{part}) \leq \text{min}(\text{right}\_\text{part})max(left_part)??min(right_part)?? ??????? ii ?? jj ????????????????? \text{A}[i-1], \text{B}[j-1],\text{A}[i],\text{B}[j]A[i?1],B[j?1],A[i],B[j] ????????, ??????????????? \text{B}[j-1] \leq \text{A}[i]B[j?1]??A[i] ??? \text{A}[i-1] \leq \text{B}[j]A[i?1]??B[j] ????????
     * ??????? \text{A}[i-1],\text{B}[j-1],\text{A}[i],\text{B}[j]A[i?1],B[j?1],A[i],B[j] ?????????????????????????????????????????????????????
     * ??????????? i = 0i=0????? \text{A}[i-1]A[i?1] ??????????????????? \text{A}[i-1] \leq \text{B}[j]A[i?1]??B[j] ????????
     * ???????????????????
     *
     * ?? [0??m][0??m] ????????????????? ii???????
     *
     * (j = 0(j=0 or i = mi=m or \text{B}[j-1] \leq \text{A}[i])B[j?1]??A[i]) ????
     * (i = 0(i=0 or j = nj=n or \text{A}[i-1] \leq \text{B}[j]),A[i?1]??B[j]), ???? j = \frac{m + n + 1}{2} - ij=
     * 2
     * m+n+1
     * ?
     *  ?i
     *
     * ????????????????????????????????
     *
     * (j = 0(j=0 or i = mi=m or \text{B}[j-1] \leq \text{A}[i])B[j?1]??A[i]) ???? (i = 0(i=0 or j = nj=n or \text{A}[i-1] \leq \text{B}[j])A[i?1]??B[j])????????? ii ????????????????????????
     * j > 0j>0 and i < mi<m and \text{B}[j - 1] > \text{A}[i]B[j?1]>A[i] ??????? ii ???????????????????
     * i > 0i>0 and j < nj<n and \text{A}[i - 1] > \text{B}[j]A[i?1]>B[j] ??????? ii ????????????????
     * ??? @Quentin.chen ?????i < m \implies j > 0i<m?j>0 ??? i > 0 \implies j < ni>0?j<n ?????????????????
     *
     * m \leq n,\ i < m \implies j = \frac{m+n+1}{2} - i > \frac{m+n+1}{2} - m \geq \frac{2m+1}{2} - m \geq 0
     * m??n,?i<m?j=
     * 2
     * m+n+1
     * ?
     *  ?i>
     * 2
     * m+n+1
     * ?
     *  ?m??
     * 2
     * 2m+1
     * ?
     *  ?m??0
     *
     * m \leq n,\ i > 0 \implies j = \frac{m+n+1}{2} - i < \frac{m+n+1}{2} \leq \frac{2n+1}{2} \leq n
     * m??n,?i>0?j=
     * 2
     * m+n+1
     * ?
     *  ?i<
     * 2
     * m+n+1
     * ?
     *  ??
     * 2
     * 2n+1
     * ?
     *  ??n
     *
     * ?????????? 2 ?? 3?????????????? j > 0j>0 ???? j < nj< n ????????
     *
     *     public double findMedianSortedArrays(int[] A, int[] B) {
     *         int m = A.length;
     *         int n = B.length;
     *         if (m > n) { // to ensure m<=n
     *             int[] temp = A; A = B; B = temp;
     *             int tmp = m; m = n; n = tmp;
     *         }
     *         int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
     *         while (iMin <= iMax) {
     *             int i = (iMin + iMax) / 2;
     *             int j = halfLen - i;
     *             if (i < iMax && B[j-1] > A[i]){
     *                 iMin = i + 1; // i is too small
     *             }
     *             else if (i > iMin && A[i-1] > B[j]) {
     *                 iMax = i - 1; // i is too big
     *             }
     *             else { // i is perfect
     *                 int maxLeft = 0;
     *                 if (i == 0) { maxLeft = B[j-1]; }
     *                 else if (j == 0) { maxLeft = A[i-1]; }
     *                 else { maxLeft = Math.max(A[i-1], B[j-1]); }
     *                 if ( (m + n) % 2 == 1 ) { return maxLeft; }
     *
     *                 int minRight = 0;
     *                 if (i == m) { minRight = B[j]; }
     *                 else if (j == n) { minRight = A[i]; }
     *                 else { minRight = Math.min(B[j], A[i]); }
     *
     *                 return (maxLeft + minRight) / 2.0;
     *             }
     *         }
     *         return 0.0;
     *     }
     * ????????
     *
     * ???????O\big(\log\big(\text{min}(m,n)\big)\big)O(log(min(m,n)))??
     * ???????????????? [0, m][0,m]??
     * ????????????????????????????????????
     * ???????????????? \log(m)log(m) ????????????????????????????????????????????????????? O\big(\log(m)\big)O(log(m))??
     * ???? m \leq nm??n?????????????? O\big(\log\big(\text{min}(m,n)\big)\big)O(log(min(m,n)))??
     *
     * ???????O(1)O(1)??
     * ??????????????????? 99 ??????????? ?????????? O(1)O(1)??
     */


    public void test(){
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        int cursor1 = 0;
        int cursor2 = 0;
        int[] newList = new int[nums1.length + nums2.length];
        int resCur = 0;
//        while (cursor1 != nums1.length || cursor2 != nums2.length) {
//            if(cursor1 == nums1.length){
//                newList[resCur++] = nums2[cursor2];
//                cursor2++;
//                continue;
//            }
//            if(cursor2 == nums2.length){
//                newList[resCur++] = nums1[cursor1];
//                cursor1++;
//                continue;
//            }
//            if(nums1[cursor1] > nums2[cursor2]){
//                newList[resCur++] = nums2[cursor2];
//                cursor2++;
//            } else if(nums1[cursor1] < nums2[cursor2]){
//                newList[resCur++] = nums1[cursor1];
//                cursor1++;
//            } else {
//                newList[resCur++] = nums2[cursor2];
//                newList[resCur++] = nums2[cursor2];
//                cursor1++;
//                cursor2++;
//            }
//        }

        double res = 0;
        if(newList.length / 2 % 2 == 0){
            res = (newList[newList.length / 2 - 1] + newList[newList.length / 2]) / 2;
        } else {
            res = newList[newList.length / 2];
        }
        System.out.println("????????" + res);

        System.out.println(Arrays.toString(newList));
        System.out.println(newList.length / 2);
    }
}
