package com.wony.util;

import java.util.Collection;
import java.util.stream.Stream;

public class WonyStreamUtils {
    public static <E> Stream<E> of(Collection<E> c) {
        if (c == null) {
            return Stream.empty();
        }

        return c.stream();
    }
}
