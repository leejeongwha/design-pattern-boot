package com.example.election.model;

import lombok.Data;

@Data
public class State {
    // Leaner의 상태 값
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
        public static int countPrepareOK = 0;
        public static int countAcceptOK = 0;
    }
}
