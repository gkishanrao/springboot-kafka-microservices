package com.nirwantech.email_service.kafka;

import com.nirwantech.base_domains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class OrderConsumer {
    private static  final Logger logger= LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}",
                   groupId = "${spring.kafka.consumer.group-id}")
    public void consume(@RequestBody OrderEvent orderEvent){
        logger.info(String.format("Order event received in email service=>%s",orderEvent.toString()));

//Save the order  event into the DB

    }
}
