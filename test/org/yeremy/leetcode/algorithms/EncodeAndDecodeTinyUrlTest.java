package org.yeremy.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class EncodeAndDecodeTinyUrlTest
{
    @Test
    public void testEncodeAndDecodeTinyURL() {
        EncodeAndDecodeTinyUrl encodeAndDecodeTinyUrl = new EncodeAndDecodeTinyUrl();
        String tinyUrl = encodeAndDecodeTinyUrl.encode("https://leetcode.com/decode-tinyurl");
        System.out.println(tinyUrl);
        assertNotNull(tinyUrl);

        assertEquals("https://leetcode.com/decode-tinyurl", encodeAndDecodeTinyUrl.decode(tinyUrl));
    }
}