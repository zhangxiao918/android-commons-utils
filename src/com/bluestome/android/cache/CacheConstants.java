
package com.bluestome.android.cache;

public class CacheConstants {

    public static final byte[] ENCRYPT_START = {
            (byte) 0xAA, (byte) 0xAB, (byte) 0xAC, (byte) 0xAD, (byte) 0xAE
    };

    public static final byte[] ENCRYPT_END = {
            (byte) 0xBA, (byte) 0xBB, (byte) 0xBC, (byte) 0xBD, (byte) 0xBE
    };
}
