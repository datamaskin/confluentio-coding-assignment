package name.davidwbrown.test

import junit.framework.TestCase
import name.davidwbrown.ProcessZero

/**
 * Created by david on 1/9/16.
 */
class EncoderTest extends TestCase {

    void testRemoveZeros() {
        byte[] bytes = 0x00;
        ProcessZero.Encoder encoder = new ProcessZero.Encoder();
        assertEquals(0, encoder.removeZeros(bytes).length);
    }
}
