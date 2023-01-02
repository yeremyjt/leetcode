package org.yeremy.leetcode.algorithms;

import org.yeremy.leetcode.algorithms.PartitionLabels;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PartitionLabelsTest
{
    @Test
    public void PartitionLabelTest()
    {
        PartitionLabels partitionLabels = new PartitionLabels();
        List<Integer> partitions = partitionLabels.partitionLabels("ababcbacadefegdehijhklij");
        assertNotNull(partitions);
        assertEquals(3, partitions.size());
        assertEquals(9, partitions.get(0).intValue());
        assertEquals(7, partitions.get(1).intValue());
        assertEquals(8, partitions.get(2).intValue());
    }
}