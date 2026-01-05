package org.yeremy.leetcode.algorithms.api.doordash;

public class CustomerProfile {
    private boolean isDashPassMember;

    public CustomerProfile(boolean isDashPassMember) {
        this.isDashPassMember = isDashPassMember;
    }

    public boolean isDashPassMember() {
        return isDashPassMember;
    }

    public void setDashPassMember(boolean dashPassMember) {
        isDashPassMember = dashPassMember;
    }
}
