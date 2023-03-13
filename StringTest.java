package code_snippets;

import java.util.Locale;

public class StringTest {
    public static void main(String[] args) {
        String s1 = "shubham";
        String s2 = "shubham";

        System.out.println(s1 == s2);           // true : refer to same address
        System.out.println(s1.equals(s2));      // true : content is same + both are of type String
        System.out.println(s1.contentEquals(s2));   // true : content is same

        String s3 = new String("shubham");      // new object is created

        System.out.println(s1 == s3);           // false : object refers to new location
        System.out.println(s1.equals(s3));          // true : content comparison + if an object of string +
        System.out.println(s1.contentEquals(s3));   // true : content is equal

        StringBuilder builder = new StringBuilder("shubham");
        StringBuffer buffer = new StringBuffer("shubham");

        System.out.println(s1.contentEquals(builder));   // true : only content matters
        System.out.println(s1.contentEquals(builder));  // true : only content matters

        System.out.println(s1.equals(builder));     // false always : since builder is not of type string
        System.out.println(s1.equals(buffer));      // false always : since builder is not of type string

        /*
            String Pool : Java heap memory storage where string literals are stored
            String Pool substitute names :> String Constant Pool or String Intern Pool

            Ways to create string in SCP
            1. literal
               -> literals are stored in SCP. if same value literal is created, it refers to previous one in SCP
            2. intern() method
               -> When we use the String.intern() method, JVM puts the string literal in the String Pool
                  (if not already present) and its reference is stored in the variable
               -> if the String Constant Pool already contains a string equal to the String object to be created
                  its reference is returned

            using new operator, we force String class to create a new String object in heap space.
            using intern() method,we ask String to refer to another String object from the string pool having the same value
         */
        String s4 = new String("wagh").intern();
        String s5 = new String("wagh");
        String s6 = "wagh";
        System.out.println(s4 == s5);       // false : as new is called for s5 hence new memory in heap
        System.out.println(s4.equals(s5));  // true : as content is equal + both are Strings
        System.out.println(s5 == s6);       // false : since no intern() called -> no string pooling
        System.out.println(s4 == s6);       // true : string pool => if object already exists, literal refers to its location

        // order does not matter
        String s7 = "ramesh";
        String s8 = new String("ramesh");
        String s9 = new String("ramesh").intern();
        System.out.println(s7 == s8);       // false : s8 will have memory in heap (new)
        System.out.println(s7 == s9);       // true : since intern() called "ramesh" stored in string pool
        System.out.println(s7.equals(s8));  // true : as content is equal + both are Strings
        System.out.println(s7.equals(s9));  // true : as content is equal + both are Strings
        System.out.println(s7.contentEquals(s9));   // true as content is equal

        s1 = s2 = s3 = s4 = s5 = s6 = s7 = s8 = s9 = null;

        s1 = "shubham";
        String upperCase = s1.toUpperCase(Locale.ROOT);
        System.out.println(upperCase);

        s2 = "shubham";
        System.out.println(s2.compareTo("wagh"));           // s t u v w    (s < w)
        System.out.println(("wagh").compareTo(s2));         // s t u v w    (w > s)

        s1 = "shubh";
        s2 = "SHUBH";
        System.out.println(s1.compareTo(s2));               // s:115  S:83  => 32
        System.out.println(s1.compareToIgnoreCase(s2));     // 0 : equal ( positive if former > latter)
                                                            // negative is former < latter
    }
}
