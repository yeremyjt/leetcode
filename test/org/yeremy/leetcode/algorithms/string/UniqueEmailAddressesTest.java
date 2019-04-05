package org.yeremy.leetcode.algorithms.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniqueEmailAddressesTest {
    @Test
    public void testUniqueEmailAddresses() {
        String[] input = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        UniqueEmailAddresses uniqueEmailAddresses = new UniqueEmailAddresses();
        int result = uniqueEmailAddresses.numUniqueEmails(input);
        assertEquals(2, result);
    }
}