package com.gpy.deepdemo.alltest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @author: guopy
 * @Date: 2019/4/10 09:52
 * @version: v1.0.0
 */
@SpringJUnitConfig
@Slf4j
public class AllTest {

    @Test
    public void testYear(){
        System.out.println(LocalDateTime.now().getYear());
    }


    @Test
    public void testRandom2(){
        int i = new Random().nextInt(9);
        String newString = String.format("%0"+2+"d", i);
        System.out.println(newString);
    }

    @Test
    public void testSubstring(){
        String string = "1.0ETS_120 00000000";
        String substring = string.substring(3, 11);
        System.out.println(substring);
    }

    @Test
    public void testJsonMapper(){
        String jsonStr = "{\"interface\":{\"globalInfo\":{\"interfaceCode\":\"DFXJ1001\",\"responseCode\":\"1\",\"appId\":\"0\",\"requestTime\":\"2019-05-21 19:00:52:178\",\"requestCode\":\"DZFPQZ\",\"interfaceId\":\"\",\"dataExchangeId\":\"DZFPQZDFXJ10012019-05-21799847156\"},\"returnStateInfo\":{\"returnCode\":\"0000\",\"returnMessage\":\"成功\"},\"Data\":{\"dataDescription\":{\"zipCode\":\"0\"},\"content\":\"eyJGUFFRTFNIIjoiVEVTVDIwMTkwNTIxMTkwMDUyMDEiLCJGUF9ETSI6IjE1MjAwMDE4NjM1NyIsIkZQX0hNIjoiMzAzNzM1NDYiLCJLUFJRIjoiMjAxOTA1MjExOTAyMDIiLCJKWU0iOiIwNjMzNzM1NTE0NTgxOTY3NDMyMiIsIlBERl9VUkwiOiJodHRwOi8vZGV2LmZhcGlhby5jb206MTkwODAvZHpmcC13ZWIvcGRmL2Rvd25sb2FkP3JlcXVlc3Q9ZTV1aGY4V0VUSU9NZ2FhMmNDVU10bEphS1FPNmpUSnFUNTdLLlpOY0haQ29IQ2Z5WFRZc1dWOFVZVDNacDdPaUFRZVg2SjFicWhPLklyMTdicDA4NWdfXyU1RWJCZ2lFaUZiR2MiLCJTUF9VUkwiOiJodHRwczovL3Rlc3R3eC5mYXBpYW8uY29tL2ZwdC13ZWNoYXQvd3hhZGRjYXJkLmRvP2NvZGU9U1FsVXhycE1LSmZHNGYya2RQcyUyRnB5eVRYVmZSMko2SXk1MFladWE3N2pDaU9QR1pIbWdyM21HYkE5c3RkMEtuajNHTmlsazA2R0JJJTBBZ01TZHpvNE5CQSUzRCUzRCJ9\"}}}";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonStr);
            JsonNode anInterface = jsonNode.get("interface");
            JsonNode returnStateInfo = anInterface.get("returnStateInfo");
            JsonNode data = anInterface.get("Data");
            String returnCode = returnStateInfo.get("returnCode").toString();
            System.out.println(returnCode);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testtime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String format = now.format(dateTimeFormatter);
        System.out.println(format);
    }

    @Test
    public void testLog(){
        System.out.println("hhhh");
        log.info("1:{},2:{}", 1,3);
    }

    @Test
    public void testCollection(){
        List<User> list = Lists.newArrayList();
        list.add(new User("aaa",12));
        list.add(new User("bbb",3));
        list.add(new User("ccc",5));

        User user = list.get(0);
        user.setAge(55);
        System.out.println(list);

    }
}

@Data
@AllArgsConstructor
class User{
    private String name;
    private int age;
}