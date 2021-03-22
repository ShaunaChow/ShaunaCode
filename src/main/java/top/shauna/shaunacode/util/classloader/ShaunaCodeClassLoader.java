package top.shauna.shaunacode.util.classloader;

/**
 * @Author Shauna.Chow
 * @Date 2021/3/22 19:35
 * @E-Mail z1023778132@icloud.com
 */
public class ShaunaCodeClassLoader extends ClassLoader {

    public ShaunaCodeClassLoader(){
        super(ShaunaCodeClassLoader.class.getClassLoader());
    }

    public Class loadBytes(byte[] classBytes){
        return defineClass(null,classBytes,0,classBytes.length);
    }
}
