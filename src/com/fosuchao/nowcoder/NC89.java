package com.fosuchao.nowcoder;

/**
 * Created by Chao Ye on 2021/2/9
 */
public class NC89 {

    public String trans(String s, int n) {
        // write code here
        String[] tmp = s.split(" ", -1);
        StringBuilder sb = new StringBuilder();
        for (int i = tmp.length - 1; i >= 0; i--) {
            sb.append(tmp[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        // 修改大小写
        return reverseCase(sb.toString());
    }

    private String reverseCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c = (char) (c - 32);
            } else if (c >= 'A' && c <= 'Z'){
                c = (char) (c + 32);
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        NC89 nc89 = new NC89();
//        System.out.println(nc89.trans(" h i", 4));
        System.out.println('0' - 48);
    }
}
