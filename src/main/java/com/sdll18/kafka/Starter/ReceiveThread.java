package com.sdll18.kafka.Starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.xml.PointToPointChannelParser;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * Copyright (C) 2015 - 2016 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: junlanli@sohu-inc.com
 * @Date: 2016-10-12
 */
public class ReceiveThread extends Thread {

    private boolean flag = true;

    private QueueChannel queueChannel;


    public void run() {
        Message msg = null;
        while (flag) {
            msg = queueChannel.receive(2000);
            if (msg != null) {
                String map = (String) msg.getPayload();
                System.out.println(map);
            }
        }

    }

    public void shutDown() {
        flag = false;
    }
}
