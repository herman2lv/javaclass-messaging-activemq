package com.hrm.charlie;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import jakarta.jms.Topic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TopicListener {

    private final Topic topic;

    @JmsListener(destination = "my-topic", containerFactory = "topicListenerFactoryDurable")
    public void receive(Message message) throws JMSException {
        TextMessage textMessage = (TextMessage) message;
        log.info("Received[DURABLE]: {}:{}", topic.getTopicName(), textMessage.getText());
    }
}
