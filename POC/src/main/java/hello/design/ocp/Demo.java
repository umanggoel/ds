package com.company.design.ocp;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Demo {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product(1,ColorEnum.BLUE,SizeEnum.S,PriceEnum.TEN));
        products.add(new Product(2,ColorEnum.GREEN,SizeEnum.L,PriceEnum.TEN));
        products.add(new Product(3,ColorEnum.BLUE,SizeEnum.M,PriceEnum.TWENTY));
        products.add(new Product(4,ColorEnum.RED,SizeEnum.S,PriceEnum.THRITY));

        Filter<Product> filter = new FilterProducts();
        System.out.println(filter.filter(input-> {
            return products.stream().filter((product -> product.getColor() == ColorEnum.RED)).collect(toList());
        },products));

        System.out.println( filter.filter(products, new Specification<Product>() {
            @Override
            public boolean isSatisfied(Product product) {
                return product.getColor() == ColorEnum.RED;
            }
        }).collect(toList()));

    }
}
