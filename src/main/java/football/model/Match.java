/*
 * Copyright (c) 2020
 * User:jan
 * File:Match.java
 * Date:2020/11/29 19:57:29
 */

package football.model;

import lombok.Data;

import java.util.Map;

/**
 * @author jan
 * @since 2020/11/29 19:57
 */
@Data
public class Match {
    private long id;
    private long matchId;
    private String league;
    private String matchTime;
    private String homeName;
    private String guestName;
    private String fullScore;
    private String mediumScore;
    private String asianOdds;
    private String bigOdds;

    public Match() {

    }

    public Match(Builder builder) {
        this.matchId = builder.matchId;
        this.league = builder.league;
        this.matchTime = builder.matchTime;
        this.homeName = builder.homeName;
        this.guestName = builder.guestName;
        this.fullScore = builder.fullScore;
        this.mediumScore = builder.mediumScore;
        this.asianOdds = builder.asianOdds;
        this.bigOdds = builder.bigOdds;
    }

    public static class Builder {
        private long matchId = -1;
        private String league = "";
        private String matchTime = "";
        private String homeName = "";
        private String guestName = "";
        private String fullScore = "";
        private String mediumScore = "";
        private String asianOdds = "";
        private String bigOdds = "";

        public Builder setMatchId(long matchId) {
            this.matchId = matchId;
            return this;
        }

        public Builder setLeague(String league) {
            this.league = league;
            return this;
        }

        public Builder setMatchTime(String matchTime) {
            this.matchTime = matchTime;
            return this;
        }

        public Builder setHomeName(String homeName) {
            this.homeName = homeName;
            return this;
        }

        public Builder setGuestName(String guestName) {
            this.guestName = guestName;
            return this;
        }

        public Builder setFullScore(String fullScore) {
            this.fullScore = fullScore;
            return this;
        }

        public Builder setMediumScore(String mediumScore) {
            this.mediumScore = mediumScore;
            return this;
        }

        public Builder setAsianOdds(String asianOdds) {
            this.asianOdds = asianOdds;
            return this;
        }

        public Builder setBigOdds(String bigOdds) {
            this.bigOdds = bigOdds;
            return this;
        }

        public Match builder() {
            return new Match(this);
        }
    }
}
