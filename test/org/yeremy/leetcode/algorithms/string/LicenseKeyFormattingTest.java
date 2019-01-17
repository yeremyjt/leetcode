package org.yeremy.leetcode.algorithms.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class LicenseKeyFormattingTest
{
    @Test
    public void testLicenseKeyFormatting_1()
    {
        LicenseKeyFormatting lf = new LicenseKeyFormatting();
        String result = lf.licenseKeyFormatting("5F3Z-2e-9-w", 4);
        assertEquals("5F3Z-2E9W", result);
    }

    @Test
    public void testLicenseKeyFormatting_2()
    {
        LicenseKeyFormatting lf = new LicenseKeyFormatting();
        String result = lf.licenseKeyFormatting("2-5g-3-J", 2);
        assertEquals("2-5G-3J", result);
    }
}