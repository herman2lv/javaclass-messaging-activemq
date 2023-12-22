package com.hrm.bravo;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
@RequiredArgsConstructor
public class QueueListener {

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = "my-queue", containerFactory = "queueListenerFactory")
    public void receive(Message message) throws JMSException {
        TextMessage textMessage = (TextMessage) message;
        log.info("Received: {}", textMessage.getText());
        jmsTemplate.convertAndSend(message.getJMSReplyTo(), "Got you at: " + LocalDateTime.now());
    }
}
