package cheng.execute;

public class ByteUtils {
    /*
    把bytes数组按照从低位到高位的方式转为int
    如{1,1} = 1*2^8 + 1*2^0
     */
    public static int byte2Int(byte[] bytes, int start, int len) {
        int res = 0;
        int end = start + len;
        for (int i = start; i < end; i++) {
            int cur = ((int) bytes[i]) & 0xff;
            cur <<= (--len) * 8;
            res += cur;
        }
        return res;
    }

    public static byte[] int2Byte(int num, int len) {
        byte[] bytes = new byte[len];
        for (int i = 0; i < len; i++) {
            bytes[len - i - 1] = (byte) ((num) >> (8 * i) & 0xff);
        }
        return bytes;
    }

    public static String byte2String(byte[] bytes, int start, int len) {
        return new String(bytes, start, len);
    }

    public static byte[] string2Byte(String newStr) {
        return newStr.getBytes();
    }

    public static byte[] byteReplace(byte[] oldBytes, int offset, int len, byte[] replaceBytes) {
        byte[] newBytes = new byte[oldBytes.length + replaceBytes.length - len];
        System.arraycopy(oldBytes, 0, newBytes, 0, offset);
        System.arraycopy(replaceBytes, 0, newBytes, offset, replaceBytes.length);
        System.arraycopy(oldBytes, offset + len, newBytes, offset + replaceBytes.length,
                oldBytes.length - offset - len);
        return newBytes;
    }
}
