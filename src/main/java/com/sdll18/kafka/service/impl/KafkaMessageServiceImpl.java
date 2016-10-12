package com.sdll18.kafka.service.impl;

import com.sdll18.kafka.service.KafkaMessageService;
import org.apache.log4j.Logger;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

/**
 * Copyright (C) 2015 - 2016 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: junlanli@sohu-inc.com
 * @Date: 2016-10-12
 */
public class KafkaMessageServiceImpl implements KafkaMessageService {

    private static final Logger logger = Logger.getLogger(KafkaMessageServiceImpl.class);

    @Override
    public void processMessage(Message<String> msg) {
        System.out.println("Consumer Message received: ");
        String data = msg.getPayload();
        MessageHeaders messageHeaders = msg.getHeaders();
        System.out.println("Topic:" + messageHeaders.get(KafkaHeaders.RECEIVED_TOPIC));
        System.out.println("MessageKey:" + messageHeaders.get(KafkaHeaders.RECEIVED_MESSAGE_KEY));
        System.out.println("Data:" + data);
    }
}
