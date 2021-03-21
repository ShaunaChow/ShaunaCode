package top.shauna.shaunacode.util.classmodify;

/**
 * @Author Shauna.Chow
 * @Date 2021/3/21 21:33
 * @E-Mail z1023778132@icloud.com
 */
public interface ClassModifier {
    byte[] modify(String oldStr, String newStr);
}
