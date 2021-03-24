package top.shauna.shaunacode.util.system;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author Shauna.Chow
 * @Date 2021/3/23 15:54
 * @E-Mail z1023778132@icloud.com
 */
public class ShaunaInputStream extends InputStream {
    private static final InheritableThreadLocal<InputStream> ins = new InheritableThreadLocal<>();
    @Override
    public int read() throws IOException {
        if (ins.get()==null) {
            ins.set(new ByteArrayInputStream(new byte[0]));
        }
        return ins.get().read();
    }

    public void setDatas(byte[] bts) throws IOException {
        InputStream inputStream = ins.get();
        if (inputStream==null){
            inputStream = new ByteArrayInputStream(bts);
            ins.set(inputStream);
        }else{
            inputStream.reset();
            byte[] tmp = new byte[inputStream.available()+bts.length];
            inputStream.read(tmp);
            System.arraycopy(bts,0,tmp,tmp.length-bts.length,bts.length);
            inputStream.close();
            inputStream = new ByteArrayInputStream(tmp);
            ins.set(inputStream);
        }
    }

    @Override
    public void close() {
        if (ins.get()!=null) {
            try {
                ins.get().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ins.remove();
        }
    }
}
