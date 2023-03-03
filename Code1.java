package code_snippets;

import java.util.*;
import java.util.stream.Collectors;

public class Code1 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1000);
        map.put("B", 2000);
        map.put("C", 3000);
        map.put("D", 4000);
        map.put("E", 5000);

        map.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });

        String key = map.entrySet().stream().sorted(Comparator.comparing(entry -> -entry.getValue())).collect(Collectors.toList())
                .get(0).getKey();
        System.out.println(key);

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("AB");
        list.add("ABC");
        list.add("ABCD");
        list.add("ABCDE");

        String s1 = list.stream().sorted(Comparator.comparing(s -> -s.length())).collect(Collectors.toList()).get(0);
        System.out.println(s1);

        String ab = list.stream().filter(s -> s.startsWith("AB")).findFirst().get();
        System.out.println(ab);
    }
}
