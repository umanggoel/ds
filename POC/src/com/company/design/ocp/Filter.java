package com.company.design.ocp;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public interface Filter<T> {

    public default Object filter(Function fn, List<T> list) {
        System.out.println("filtering has started");
        try {
            return fn.apply(list);
        } finally {
            System.out.println("filtering has ended");
        }
    }

    public Stream<T> filter(List<T> products, Specification<T> specification);
}
