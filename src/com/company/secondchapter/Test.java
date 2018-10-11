package com.company.secondchapter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.function.Function;


/**
 * Created by zzy on 18-9-18.
 */
public class Test {

    public static void main(String[] args){

        String dateStr="2010/01/10";
        SimpleDateFormat format=new SimpleDateFormat("yyyy年M月dd日");

        LocalDate date=LocalDate.of(2010,01,10);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy年M月dd日");
        //DateTimeFormatter.ofPattern("");
        //LocalDate date=LocalDate.of();
        //LocalDate.now();
        System.out.println(date.format(formatter));

        List<List<Integer>> x=new ArrayList<>();
        List<Integer> tmp= Arrays.asList(1,2,3);
        List<Integer> tmp2=Arrays.asList(4,5,6);
        x.add(tmp);
        x.add(tmp2);
        x.stream().flatMap(t->t.stream()).forEach(System.out::println);
        x.stream().map(t->t.stream()).forEach(System.out::println);
       List<List<List<Integer>>> y=new ArrayList<>();

    }
}
