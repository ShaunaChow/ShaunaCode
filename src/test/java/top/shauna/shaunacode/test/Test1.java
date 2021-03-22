package top.shauna.shaunacode.test;

import top.shauna.shaunacode.ShaunaCode;

/**
 * @Author Shauna.Chow
 * @Date 2021/3/21 21:18
 * @E-Mail z1023778132@icloud.com
 */
public class Test1 {

    public static void main(String[] args) {
        String source = "public class Test1 {\n" +
                "    \n" +
                "    public static void main(String[] args){\n" +
                "        System.out.println(\"2321\");\n" +
                "    }\n" +
                "}";
        System.out.println("execute = "+ShaunaCode.remoteExecute(source));
    }
}

