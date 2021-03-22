package top.shauna.shaunacode.test;

import top.shauna.shaunacode.ShaunaCode;

/**
 * @Author Shauna.Chow
 * @Date 2021/3/21 21:18
 * @E-Mail z1023778132@icloud.com
 */
public class Test1 {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                String source = "import top.shauna.shaunacode.ShaunaCode;\n" +
                        "\n" +
                        "/**\n" +
                        " * @Author Shauna.Chow\n" +
                        " * @Date 2021/3/21 21:18\n" +
                        " * @E-Mail z1023778132@icloud.com\n" +
                        " */\n" +
                        "public class Test1 {\n" +
                        "\n" +
                        "    public static void main(String[] args) {\n" +
                        "       System.out.println(1);System.out.println(2);System.out.println(3);System.out.println(4); " +
                        "    }\n" +
                        "}";
                System.out.println(ShaunaCode.remoteExecute(source));
            }).start();
        }
    }
}

