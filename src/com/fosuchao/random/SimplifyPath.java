package com.fosuchao.random;



import java.util.Arrays;
import java.util.Stack;

/**
 * @Description: �� Unix ������һ���ļ��ľ���·��������Ҫ���������߻��仰˵������ת��Ϊ�淶·����
 *
 * �� Unix �����ļ�ϵͳ�У�һ���㣨.����ʾ��ǰĿ¼�������⣬������ ��..��?��ʾ��Ŀ¼�л�����һ����ָ��Ŀ¼�������߶������Ǹ������·������ɲ��֡�������Ϣ����ģ�Linux / Unix�еľ���·�� vs ���·��
 *
 * ��ע�⣬���صĹ淶·������ʼ����б�� / ��ͷ����������Ŀ¼��֮�����ֻ��һ��б�� /�����һ��Ŀ¼����������ڣ������� / ��β�����⣬�淶·�������Ǳ�ʾ����·��������ַ�����
 *
 * @Auther: Joker Ye
 * @Date: 2019/11/14 19:22
 */
public class SimplifyPath {

    public static void main(String[] args) {
//        String path = "/home/a/b/../";
//        String path = "/../";
        String path = "/a//b////c/d//././/..";
//        String path = "/a/../../b/../c//.//";
        String s = simplifyPath(path);
        System.out.println("���ս�� = " + s);
    }

    public static String simplifyPath(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();
        System.out.println(Arrays.toString(s));

        for (int i = 0; i < s.length; i++) {
            if (!stack.isEmpty() && s[i].equals(".."))
                stack.pop();
            else if (!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."))
                stack.push(s[i]);
        }
        if (stack.isEmpty())
            return "/";

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            res.append("/" + stack.get(i));
        }
        return res.toString();
    }


    public void test(){

        String s = "/abc/...";
        System.out.println(s.endsWith("/..."));

        StringBuffer join = new StringBuffer();

        join.append("sdfds");
        join.append("vdfgd");
        join.append("gjfkd");

        System.out.println("join = " + join.toString());

        join.setLength(0);
        System.out.println("join = " + join.toString());
    }
}
