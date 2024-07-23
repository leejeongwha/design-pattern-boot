package com.example.election.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class PaxosState {
    // Learner의 상태 값
    public static String state = "foo";

    public static class Acceptor {
        // promise 아이디
        public static int promiseId = -1;
        // 수락된 제안
        public static Proposal acceptedProposal = null;
    }

    public static class Proposer {
        // 제안 번호
        public static int proposalNumber = 0;
        public static AtomicInteger countPrepareOK = new AtomicInteger(0);
        public static AtomicInteger countAcceptOK = new AtomicInteger(0);
    }

    @AllArgsConstructor
    @ToString
    public static class Proposal {
        public int proposalNumber;
        public String value;
    }
}
