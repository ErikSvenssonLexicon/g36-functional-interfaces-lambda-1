package org.example;

import org.example.interfaces.Filter;
import org.example.interfaces.Initializer;
import org.example.interfaces.Mapper;
import org.example.model.Person;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.*;

public class App2 {
    public static void main(String[] args) {
        Filter<Integer> positive = i -> i > 0;
        Filter<String> isErik = s -> s.equalsIgnoreCase("Erik");

        System.out.println(isErik.filter("Johny"));
        System.out.println(isErik.filter("eRik"));

        Mapper<String, Double> stringToDouble = str -> Double.valueOf(str);
        double d = stringToDouble.map("5.8");
        System.out.println(d);

        Initializer<List<String>> listInitializer = () -> new ArrayList<>();

        List<String> strings = listInitializer.get();

        example();
    }

    public static void example(){
        List<Person> people = Arrays.asList(
                new Person(1, "Erik", "Svensson", LocalDate.parse("1976-09-11")),
                new Person(2, "Ola", "Svensson", LocalDate.parse("1977-09-11")),
                new Person(3, "Erik", "Andersson", LocalDate.parse("1986-10-05")),
                new Person(4, "David", "Aguilera", LocalDate.parse("1990-01-05")),
                new Person(5, "Linda", "Johansson", LocalDate.parse("1976-09-11"))
        );

        Collection<Integer> datesSorted = foo(
                people,
                person -> person.getBirthDate().isAfter(LocalDate.parse("1979-12-31")),
                person -> Period.between(person.getBirthDate(), LocalDate.now()).getYears(),
                () -> new TreeSet<>()
        );

        System.out.println(datesSorted);




    }



    public static <T,R> Collection<R > foo(
            Collection<T> source,
            Filter<T> filter,
            Mapper<T, R> mapper,
            Initializer<Collection<R>> initializer
            )
    {
        Collection<R> result = initializer.get();
        for(T t : source){
            if(filter.filter(t)){
                result.add(mapper.map(t));
            }
        }
        return result;
    }
}
