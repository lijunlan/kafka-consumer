package com.sdll18.kafka.Starter;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import java.util.concurrent.CountDownLatch;

/**
 * Copyright (C) 2015 - 2016 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: junlanli@sohu-inc.com
 * @Date: 2016-10-12
 */
public class Starter {

    private static final Logger logger = Logger.getLogger(Starter.class);

    private String contextFile;
    private CountDownLatch shutdownLatch = new CountDownLatch(1);
    private ReceiveThread receiveThread;

    public Starter(String contextFile) {
        this.contextFile = contextFile;
    }

    public void startup() {
        try {
            Log4jConfigurer.initLogging("classpath:log4j.properties");
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                    new String[]{contextFile});
            context.start();
//            receiveThread = (ReceiveThread) context.getBean("receiveThread");
//            receiveThread.start();
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("1", "1231");
//            jsonObject.put("ett", "test");
//            KafkaService kafkaService = (KafkaService) context.getBean("kafkaService");
//            System.out.println(kafkaService.sendMessage("for_first_test", jsonObject));

//            LeeCacheDao lcd = (LeeCacheDao) context.getBean("leeCacheDao");
//            Lee lee = new Lee();
//            lee.setId("ooiwetriewreworjew");
//            lee.setAge(77);
//            lee.setName("redis_test");
//            lcd.setCacheLee(lee);
//
//            Lee l = lcd.getCacheLee("ooiwetriewreworjew");
//            System.out.println(l);
//            LeeNoSqlService s = (LeeNoSqlService) context.getBean("leeNoSqlService");
//            JSONObject ll = new JSONObject();
//            ll.put("name", "redis");
//            ll.put("age", "12");
////            JSONObject t = s.createLee(ll);
////            System.out.println("return :" + t);
////            JSONObject t2 = s.getLee(t.getString("id"));
////            System.out.println(t2);
//            LeeUserService s = (LeeUserService) context.getBean("leeUserService");
//            JSONObject t = s.createUser(ll);
//            System.out.println("return :" + t);
//
//            JSONObject t2 = s.getUser(t.getString("id"));
//            System.out.println(t2);


            System.out.println("Consumer Service is started!");
            shutdownLatch.await();
        } catch (Exception e) {
            logger.error("Failed to start", e);
            shutdown();
        }

    }

    public void shutdown() {
        if (receiveThread != null) {
            receiveThread.shutDown();
        }
        shutdownLatch.countDown();
        logger.info("shutdown starter");
    }
}
