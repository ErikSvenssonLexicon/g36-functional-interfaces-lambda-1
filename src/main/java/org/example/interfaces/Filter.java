package org.example.interfaces;

@FunctionalInterface
public interface Filter<T> {
    boolean filter(T t);
}
