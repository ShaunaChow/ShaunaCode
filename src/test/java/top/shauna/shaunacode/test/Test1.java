package top.shauna.shaunacode.test;

import top.shauna.shaunacode.ShaunaCode;
import top.shauna.shaunacode.util.system.ShaunaSystem;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @Author Shauna.Chow
 * @Date 2021/3/21 21:18
 * @E-Mail z1023778132@icloud.com
 */
public class Test1 {

    public static void main(String[] args) throws IOException {
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                String source = "import top.shauna.shaunacode.ShaunaCode;\n" +
//                        "\n" +
//                        "/**\n" +
//                        " * @Author Shauna.Chow\n" +
//                        " * @Date 2021/3/21 21:18\n" +
//                        " * @E-Mail z1023778132@icloud.com\n" +
//                        " */\n" +
//                        "public class Test1 {\n" +
//                        "\n" +
//                        "    public static void main(String[] args) {\n" +
//                        "       System.out.println(1);System.out.println(2);System.out.println(3);System.out.println(4); " +
//                        "    }\n" +
//                        "}";
//                System.out.println(ShaunaCode.remoteExecute(source));
//            }).start();
//        }

        String source = "import java.util.Scanner;" +
                "public class Main{\n" +
                "    public static void main(String[] args) {\n" +
                "        Scanner s = new Scanner(System.in);\n" +
                "        //String s1 = s.nextLine();\n" +
                "        System.out.println(1234);\n" +
                "//s1 = s.nextLine();\n" +
        "        //System.out.println(s1);\n" +
                "    }\n" +
                "}";
        System.out.println(">>"+ShaunaCode.remoteExecute(source));
    }
}