package org.javaspring.task1.StringJoinerV8.Examples;

import java.util.*;
import java.util.stream.*;

public class StringJoinerV8 {
    public void example() {
        StringJoiner sj = new StringJoiner(":", "[", "]");
        sj.add("George").add("Sally").add("Fred");
        System.out.println(sj.toString());

        final List<String> strings = Arrays.asList("Foo", "Bar", "Baz");
        final String collectJoin = strings.stream().collect(Collectors.joining(", "));
        System.out.println(collectJoin);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        String commaSeparatedNumbers = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        System.out.println(commaSeparatedNumbers);
    }
}
