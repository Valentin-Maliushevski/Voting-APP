package com.vote.core.dto;

import java.util.UUID;

public class VoteCreate {
    private UUID candidate;
    private UUID party;

    public VoteCreate(UUID candidate, UUID party) {
        this.candidate = candidate;
        this.party = party;
    }

    public VoteCreate() {
    }

    public UUID getCandidate() {
        return candidate;
    }

    public void setCandidate(UUID candidate) {
        this.candidate = candidate;
    }

    public UUID getParty() {
        return party;
    }

    public void setParty(UUID party) {
        this.party = party;
    }
}
