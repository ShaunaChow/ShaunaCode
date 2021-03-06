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

        String source = "public class Main2{\n" +
                "    public static void main(String[] args) throws InterruptedException {\n" +
                "        new Thread(()->{\n" +
                "            System.out.println(2);\n" +
                "        }).start();\n" +
                "        System.out.println(1);\n" +
                "        Thread.sleep(10);\n" +
                "    }\n" +
                "}";
        System.out.println(">>"+ShaunaCode.remoteExecute(source));
    }
}

class Main{
    public static void main(String[] args) throws InterruptedException {
        InheritableThreadLocal<String> local = new InheritableThreadLocal<>();
        local.set("father");
        new Thread(()->{
            if (local.get()==null) {
                local.set("son1");
            }
            System.out.println(local.get());
        }).start();
//        new Thread(()->{
//            System.out.println(local.get());
//        }).start();
//        new Thread(()->{
//            System.out.println(local.get());
//        }).start();

        Thread.sleep(1000);
        System.out.println(local.get());
    }
}

class Main2{
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            System.out.println(2);
        }).start();
        System.out.println(1);
        Thread.sleep(10);
    }
}