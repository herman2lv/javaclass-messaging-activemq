package com.hrm.alpha;

import jakarta.jms.Topic;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class Publisher {

    private final JmsTemplate jmsTemplate;
    private final Topic topic;

    @SneakyThrows
    public void send(String content) {
        jmsTemplate.convertAndSend(topic, content);
        log.info("Send message. Topic[{}], message: [{}]", topic.getTopicName(), content);
    }
}
