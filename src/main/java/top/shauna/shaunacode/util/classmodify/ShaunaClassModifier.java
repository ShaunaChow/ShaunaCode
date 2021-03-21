package top.shauna.shaunacode.util.classmodify;

import top.shauna.shaunacode.util.byteutil.ByteUtil;

/**
 * @Author Shauna.Chow
 * @Date 2021/3/21 21:33
 * @E-Mail z1023778132@icloud.com
 */
public class ShaunaClassModifier implements ClassModifier {
    private byte[] classByte;
    private static final int CONSTANT_POOL_COUNT_INDEX = 8;
    private static final int CONSTANT_Utf8_info = 1;
    private static final int[] CONSTANT_ITEM_LENGTH = {-1,-1,-1,5,5,9,9,3,3,5,5,5,5};

    private static final int u1 = 1;
    private static final int u2 = 2;

    public ShaunaClassModifier(byte[] classByte){
        this.classByte = classByte;
    }

    @Override
    public byte[] modify(String oldStr, String newStr) {
        int constanLen = ByteUtil.byte2int(classByte,CONSTANT_POOL_COUNT_INDEX,u2);
        int offset = CONSTANT_POOL_COUNT_INDEX + u2;
        for (int i = 0; i < constanLen; i++) {
            int tag = ByteUtil.byte2int(classByte, offset, u1);
            if (tag==CONSTANT_Utf8_info){
                int len = ByteUtil.byte2int(classByte,offset+u1,u2);
                offset += (u1+u2);
                String str = ByteUtil.byte2string(classByte,offset,len);
                if (str.equals(oldStr)){
                    byte[] newStrLen = ByteUtil.int2byte(newStr.length(),u2);
                    byte[] newStrBytes = ByteUtil.string2byte(newStr);
                    classByte = ByteUtil.byteReplace(classByte, offset - u2, u2, newStrLen);
                    classByte = ByteUtil.byteReplace(classByte, offset, len, newStrBytes);
                    return classByte;
                }
            }else{
                offset += CONSTANT_ITEM_LENGTH[tag];
            }
        }
        return classByte;
    }
}
