package top.shauna.shaunacode.util.compile;

import javax.tools.SimpleJavaFileObject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

/**
 * @Author Shauna.Chow
 * @Date 2021/3/21 21:07
 * @E-Mail z1023778132@icloud.com
 *
 * 用来封装表示源码与字节码的对象
 */
public class ShaunaJavaFileObject extends SimpleJavaFileObject {
    private String source;
    private ByteArrayOutputStream byteArrayOutputStream;

    public ShaunaJavaFileObject(String name, Kind kind){
        super(URI.create("String:///"+name + Kind.SOURCE.extension),kind);
        this.source = null;
    }

    public ShaunaJavaFileObject(String name, String source){
        super(URI.create("String:///"+name + Kind.SOURCE.extension),Kind.SOURCE);
        this.source = source;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        return source;
    }

    @Override
    public OutputStream openOutputStream() throws IOException {
        byteArrayOutputStream = new ByteArrayOutputStream();
        return byteArrayOutputStream;
    }

    public byte[] getCompiledBytes() {
        return byteArrayOutputStream.toByteArray();
    }
}
