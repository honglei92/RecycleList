package com.example.a83661.recyclelist;

import java.util.HashMap;
import java.util.Map;

public class JsonTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("path", "XXXXX");
        Map<String, Map> request = new HashMap<>();
        request.put("data", map);
    }
}
