package com.hrm.alpha;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class AppDemoAction {

    private final Producer producer;

    @Scheduled(fixedRate = 5000)
    public void sendToQueue() {
        String reply = producer.send("To queue[" + LocalDateTime.now() + "]");
        log.info("Received: {}", reply);
    }


}
