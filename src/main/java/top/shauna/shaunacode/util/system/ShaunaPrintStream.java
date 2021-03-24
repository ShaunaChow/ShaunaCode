package top.shauna.shaunacode.util.system;

import java.io.*;
import java.util.Locale;

/**
 * @Author Shauna.Chow
 * @Date 2021/3/22 21:29
 * @E-Mail z1023778132@icloud.com
 */
public class ShaunaPrintStream extends PrintStream {
    private static final InheritableThreadLocal<ByteArrayOutputStream> out = new InheritableThreadLocal<>();
    private static final InheritableThreadLocal<Boolean> trouble = new InheritableThreadLocal<>();

    public ShaunaPrintStream() {
        super(new ByteArrayOutputStream());
    }

    public void setData(){
        ensureOpen();
    }

    @Override
    public String toString() {
        ensureOpen();
        return out.get().toString();
    }

    private void ensureOpen() {
        if (out.get() == null)
            out.set(new ByteArrayOutputStream());
    }

    public void flush() {
        try {
            ensureOpen();
            out.get().flush();
        }
        catch (IOException x) {
            trouble.set(true);
        }
    }

    public void close() {
        try {
            if (out.get()!=null) {
                out.get().close();
            }
        }catch (IOException x) {
            trouble.set(true);
        }
        out.remove();
    }

    public boolean checkError() {
        if (out.get() != null)
            flush();
        return trouble.get()!=null?trouble.get():false;
    }

    protected void setError() {
        trouble.set(true);
    }

    protected void clearError() {
        trouble.remove();
    }

    public void write(int b) {
        try {
            ensureOpen();
            out.get().write(b);
            if ((b == '\n')) out.get().flush();
        }catch (InterruptedIOException x) {
            Thread.currentThread().interrupt();
        }catch (IOException x) {
            trouble.set(true);
        }
    }

    public void write(byte buf[], int off, int len) {
        ensureOpen();
        out.get().write(buf, off, len);
    }

    private void write(char buf[]) {
        try {
            ensureOpen();
            out.get().write(new String(buf).getBytes());
        }
        catch (InterruptedIOException x) {
            Thread.currentThread().interrupt();
        }
        catch (IOException x) {
            trouble.set(true);
        }
    }

    private void write(String s) {
        try {
            ensureOpen();
            out.get().write(s.getBytes());
        }
        catch (InterruptedIOException x) {
            Thread.currentThread().interrupt();
        }
        catch (IOException x) {
            trouble.set(true);
        }
    }

    private void newLine() {
        try {
            ensureOpen();
            out.get().write(System.lineSeparator().getBytes());
        }
        catch (InterruptedIOException x) {
            Thread.currentThread().interrupt();
        }
        catch (IOException x) {
            trouble.set(true);
        }
    }

    public void print(boolean b) {
        write(b ? "true" : "false");
    }

    public void print(char c) {
        write(String.valueOf(c));
    }

    public void print(int i) {
        write(String.valueOf(i));
    }

    public void print(long l) {
        write(String.valueOf(l));
    }

    public void print(float f) {
        write(String.valueOf(f));
    }

    public void print(double d) {
        write(String.valueOf(d));
    }

    public void print(char s[]) {
        write(s);
    }

    public void print(String s) {
        if (s == null) {
            s = "null";
        }
        write(s);
    }

    public void print(Object obj) {
        write(String.valueOf(obj));
    }

    public void println() {
        newLine();
    }

    public void println(boolean x) {
        print(x);
        newLine();
    }

    public void println(char x) {
        print(x);
        newLine();
    }

    public void println(int x) {
        print(x);
        newLine();
    }

    public void println(long x) {
        print(x);
        newLine();
    }

    public void println(float x) {
        print(x);
        newLine();
    }

    public void println(double x) {
        print(x);
        newLine();
    }

    public void println(char x[]) {
        print(x);
        newLine();
    }

    public void println(String x) {
        print(x);
        newLine();
    }

    public void println(Object x) {
        String s = String.valueOf(x);
        print(s);
        newLine();
    }

    public PrintStream printf(String format, Object ... args) {
        return format(format, args);
    }

    public PrintStream printf(Locale l, String format, Object ... args) {
        return format(l, format, args);
    }

    public PrintStream append(CharSequence csq) {
        if (csq == null)
            print("null");
        else
            print(csq.toString());
        return this;
    }

    public PrintStream append(CharSequence csq, int start, int end) {
        CharSequence cs = (csq == null ? "null" : csq);
        write(cs.subSequence(start, end).toString());
        return this;
    }

    public PrintStream append(char c) {
        print(c);
        return this;
    }
}
