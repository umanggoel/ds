package com.company.design.ocp;

import java.util.List;
import java.util.stream.Stream;

public class FilterProducts implements Filter<Product> {

    @Override
    public Stream<Product> filter(List<Product> products, Specification<Product> specification) {
        return products.stream().filter(product -> specification.isSatisfied(product));
    }
}
