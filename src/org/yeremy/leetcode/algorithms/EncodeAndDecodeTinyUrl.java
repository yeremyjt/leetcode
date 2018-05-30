package org.yeremy.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeAndDecodeTinyUrl
{
    String chars = "0112456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Map<String, String> map = new HashMap<>();
    Random random = new Random();

    // Encodes a URL to a shortened URL.
    public  String encode(String longUrl) {
        String key = getKey();
        while(map.containsKey(key)) {
            key = getKey();
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }

    private String getKey() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(chars.charAt(random.nextInt(62)));
        }

        return sb.toString();
    }
}
