package com.fosuchao.random;



import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2019/11/16 15:37
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        int c = lengthOfLongestSubstring("dvdf");
        System.out.println(c);
    }

    public static int lengthOfLongestSubstring(String s) {
        if(" ".equals(s)){
            return 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++){
            String str = String.valueOf(s.charAt(i));
            // �������
            if(stringBuilder.indexOf(str) != -1){
                maxLength = stringBuilder.length() > maxLength ? stringBuilder.length() : maxLength;
                stringBuilder.delete(0, stringBuilder.indexOf(str)+1);
            }
            stringBuilder.append(str);
        }
        if(stringBuilder.length() > maxLength){
            maxLength = stringBuilder.length();
        }
        System.out.println(stringBuilder);
        return maxLength;
    }

//    �����������������㷨
//
//    �ڱ������У����ǻᷴ�����һ�����ַ����Ƿ������ظ����ַ���������û�б�Ҫ�ġ���������� ii �� j - 1j?1 ֮������ַ��� s_{ij}s
//            ij
//?
//    �Ѿ������Ϊû���ظ��ַ�������ֻ��Ҫ��� s[j]s[j] ��Ӧ���ַ��Ƿ��Ѿ����������ַ��� s_{ij}s
//            ij
//?
//    �С�
//
//    Ҫ���һ���ַ��Ƿ��Ѿ������ַ����У����ǿ��Լ���������ַ������⽫����һ�����Ӷ�Ϊ O(n^2)O(n
//2
//        ) ���㷨�������ǿ������ø��á�
//
//    ͨ��ʹ�� HashSet ��Ϊ�������ڣ����ǿ����� O(1)O(1) ��ʱ������ɶ��ַ��Ƿ��ڵ�ǰ�����ַ����еļ�顣
//
//    ��������������/�ַ��������г��õĳ����� ����ͨ����������/�ַ������ɿ�ʼ�ͽ������������һϵ��Ԫ�صļ��ϣ��� [i, j)[i,j)����գ��ҿ����������������ǿ��Խ������߽���ĳһ���򡰻������Ĵ��ڡ����磬���ǽ� [i, j)[i,j) ���һ��� 11 ��Ԫ�أ���������Ϊ [i+1, j+1)[i+1,j+1)����գ��ҿ�����
//
//    �ص����ǵ����⣬����ʹ�� HashSet ���ַ��洢�ڵ�ǰ���� [i, j)[i,j)����� j = ij=i���С� Ȼ���������Ҳ໬������ jj����������� HashSet �У����ǻ�������� jj��ֱ�� s[j] �Ѿ������� HashSet �С���ʱ�������ҵ���û���ظ��ַ�������ַ������������� ii ��ͷ��������Ƕ����е� ii ���������Ϳ��Եõ��𰸡�
//
//    Java

    public void lengthOfLongestSubstring1() {
        String s = "pwwkew";
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
            System.out.println(set);
        }
    }
//    ���Ӷȷ���
//
//    ʱ�临�Ӷȣ�O(2n) = O(n)O(2n)=O(n)��������������£�ÿ���ַ����� ii �� jj �������Ρ�
//
//    �ռ临�Ӷȣ�O(min(m, n))O(min(m,n))����֮ǰ�ķ�����ͬ���������ڷ���Ҫ O(k)O(k) �Ŀռ䣬���� kk ��ʾ Set �Ĵ�С���� Set �Ĵ�Сȡ�����ַ��� nn �Ĵ�С�Լ��ַ��� / ��ĸ mm �Ĵ�С��
//
//    ���������Ż��Ļ�������
//    �����ķ��������Ҫִ�� 2n �����衣��ʵ�ϣ������Ա���һ���Ż�Ϊ����Ҫ n �����衣���ǿ��Զ����ַ���������ӳ�䣬������ʹ�ü������ж�һ���ַ��Ƿ���ڡ� �������ҵ��ظ����ַ�ʱ�����ǿ������������ô��ڡ�
//
//    Ҳ����˵����� s[j]s[j] �� [i, j)[i,j) ��Χ������ j'j
//            ��
//    �ظ����ַ������ǲ���Ҫ������ ii �� ���ǿ���ֱ������ [i��j'][i��j
//            ��
//            ] ��Χ�ڵ�����Ԫ�أ����� ii ��Ϊ j' + 1j
//            ��
//            +1��
//
//    Java��ʹ�� HashMap��
//
//    Java
//    public class Solution {
//        public int lengthOfLongestSubstring(String s) {
//            int n = s.length(), ans = 0;
//            Map<Character, Integer> map = new HashMap<>(); // current index of character
//            // try to extend the range [i, j]
//            for (int j = 0, i = 0; j < n; j++) {
//                if (map.containsKey(s.charAt(j))) {
//                    i = Math.max(map.get(s.charAt(j)), i);
//                }
//                ans = Math.max(ans, j - i + 1);
//                map.put(s.charAt(j), j + 1);
//            }
//            return ans;
//        }
//    }
//    Java�������ַ���Ϊ ASCII 128��
//
//    ��ǰ�����Ƕ�û�ж��ַ��� s ��ʹ�õ��ַ������м��衣
//
//    ������֪�����ַ����Ƚ�С��ʱ����ǿ�����һ������������Ϊֱ�ӷ��ʱ����滻 Map��
//
//    ���õı�������ʾ��
//
//    int [26] ������ĸ ��a�� - ��z�� �� ��A�� - ��Z��
//    int [128] ����ASCII��
//    int [256] ������չASCII��
//            Java

    public void lengthOfLongestSubstring3() {
        String s = "pwwkew";
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
            System.out.println(Arrays.toString(index));
        }
    }



    public void test(){
        String s = "pwwkew";
        int[] index = new int[128];
        System.out.println(s.charAt(5));
        index[s.charAt(5)] = 6;
        System.out.println(Arrays.toString(index));
        StringBuilder stringBuilder = new StringBuilder("dvdf");
        System.out.println(stringBuilder.indexOf("d"));
        stringBuilder.delete(0, 1);
        System.out.println(stringBuilder);
    }
}
