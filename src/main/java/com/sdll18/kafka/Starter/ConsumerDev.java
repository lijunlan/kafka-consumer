package com.sdll18.kafka.Starter;

import org.apache.log4j.Logger;

/**
 * Copyright (C) 2015 - 2016 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: junlanli@sohu-inc.com
 * @Date: 2016-10-12
 */
public class ConsumerDev {

    private final static Logger logger = Logger.getLogger(ConsumerDev.class);


    public static void main(String[] args) {
        System.out.println("Consumer Service is starting......");
        final Starter starter = new Starter("spring_config.xml");
        // attach shutdown handler to catch control-c
        Runtime.getRuntime().addShutdownHook(new Thread("shutdown-hook") {
            public void run() {
                starter.shutdown();
            }
        });
        starter.startup();
    }
}
