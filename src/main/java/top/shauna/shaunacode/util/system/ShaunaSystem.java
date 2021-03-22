package top.shauna.shaunacode.util.system;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * @Author Shauna.Chow
 * @Date 2021/3/21 22:23
 * @E-Mail z1023778132@icloud.com
 */
public class ShaunaSystem{
    public static final InputStream in = System.in;
    private static ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    public static final PrintStream out = new PrintStream(buffer);
    public static final PrintStream err = out;

    public static String getBufferString(){
        return buffer.toString();
    }

    public static void clearBuffer(){
        buffer.reset();
    }

    /** 待添加所有的System的方法 **/
}
