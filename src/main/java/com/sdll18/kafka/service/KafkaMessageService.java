package com.sdll18.kafka.service;

import org.springframework.messaging.Message;

/**
 * Copyright (C) 2015 - 2016 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: junlanli@sohu-inc.com
 * @Date: 2016-10-12
 */
public interface KafkaMessageService {

    void processMessage(Message<String> msg);
}
