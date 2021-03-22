package top.shauna.shaunacode.util.executer;

import top.shauna.shaunacode.util.classloader.ShaunaCodeClassLoader;
import top.shauna.shaunacode.util.system.ShaunaSystem;

import java.lang.reflect.Method;

/**
 * @Author Shauna.Chow
 * @Date 2021/3/22 9:53
 * @E-Mail z1023778132@icloud.com
 */
public class ShaunaCodeExecuter {

    public static String execute(byte[] classByte){
        ShaunaCodeClassLoader classLoader = new ShaunaCodeClassLoader();
        Class clazz = classLoader.loadBytes(classByte);
        try {
            Method main = clazz.getMethod("main", String[].class);
            main.invoke(null, new String[]{null});
        } catch (Exception e) {
            e.printStackTrace(ShaunaSystem.err);
        }
        String ret = ShaunaSystem.getBufferString();
        ShaunaSystem.clearBuffer();
        return ret;
    }
}
