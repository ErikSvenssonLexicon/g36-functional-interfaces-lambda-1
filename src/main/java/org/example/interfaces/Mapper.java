package org.example.interfaces;

@FunctionalInterface
public interface Mapper<T, R> {
    R map(T t);
}
