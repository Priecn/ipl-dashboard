package edu.learn.ipldashboard.repository;

import edu.learn.ipldashboard.model.Match;
import edu.learn.ipldashboard.model.TeamMatchCount;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query("SELECT m.teamToBatSecondInn AS teamName, COUNT(m.teamToBatSecondInn) AS matchCount FROM Match m GROUP BY m.teamToBatSecondInn")
    Set<TeamMatchCount> findDistinctTeamToBatSecondInn();

    @Query("SELECT m.teamToBatFirstInn AS teamName, COUNT(m.teamToBatFirstInn) AS matchCount FROM Match m GROUP BY m.teamToBatFirstInn")
    Set<TeamMatchCount> findDistinctTeamToBatFirstInn();

    @Query("SELECT m.matchWinner AS teamName, COUNT(m.matchWinner) AS matchCount FROM Match m GROUP BY m.matchWinner")
    Set<TeamMatchCount> findDistinctMatchWinner();

    // List<Match> findTop5MatchByTeamToBatFirstInnOrTeamToBatSecondInnOrderByMatchDateDesc(String firstTeam, String secondTeam);
    List<Match> findMatchByTeamToBatFirstInnOrTeamToBatSecondInnOrderByMatchDateDesc(String firstTeam, String secondTeam, Pageable pageable);

    default List<Match> getLatestMatchListByTeamName(String teamName) {
        Pageable pageable = PageRequest.of(0, 5);
        return findMatchByTeamToBatFirstInnOrTeamToBatSecondInnOrderByMatchDateDesc(teamName, teamName, pageable);
    }
}
