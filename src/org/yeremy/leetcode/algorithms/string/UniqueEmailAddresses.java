package org.yeremy.leetcode.algorithms.string;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailsSet = new HashSet<>();

        for (int i = 0; i < emails.length; i++) {
            emailsSet.add(cleanEmail(emails[i]));
        }

        return emailsSet.size();
    }

    private String cleanEmail(String email) {
        String[] elements = email.split("@");
        elements[0] = elements[0].replace(".", "");
        if (elements[0].indexOf("+") != -1)
            elements[0] = elements[0].substring(0, elements[0].indexOf("+"));

        return elements[0] + "@" + elements[1];
    }
}
