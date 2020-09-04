package com.gpy.deepdemo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.gpy.deepdemo.entity.Aaa;
import com.gpy.deepdemo.entity.Bbb;
import com.gpy.deepdemo.entity.Person;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
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

    public static void mainn(String[] args) {

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

    public static void main222(String[] args) {
        Aaa aaa = new Aaa();
        aaa.setAge("13")
                .setId(1)
                .setSex(false);
        Bbb bbb = new Bbb();
        BeanUtils.copyProperties(aaa, bbb);
        System.out.println(bbb);
    }

    public static void main34(String[] args) {
        String jsonStr = "{\"interface\":{\"globalInfo\":{\"interfaceCode\":\"DFXJ1001\",\"responseCode\":\"1\",\"appId\":\"0\",\"requestTime\":\"2019-05-21 19:00:52:178\",\"requestCode\":\"DZFPQZ\",\"interfaceId\":\"\",\"dataExchangeId\":\"DZFPQZDFXJ10012019-05-21799847156\"},\"returnStateInfo\":{\"returnCode\":\"0000\",\"returnMessage\":\"成功\"},\"Data\":{\"dataDescription\":{\"zipCode\":\"0\"},\"content\":\"eyJGUFFRTFNIIjoiVEVTVDIwMTkwNTIxMTkwMDUyMDEiLCJGUF9ETSI6IjE1MjAwMDE4NjM1NyIsIkZQX0hNIjoiMzAzNzM1NDYiLCJLUFJRIjoiMjAxOTA1MjExOTAyMDIiLCJKWU0iOiIwNjMzNzM1NTE0NTgxOTY3NDMyMiIsIlBERl9VUkwiOiJodHRwOi8vZGV2LmZhcGlhby5jb206MTkwODAvZHpmcC13ZWIvcGRmL2Rvd25sb2FkP3JlcXVlc3Q9ZTV1aGY4V0VUSU9NZ2FhMmNDVU10bEphS1FPNmpUSnFUNTdLLlpOY0haQ29IQ2Z5WFRZc1dWOFVZVDNacDdPaUFRZVg2SjFicWhPLklyMTdicDA4NWdfXyU1RWJCZ2lFaUZiR2MiLCJTUF9VUkwiOiJodHRwczovL3Rlc3R3eC5mYXBpYW8uY29tL2ZwdC13ZWNoYXQvd3hhZGRjYXJkLmRvP2NvZGU9U1FsVXhycE1LSmZHNGYya2RQcyUyRnB5eVRYVmZSMko2SXk1MFladWE3N2pDaU9QR1pIbWdyM21HYkE5c3RkMEtuajNHTmlsazA2R0JJJTBBZ01TZHpvNE5CQSUzRCUzRCJ9\"}}}";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonStr);
            JsonNode anInterface = jsonNode.get("interface");
            JsonNode returnStateInfo = anInterface.get("returnStateInfo");
            JsonNode data = anInterface.get("Data");
            int returnCode = returnStateInfo.get("returnCode").asInt();
            System.out.println(returnCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main11(String[] args) {

        String s = "[{\"name\":\"aaa\",\"count\":11},{\"name\":\"bbb\",\"count\":12},{\"name\":\"bbb\",\"count\":13},{\"name\":\"ccc\",\"count\":14},{\"name\":\"bbb\",\"count\":15},{\"name\":\"aaa\",\"count\":16}]";

        JSONArray jsonArray = JSONArray.parseArray(s);
        List<Map> maps = jsonArray.toJavaList(Map.class);
        Map<String, List> result = new HashMap<>();

        for (Map map : maps) {
            System.out.println("name------>" + map.get("name"));
            System.out.println("count----->" + map.get("count"));
            if (!result.containsKey(map.get("name"))){
                List<Object> list = Lists.newArrayList();
                list.add(map.get("count"));
                result.put(String.valueOf(map.get("name")), list);
            } else {
                List old = result.get(map.get("name"));
                old.add(map.get("count"));
                result.put(String.valueOf(map.get("name")), old);
            }
        }
        System.out.println(result);

    }

    public static void main(String[] args) {
        String str = "[{\"1\":\"1\",\"2\":\"2\"},{\"3\":\"3\",\"4\":\"4\"},{\"5\":\"5\",\"6\":\"6\"}]";
        JSONArray objects = JSONObject.parseArray(str);
        System.out.println(objects.get(0));

        Js js = new Js();
        js.setICON(String.valueOf(objects.get(0)));
        js.setIDS(String.valueOf(objects.get(1)));
        js.setUS(String.valueOf(objects.get(2)));
        System.out.println(JSON.toJSONString(js));

    }

    @Data
    public static class Js{
        private String ICON;
        private String IDS;
        private String US;
    }


}

