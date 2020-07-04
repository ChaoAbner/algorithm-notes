package com.fosuchao.random;

import org.junit.Test;

/**
 * @Description: z���α任
 * @Auther: Joker Ye
 * @Date: 2019/11/19 22:09
 */
public class Convert {

    public static void main(String[] args) {
//        String s = "LEETCODEISHIRING";
        String s = "ABCD";
        int numRows = 2;
        String convert = convert(s, numRows);
        System.out.println("ת���ַ���Ϊ��" + convert);
    }

    // Ч�ʺܵ�
    public static String convert(String s, int numRows){
        if(s.length() < 1 || numRows == 1){
            return s;
        }
        // ������ɲ��ֵ��ַ�������
        int cycleStrNum = numRows * 2 - 2;
        // ������ֵ�����
        int cycleColumn = cycleStrNum - numRows + 1;
        // ����м�������
        int cycleNum = s.length() / cycleStrNum;
        // ���µ�����
        int otherColumn = s.length() % cycleStrNum / numRows + s.length() % cycleStrNum % numRows;
        // ��������� length % cycleStrNum / numRows
        int totalColumn = cycleColumn * cycleNum + otherColumn;
        System.out.println("������Ϊ��" + totalColumn);

        String[][] convertList = new String[numRows][totalColumn];
        // ��ʼ����ά����
        int r = 0, c = 0;
        Boolean isDown = true;
        for(int i = 0; i < s.length(); i++){
            if(r == numRows){
                isDown = false;
                c++;
                r = numRows - 2;
            }
            if(r == 0){
                isDown = true;
            }
            if(isDown){
                convertList[r][c] = String.valueOf(s.charAt(i));
                r++;
            } else {
                convertList[r][c] = String.valueOf(s.charAt(i));
                c++;
                r--;
            }
        }
        // ����ַ���
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < totalColumn; j++){
                if(convertList[i][j] != null){
                    stringBuffer.append(convertList[i][j]);
                }
            }
        }
        return stringBuffer.toString();
    }

    /**
     *
     * ����һ����������
     * ˼·
     *
     * ͨ���������ҵ����ַ��������ǿ������ɵ�ȷ���ַ�λ�� Z ����ͼ���е���һ�С�
     *
     * �㷨
     *
     * ���ǿ���ʹ�� \text{min}( \text{numRows}, \text{len}(s))min(numRows,len(s)) ���б�����ʾ Z ����ͼ���еķǿ��С�
     *
     * �����ҵ��� ss����ÿ���ַ���ӵ����ʵ��С�����ʹ�õ�ǰ�к͵�ǰ���������������Ժ��ʵ��н��и��١�
     *
     * ֻ�е����������ƶ�����������л������ƶ������������ʱ����ǰ����Żᷢ���ı䡣
     *
     * C++Java
     * class Solution {
     *     public String convert(String s, int numRows) {
     *
     *         if (numRows == 1) return s;
     *
     *         List<StringBuilder> rows = new ArrayList<>();
     *         for (int i = 0; i < Math.min(numRows, s.length()); i++)
     *             rows.add(new StringBuilder());
     *
     *         int curRow = 0;
     *         boolean goingDown = false;
     *
     *         for (char c : s.toCharArray()) {
     *             rows.get(curRow).append(c);
     *             if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
     *             curRow += goingDown ? 1 : -1;
     *         }
     *
     *         StringBuilder ret = new StringBuilder();
     *         for (StringBuilder row : rows) ret.append(row);
     *         return ret.toString();
     *     }
     * }
     * ���Ӷȷ���
     *
     * ʱ�临�Ӷȣ�O(n)O(n)������ n == \text{len}(s)n==len(s)
     * �ռ临�Ӷȣ�O(n)O(n)
     * �����������з���
     * ˼·
     *
     * ���������ж�ȡ Z ����ͼ����ͬ��˳������ַ�����
     *
     * �㷨
     *
     * ���ȷ��� �� 0 �е������ַ������ŷ��� �� 1��Ȼ�� �� 2����������...
     *
     * ������������ kk��
     *
     * �� 00 �е��ַ�λ������ k \; (2 \cdot \text{numRows} - 2)k(2?numRows?2) ��;
     * �� \text{numRows}-1numRows?1 �е��ַ�λ������ k \; (2 \cdot \text{numRows} - 2) + \text{numRows} - 1k(2?numRows?2)+numRows?1 ��;
     * �ڲ��� �� ii �е��ַ�λ������ k \; (2 \cdot \text{numRows}-2)+ik(2?numRows?2)+i �Լ� (k+1)(2 \cdot \text{numRows}-2)- i(k+1)(2?numRows?2)?i ��;
     * C++Java
     * class Solution {
     *     public String convert(String s, int numRows) {
     *
     *         if (numRows == 1) return s;
     *
     *         StringBuilder ret = new StringBuilder();
     *         int n = s.length();
     *         int cycleLen = 2 * numRows - 2;
     *
     *         for (int i = 0; i < numRows; i++) {
     *             for (int j = 0; j + i < n; j += cycleLen) {
     *                 ret.append(s.charAt(j + i));
     *                 if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
     *                     ret.append(s.charAt(j + cycleLen - i));
     *             }
     *         }
     *         return ret.toString();
     *     }
     * }
     * ���Ӷȷ���
     *
     * ʱ�临�Ӷȣ�O(n)O(n)������ n == \text{len}(s)n==len(s)��ÿ������������һ�Ρ�
     * �ռ临�Ӷȣ�O(n)O(n)������ C++ ʵ�֣���������ַ���������Ϊ����ռ䣬���Ӷ�Ϊ O(1)O(1)��
     */


    @Test
    public void test(){
        String[][] testList = new String[10][10];

        System.out.println(testList[0][0]);
        System.out.println(3 / 2);
    }
}
