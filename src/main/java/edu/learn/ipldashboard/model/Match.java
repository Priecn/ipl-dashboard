package edu.learn.ipldashboard.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class Match {

    @Id
    private Long id;
    private String city;
    private LocalDate matchDate;
    private String playerOfMatch;
    private String venue;
    private String teamToBatSecondInn;
    private String teamToBatFirstInn;
    private String tossWinner;
    private String tossDecision;
    private String matchWinner;
    private String matchResult;
    private String resultMargin;
    private String umpire1;
    private String umpire2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public String getPlayerOfMatch() {
        return playerOfMatch;
    }

    public void setPlayerOfMatch(String playerOfMatch) {
        this.playerOfMatch = playerOfMatch;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getTeamToBatSecondInn() {
        return teamToBatSecondInn;
    }

    public void setTeamToBatSecondInn(String teamToBatSecondInn) {
        this.teamToBatSecondInn = teamToBatSecondInn;
    }

    public String getTeamToBatFirstInn() {
        return teamToBatFirstInn;
    }

    public void setTeamToBatFirstInn(String teamToBatFirstInn) {
        this.teamToBatFirstInn = teamToBatFirstInn;
    }

    public String getTossWinner() {
        return tossWinner;
    }

    public void setTossWinner(String tossWinner) {
        this.tossWinner = tossWinner;
    }

    public String getTossDecision() {
        return tossDecision;
    }

    public void setTossDecision(String tossDecision) {
        this.tossDecision = tossDecision;
    }

    public String getMatchWinner() {
        return matchWinner;
    }

    public void setMatchWinner(String matchWinner) {
        this.matchWinner = matchWinner;
    }

    public String getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(String matchResult) {
        this.matchResult = matchResult;
    }

    public String getResultMargin() {
        return resultMargin;
    }

    public void setResultMargin(String resultMargin) {
        this.resultMargin = resultMargin;
    }

    public String getUmpire1() {
        return umpire1;
    }

    public void setUmpire1(String umpire1) {
        this.umpire1 = umpire1;
    }

    public String getUmpire2() {
        return umpire2;
    }

    public void setUmpire2(String umpire2) {
        this.umpire2 = umpire2;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", matchDate=" + matchDate +
                ", playerOfMatch='" + playerOfMatch + '\'' +
                ", venue='" + venue + '\'' +
                ", teamToBatSecondInn='" + teamToBatSecondInn + '\'' +
                ", teamToBatFirstInn='" + teamToBatFirstInn + '\'' +
                ", tossWinner='" + tossWinner + '\'' +
                ", tossDecision='" + tossDecision + '\'' +
                ", matchWinner='" + matchWinner + '\'' +
                ", matchResult='" + matchResult + '\'' +
                ", resultMargin='" + resultMargin + '\'' +
                ", umpire1='" + umpire1 + '\'' +
                ", umpire2='" + umpire2 + '\'' +
                '}';
    }
}
