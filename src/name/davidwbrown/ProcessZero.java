package name.davidwbrown;

public class ProcessZero {


    public static String byteArry2Hex(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for(byte b : bytes){
            sb.append(String.format("%02x", b&0xff));
        }
        return sb.toString();
    }

    public static class Encoder {

        static byte[] removeZeros(byte[] bytes) {

            ByteArrayUtil ba = new ByteArrayUtil(bytes);

            for (int i = 0; i < ba.length(); i++) {
                if (ba.byteAt(i) == 0)
                    ba = ba.removeNth(i);
            }

            ByteArrayUtil ba2 = new ByteArrayUtil(bytes, ba.getFile());

            return ba.getBytes();
        }

        static byte[] revert(byte[] bytes) {

            ByteArrayUtil ba = new ByteArrayUtil(bytes);

            ByteArrayUtil ba2 = new ByteArrayUtil(bytes, ba.getFile());

            if (ba.equals(removeZeros(ba2.getBytes())))
                return ba2.getBytes();
            else
                return bytes;
        }
    }

    public static void main(String[] args) {

        String op = null;

        if (args.length > 0)
            op = args[0];

        byte[] bytes = new byte[] {0x20, 0x3a, 0x69, 0x10, 0x00, 0x08};

        if (op.equalsIgnoreCase("remove")) {


            ByteArrayUtil ba = new ByteArrayUtil(bytes);

            System.out.println(ba.toString());

            byte[] bytes1 = Encoder.removeZeros(bytes);

            System.out.println(byteArry2Hex(bytes1));
        } else if (op.equalsIgnoreCase("revert")) {

            byte[] bytes1 = new byte[] {0x20, 0x3a, 0x69, 0x10, 0x08};

            bytes = Encoder.revert(bytes1);

            System.out.println(byteArry2Hex(bytes));
        }
    }
}
