package edu.learn.ipldashboard.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Long totalMatchPlayed;
    private Long totalWins;

    public Team() { }
    public Team(String name, Long totalMatchPlayed, Long totalWins) {
        this.name = name;
        this.totalMatchPlayed = totalMatchPlayed;
        this.totalWins = totalWins;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTotalMatchPlayed() {
        return totalMatchPlayed;
    }

    public void setTotalMatchPlayed(Long totalMatchPlayed) {
        this.totalMatchPlayed = totalMatchPlayed;
    }

    public Long getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(Long totalWins) {
        this.totalWins = totalWins;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalMatchPlayed=" + totalMatchPlayed +
                ", totalWins=" + totalWins +
                '}';
    }
}
