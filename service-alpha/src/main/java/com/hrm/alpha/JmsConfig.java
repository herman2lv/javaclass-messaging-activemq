package com.hrm.alpha;

import jakarta.jms.Queue;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class JmsConfig {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("my-queue");
    }

    @Bean
    @Primary
    public JmsTemplate jmsQueueTemplate(ActiveMQConnectionFactory connectionFactory) {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory);
        return template;
    }

}
