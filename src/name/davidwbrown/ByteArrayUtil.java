package name.davidwbrown;

/**
 * Created by david on 1/8/16.
 */
import java.io.*;

public final class ByteArrayUtil {

    private File f = null;

    public String getFileName() {
        return fileName;
    }

    private String fileName = "data.bin";

    private byte[] data;

    public ByteArrayUtil(byte b) {
        this.data = new byte[] {b};
    }

    public ByteArrayUtil(byte[] data) {
        this.data = data.clone();
    }

    public ByteArrayUtil(byte[] data, File f) {

        this.f = f;

        this.f = new File(this.fileName);

        try {
            if (this.f.createNewFile()) {
                ByteFile.writeBytesToFile(f, data);
                this.data = data.clone();
            }
            else {
                data = ByteFile.readBytesFromFile(this.f);
                this.data = data.clone();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ByteArrayUtil(String text) {
        byte[] data;
        try {
            data = text.getBytes("UTF-8");
        } catch(UnsupportedEncodingException e) {
            data = text.getBytes();
        }
        this.data = data;
    }

    public ByteArrayUtil(byte[] data, int beginIndex, int endIndex) {
        this.data = new byte[endIndex - beginIndex];
        System.arraycopy(data, beginIndex, this.data, 0, this.data.length);
    }

    public final byte[] getBytes() {
        return data;
    }

    public ByteArrayUtil concat(byte[] b) {
        byte[] out = new byte[data.length + b.length];
        System.arraycopy(data, 0, out, 0, data.length);
        System.arraycopy(b, 0, out, data.length, b.length);
        return new ByteArrayUtil(out);
    }

    public ByteArrayUtil concat(ByteArrayUtil b) {
        return concat(b.data);
    }

    public ByteArrayUtil removeFirst() {
        return substring(1);
    }

    public ByteArrayUtil removeNth(int n) {
        ByteArrayUtil byteArray = null;
        if (n == 1)
            removeFirst();
        else {
            byteArray = substring(0, n);
            byteArray = byteArray.concat(substring(n+1));
        }

        return byteArray;
    }

    @Override
    public String toString() {
        try {
            return new String(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return new String(data);
        }
    }

    public int length() {
        return data.length;
    }

    public byte byteAt(int i) {
        return data[i];
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof byte[]) {
            byte[] x = (byte[])obj;
            if(x.length != data.length)
                return false;
            for(int i = 0; i < x.length; i++) {
                if(x[i] != data[i])
                    return false;
            }
            return true;
        }
        if(obj instanceof ByteArrayUtil)
            return equals(((ByteArrayUtil)obj).data);
        if(obj instanceof String)
            return toString().equals(obj);
        return false;
    }

    public ByteArrayUtil substring(int beginIndex) {
        return substring(beginIndex, data.length);
    }

    public ByteArrayUtil substring(int beginIndex, int endIndex) {
        return new ByteArrayUtil(data, beginIndex, endIndex);
    }

    public File getFile() {
        if (this.f != null)
            return this.f;
        else
            this.f = new File(getFileName());

        return this.f;
    }
}

