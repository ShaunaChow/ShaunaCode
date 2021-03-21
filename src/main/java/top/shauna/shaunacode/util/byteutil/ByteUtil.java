package top.shauna.shaunacode.util.byteutil;

/**
 * @Author Shauna.Chow
 * @Date 2021/3/21 21:38
 * @E-Mail z1023778132@icloud.com
 */
public class ByteUtil {
    public static int byte2int(byte[] b, int start, int len){
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int cur = ((int)b[start+i]) & 0xff;
            sum = sum<<8;
            sum += cur;
        }
        return sum;
    }

    public static byte[] int2byte(int value, int len){
        byte[] res = new byte[len];
        for (int i = 0; i < len; i++) {
            res[len-i-1] = (byte)(value&0xff);
            value = value>>8;
        }
        return res;
    }

    public static String byte2string(byte[] b, int start, int len){
        return new String(b,start,len);
    }

    public static byte[] string2byte(String str){
        return str.getBytes();
    }

    public static byte[] byteReplace(byte[] original, int start, int len, byte[] replace){
        byte[] res = new byte[original.length + replace.length - len];
        System.arraycopy(original,0,res,0,start);
        System.arraycopy(replace,0,res,start,replace.length);
        System.arraycopy(original,start+len,res,start+replace.length,original.length-start-len);
        return res;
    }

    public static void main(String[] args) {
        byte[] tmp = {-22,55,1,-33};
        byte bb = -128;
        System.out.println(bb+"  "+(int)bb);
        int res = byte2int(tmp, 0, 4);
        System.out.println(res);
        byte[] bytes = int2byte(-365493793, 4);
        for (byte b:bytes) System.out.println(b);

        byte[] bytes1 = byteReplace(tmp, 1, 2, new byte[]{66, 34, 66, 66});
        for (byte b:bytes1) System.out.print(b+" ");
    }
}
