package com.gpy.deepdemo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.gpy.deepdemo.entity.Person;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Auther: guopy
 * @Date: 2019/2/25 18:11
 * @Version: v1.0.0
 */
public class TestClass {
    public static void main1(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"skds",23,1,"42345",2));
        persons.add(new Person(2,"skds123",33,1,"42345",2));
        persons.add(new Person(3,"skds45",25,1,"42345",2));
        for (Person person : persons) {
            System.out.println("paixuqian ------------");
            System.out.println(person);
        }
        Collections.sort(persons);
        for (Person person : persons) {
            System.out.println("paixuhou ========");
            System.out.println(person);
        }
    }

    public static void main2(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd HHmmss");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        String format = localDateTime.format(dtf);
        System.out.println(format);

        String dateStr = "20190319 121212";
        LocalDateTime parse = LocalDateTime.parse(dateStr, dtf);
        System.out.println(parse);

        Stu stu = new Stu();

        int i = 1;
        int m = 0;
        try {
            int result = i / m;
        } catch (ArithmeticException e){
            System.out.println("进入了catch 1");
            System.out.println(e.toString());
            i = 1000;
            System.out.println("catch i" +i);
            try{
                throw new RuntimeException("第一个catch中抛出了异常");
            } catch (Exception e1){
                System.out.println(e1.getMessage());
            }
        } finally {
            System.out.println("jinqule finally");
            i = 200;
            System.out.println("finally " + i);
        }
        System.out.println("执行了吗" +i );
    }

    static class Stu{
        Date age;
    }


    public static void main3(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"skds",23,1,"42345",2));
        persons.add(new Person(2,"skds123",33,1,"42345",2));
        persons.add(new Person(3,"skds45",25,1,"42345",2));

        String string = JSON.toJSONString(persons);
        System.out.println(string);

        JSONArray objects = JSON.parseArray(string);
        List<Person> people = JSON.parseArray(string, Person.class);
        for (Person person : people) {
            System.out.println(person);
        }

    }

    public static void main4(String[] args) {
        Person person;
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < 100 ; i++){

            person = new Person();
            person.setAge(i);
            people.add(person);
        }
        for (Person person1 : people) {
            System.out.println(person1);
        }
    }

    public static void main5(String[] args) {
        String str1 = new String("1");
        String str2 = new String("2");
        String str3 = new String("3");
        String str4 = new String("4");
        String str5 = new String("5");
        List list = new ArrayList();
        list.add(str1);
        list.add(str2);
        list.add(str3);
        list.add(str4);
        list.add(str5);
        System.out.println("list.size()=" + list.size());

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(str1) || list.get(i).equals(str2)){
                list.remove(list.get(i));
                i--;
            }
            //list.remove(i);
              //i--;
            //System.out.println(i+" "+list.get(i)+" ");
        }
        System.out.println(list.toString());
        System.out.println("after remove:list.size()=" + list.size());
    }

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"skds",23,1,"42345",2));
        persons.add(new Person(2,"skds123",23,1,"42345",2));
        persons.add(new Person(3,"skds45",25,1,"42345",2));

        Map<Integer, List<Person>> collect = persons.stream().collect(Collectors.groupingBy(Person::getAge));
        for (Map.Entry<Integer, List<Person>> entry : collect.entrySet()) {
            System.out.println(entry.getValue());
            System.out.println("-----------");
            long l = System.currentTimeMillis();
            System.out.println(System.currentTimeMillis());
            System.out.println(entry.getKey());
        }

    }
}

