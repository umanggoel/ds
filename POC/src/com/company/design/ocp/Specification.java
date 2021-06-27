package com.company.design.ocp;

public interface Specification<T> {

    default boolean isSatisfied(T t){
        return false;
    }
}
