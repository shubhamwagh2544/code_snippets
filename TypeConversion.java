package code_snippets;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TypeConversion {
    public static void main(String[] args) {
        /*
                converting int[] to Integer[]
         */
        int[] array = {1, 2, 3, 4, 5};
        Integer[] integers = Arrays.stream(array).boxed().toArray(Integer[]::new);
        //or
        Integer[] integers1 = IntStream.of(array).boxed().toArray(Integer[]::new);
        //or
        Integer[] integers2 = new Integer[array.length];
        for (int i=0; i<array.length; i++) {
            integers2[i] = array[i];
        }
        //System.out.println(Arrays.toString(integers));  //[1, 2, 3, 4, 5]
        //System.out.println(Arrays.toString(integers1)); //[1, 2, 3, 4, 5]
        //System.out.println(Arrays.toString(integers2)); //[1, 2, 3, 4, 5]

        /*
                converting int to list
         */
        int[] array1 = {1, 2, 3, 4, 5};
        List<Integer> list = Arrays.stream(array1).boxed().collect(Collectors.toList());
        //or
        List<Integer> list1 = IntStream.of(array1).boxed().collect(Collectors.toList());

        /*
                converting list to array
         */
        Integer[] integers3 = list.toArray(new Integer[0]);

        /*
                Integer[] to int[]
         */
        int[] array2 = new int[integers.length];
        for (int i=0; i<array2.length; i++) {
            array2[i] = integers[i];
        }
        //System.out.println(Arrays.toString(array2));

        /*
                Integer to List
         */
        List<Integer> list2 = List.of(integers1);
        System.out.println(list2);
        //or
        List<Integer> list3 = Arrays.asList(integers1);
        System.out.println(list3);
        //or
        List<Integer> list4 = Arrays.stream(integers1).collect(Collectors.toList());
        System.out.println(list4);

    }
}
