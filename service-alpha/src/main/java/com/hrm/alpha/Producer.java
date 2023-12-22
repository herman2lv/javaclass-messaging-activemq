package com.hrm.alpha;

import jakarta.jms.Message;
import jakarta.jms.Queue;
import jakarta.jms.TextMessage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class Producer {

    private final JmsTemplate jmsTemplate;
    private final Queue queue;

    @SneakyThrows
    public String send(String content) {
        log.info("Sending: {}:{}", queue.getQueueName(), content);
        Message reply = jmsTemplate.sendAndReceive(queue, s -> s.createTextMessage(content));
        Objects.requireNonNull(reply);
        TextMessage textMessage = (TextMessage) reply;
        return textMessage.getText();
    }
}
