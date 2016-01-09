package name.davidwbrown.test

import junit.framework.TestCase
import name.davidwbrown.ByteArrayUtil;


/**
 * Created by david on 1/9/16.
 */
class ByteArrayUtilTest extends TestCase {
    void testConcat() {
        ByteArrayUtil ba1 = new ByteArrayUtil("abcd");
        ByteArrayUtil ba2 = new ByteArrayUtil("efgh");
        assertEquals("abcdefgh", ba1.concat(ba2).toString());
    }

    void testRemoveFirst() {
        ByteArrayUtil ba = new ByteArrayUtil("abcdefgh");
        assertEquals("bcdefgh", ba.removeFirst().toString());
    }

    void testSubstring() {
        ByteArrayUtil ba = new ByteArrayUtil("abcdefgh");
        assertEquals("bcdefgh", ba.removeFirst().toString());
    }
}
