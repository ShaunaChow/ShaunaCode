package top.shauna.shaunacode;

import top.shauna.shaunacode.util.classmodify.ShaunaClassModifier;
import top.shauna.shaunacode.util.compile.ShaunaCompileUtil;
import top.shauna.shaunacode.util.executer.ShaunaCodeExecuter;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaFileObject;

/**
 * @Author Shauna.Chow
 * @Date 2021/3/22 19:51
 * @E-Mail z1023778132@icloud.com
 */
public class ShaunaCode {

    public static String remoteExecute(String source){
        DiagnosticCollector<JavaFileObject> compileCollector = new DiagnosticCollector<>();
        byte[] compile = ShaunaCompileUtil.compile(source, compileCollector);
        if (compile==null){
            StringBuilder res = new StringBuilder();
            res.append("Compiler error: ");
            for (Diagnostic<? extends JavaFileObject> diagnostic : compileCollector.getDiagnostics()) {
                res
                        .append(System.lineSeparator())
                        .append(diagnostic.toString())
                        .append(System.lineSeparator());
            }
            return res.toString();
        }
        ShaunaClassModifier modifier = new ShaunaClassModifier(compile);
        byte[] modify = modifier.modify("java/lang/System", "top/shauna/shaunacode/util/system/ShaunaSystem");
        return ShaunaCodeExecuter.execute(modify);
    }
}
