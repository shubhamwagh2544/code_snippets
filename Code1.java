package code_snippets;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Code1 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1000);
        map.put("B", 2000);
        map.put("C", 3000);
        map.put("D", 4000);
        map.put("E", 5000);

        System.out.println("----------------map : foreach-----------------");

        map.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });

        System.out.println("------------map : filter---------------");

        String key = map.entrySet().stream().filter(entry -> entry.getValue() == 4000).findFirst().get().getKey();
        System.out.println(key);

        System.out.println("---------------map : sorted-----------------");

        String key1 = map.entrySet().stream().sorted(Comparator.comparing(entry -> -entry.getValue())).collect(Collectors.toList())
                .get(0).getKey();
        System.out.println(key1);

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("AB");
        list.add("ABC");
        list.add("ABCD");
        list.add("ABCDE");

        System.out.println("---------------list : sorted------------------");

        String s1 = list.stream().sorted(Comparator.comparing(s -> -s.length())).collect(Collectors.toList()).get(0);
        System.out.println(s1);

        System.out.println("----------------list : filter--------------");

        String ab = list.stream().filter(s -> s.startsWith("AB")).findFirst().get();
        System.out.println(ab);

        System.out.println("---------------list : map----------------------");

        list.stream().map(s -> s+"adding").collect(Collectors.toList()).forEach(
                s -> System.out.println(s)
        );

        System.out.println("---------------Stream : IntStream-------------");
        IntStream intStream = IntStream.of(10, 20, 30, 40, 50);
        long count = intStream.count();
        System.out.println(count);
        System.out.println("-------------filter-------------");
        IntStream intStream1 = IntStream.range(90, 100);
        boolean isPresent = intStream1.filter(value -> value == 95).findAny().isPresent();
        System.out.println(isPresent);
        System.out.println("-----------------generate and limit----------------");
        IntStream intStream2 = IntStream.generate(() -> (int) (10*Math.random()));
        intStream2.limit(5).forEach(value -> System.out.println(value));
    }
}
