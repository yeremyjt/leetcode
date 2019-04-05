package org.yeremy.leetcode.algorithms.string;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailsSet = new HashSet<>();

        for (String email : emails) {
            emailsSet.add(cleanEmail(email));
        }

        return emailsSet.size();
    }

    private String cleanEmail(String email) {
        String[] elements = email.split("@");
        String localName = elements[0];
        String domainName = elements[1];
        localName = localName.replace(".", "");
        if (localName.contains("+"))
            localName = localName.substring(0, localName.indexOf("+"));

        return localName + "@" + domainName;
    }
}
