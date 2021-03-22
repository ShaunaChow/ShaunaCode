package top.shauna.shaunacode.util.system;

import sun.reflect.CallerSensitive;
import java.io.*;
import java.nio.channels.Channel;
import java.util.Properties;

/**
 * @Author Shauna.Chow
 * @Date 2021/3/21 22:23
 * @E-Mail z1023778132@icloud.com
 */
public class ShaunaSystem{
    public static final InputStream in = System.in;
    public static final PrintStream out = new ShaunaPrintStream();
    public static final PrintStream err = out;

    public static String getBufferString(){
        return out.toString();
    }

    public static void clearBuffer(){
        out.close();
    }

    /** 添加所有的System的方法 **/
    public static void setIn(InputStream in) {
        System.setIn(in);
    }

    public static void setOut(PrintStream out) {
        System.setOut(out);
    }

    public static void setErr(PrintStream err) {
        System.setErr(err);
    }


    public static Console console() {
        return System.console();
    }

    public static Channel inheritedChannel() throws IOException {
        return System.inheritedChannel();
    }

    public static void setSecurityManager(final SecurityManager s) {
        System.setSecurityManager(s);
    }

    public static SecurityManager getSecurityManager() {
        return System.getSecurityManager();
    }

    public static Properties getProperties() {
        return System.getProperties();
    }

    public static String lineSeparator() {
        return System.lineSeparator();
    }

    public static void setProperties(Properties props) {
        System.setProperties(props);
    }

    public static String getProperty(String key) {
        return System.getProperty(key);
    }

    public static String getProperty(String key, String def) {
        return System.getProperty(key,def);
    }

    public static String setProperty(String key, String value) {
        return System.setProperty(key,value);
    }

    public static String clearProperty(String key) {
        return System.clearProperty(key);
    }

    public static String getenv(String name) {
        return System.getenv(name);
    }

    public static java.util.Map<String,String> getenv() {
        return System.getenv();
    }

    public static void exit(int status) {
        System.exit(status);
    }

    public static void gc() {
        System.gc();
    }

    public static void runFinalization() {
        System.runFinalization();
    }

    @Deprecated
    public static void runFinalizersOnExit(boolean value) {
        System.runFinalizersOnExit(value);
    }

    @CallerSensitive
    public static void load(String filename) {
        System.load(filename);
    }

    @CallerSensitive
    public static void loadLibrary(String libname) {
        System.loadLibrary(libname);
    }
}
