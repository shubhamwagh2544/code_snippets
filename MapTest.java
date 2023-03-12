package code_snippets;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>();     // keys sorted
        map.put(3, "Shubham");
        map.put(2, "Ramesh");
        map.put(1, "Wagh");
        map.entrySet().forEach(
                entry -> {
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }
        );
        //or
        map.forEach((key, value) -> System.out.println(key +" : " + value));

        // remove all keys
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        System.out.println(map.isEmpty());      // true

        //remove all keys
        for (Integer integer : map.keySet()) {
            map.remove(integer);
        }
        System.out.println(map.isEmpty());      // true

        //or
        map.keySet().removeIf(integer -> integer != 0);
        System.out.println(map.isEmpty());      // true
        //or
        map.keySet().removeIf(integer -> !(integer == null));
        System.out.println(map.isEmpty());      // true
        //or
        map.keySet().removeIf(Objects::nonNull);
        System.out.println(map.isEmpty());      // true

        // removing key returns value
        map.put(1, "SR");
        String removed = map.remove(1);
        System.out.println(removed);
        System.out.println(map.isEmpty());      //true

        // removing if map is empty
        map.remove(5);              // no issues

        // parsing into boolean
        boolean b = Boolean.parseBoolean(map.remove(1));
        System.out.println(b);      // false

        // clearing map
        map.put(1, "S");
        map.put(2, "R");
        map.put(3, "W");
        System.out.println(map.size());     // 3
        map.clear();
        System.out.println(map);        // {}   or   map.isEmpty = true

        // put vs replace
        // put
        map.put(1, "SR");
        String previousValue = map.put(1, "RW");
        System.out.println(previousValue);      // SR
        //replace
        String replacedValue = map.replace(1, "SR");
        System.out.println(replacedValue);      // RW

        map.clear();
        /*
            There is absolutely no difference in put and replace
            when there is a current mapping for the wanted key.
            i.e.  if there is already a mapping for the given key
            both put and replace will update the map in the same way
         */
        String replace = map.replace(2, "RW");  // trying to replace entry which is not in map
        System.out.println(replace);            // null (null is a literal in java)
        System.out.println(map);        // EMPTY MAP

        String putten = map.put(3, "WS");   // trying to put entry which is not in map
        System.out.println(putten);         // null
        System.out.println(map);            // { 3 = WS }

        // values() method :> returns Collection view of all values in map
        map.put(1, "SR");
        map.put(2, "RW");
        map.put(3, "WS");
        Collection<String> values = map.values();
        values.forEach(System.out::println);

        // getOrDefault() method
        String s1 = map.get(5);     // null if no value is mapped to key
        System.out.println(s1);

        String s2 = map.getOrDefault(5, "DEFAULT_VALUE");
        System.out.println(s2);     // DEFAULT_VALUE if no value is mapped to key

        // compute() :> for given key, it computes new value with BiFunction(K, V)
        // it will raise exception if key is absent :> NullPointer Exception
        String newString = map.compute(1, (key, value) -> {
            if (value.length() >= 2) {
                value = value.concat("new_string");
            }
            return value;
        });
        System.out.println(newString);
        //or
        String ifPresent = map.computeIfPresent(1, (key, value) -> value.concat("SRW"));// no exception if key is absent
        System.out.println(ifPresent);  // null if key is absent

        // merge :> for given key, merges result of given value and computed value from remapping BiFunction.
        String merged = map.merge(2, "Old", (val1, val2) -> val1.concat("NewVal1") + val2.concat("NewVal2"));
        System.out.println(merged);     //RWNewVal1OldNewVal2

    }
}
