package top.shauna.shaunacode.util.compile;

import javax.tools.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author Shauna.Chow
 * @Date 2021/3/6 17:30
 * @E-Mail z1023778132@icloud.com
 */
public class ShaunaCompileUtil {
    private static Pattern CLASS_PATTERN = Pattern.compile("class\\s+([$_a-zA-Z][$_a-zA-Z0-9]*)\\s*");

    public static byte[] compile(String source, DiagnosticCollector<JavaFileObject> compileCollector){
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        ShaunaJavaFileManager javaFileManager =
                new ShaunaJavaFileManager(compiler.getStandardFileManager(compileCollector, null, null));

        // 从源码字符串中匹配类名
        Matcher matcher = CLASS_PATTERN.matcher(source);
        String className;
        if (matcher.find()) {
            className = matcher.group(1);
        } else {
            throw new IllegalArgumentException("No valid class");
        }

        // 把源码字符串构造成JavaFileObject，供编译使用
        JavaFileObject sourceJavaFileObject = new ShaunaJavaFileObject(className, source);

        Boolean result = compiler.getTask(null, javaFileManager, compileCollector,
                null, null, Arrays.asList(sourceJavaFileObject)).call();

        JavaFileObject bytesJavaFileObject = javaFileManager.getFileObjectMap().get(className);
        if (result && bytesJavaFileObject != null) {
            return ((ShaunaJavaFileObject) bytesJavaFileObject).getCompiledBytes();
        }
        return null;
    }

    public static void main(String[] args) {
        String source = "public class Test1 {\n" +
                "    \n" +
                "    public static void main(String[] args){\n" +
                "        System.out.println(\"2321\");\n" +
                "    }\n" +
                "}";
        byte[] compile = compile(source, new DiagnosticCollector<>());
        for (byte b:compile) System.out.println(b);
    }
}
