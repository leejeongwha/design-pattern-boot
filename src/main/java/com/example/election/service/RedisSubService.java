package com.example.election.service;

import com.example.election.model.PaxosState;
import com.example.election.model.RedisMessage;
import com.example.election.model.SseMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class RedisSubService implements MessageListener {
    @Autowired
    private ApplicationEventPublisher publisher;
    //    public static List<String> messageList = new ArrayList<>();
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void onMessage(Message message, byte[] pattern) {
        Integer proposalNumber = null;
        String value = "";
        String msg = "";

        try {
            RedisMessage redisMessage = mapper.readValue(message.getBody(), RedisMessage.class);
            Map receivedMessage = mapper.readValue(redisMessage.getMessage().toString(), Map.class);

            log.info("chatMessage.getSender() = " + redisMessage.getSender());
            log.info("chatMessage.getMessage() = " + receivedMessage);

            // Phase 2: Promise
            if ("Prepare".equals(redisMessage.getType())) {
                proposalNumber = (Integer) receivedMessage.get("proposalNumber");
                if (proposalNumber >= PaxosState.Acceptor.promiseId) {
                    PaxosState.Acceptor.promiseId = proposalNumber;
                    msg = "[Promise] 수락자들로부터 Promise 응답이 도착 했습니다, 제안 번호 : " + proposalNumber;
                    publisher.publishEvent(new SseMessage(mapper.writeValueAsString(Map.of("event", msg))));
                }
            } else if ("Accept".equals(redisMessage.getType())) {
                // Phase 4 : Accepted
                proposalNumber = (Integer) receivedMessage.get("proposalNumber");
                value = (String) receivedMessage.get("value");
                if (proposalNumber >= PaxosState.Acceptor.promiseId) {
                    PaxosState.Acceptor.promiseId = proposalNumber;
                    PaxosState.Acceptor.acceptedProposal = new PaxosState.Proposal(proposalNumber, value);
                    PaxosState.state = value;
                    msg = "[Accepted] 수락자들이 전달된 Proposal을 반영 하였습니다. : " + PaxosState.Acceptor.acceptedProposal;
                    publisher.publishEvent(new SseMessage(mapper.writeValueAsString(Map.of("event", msg))));
                }
            }
        } catch (Exception e) {
            log.error("Redis Subscribe Error", e);
        }
    }
}
