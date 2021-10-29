package edu.learn.ipldashboard.data;

import edu.learn.ipldashboard.model.Match;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {


    @Override
    public Match process(MatchInput matchInput) {
        Match match = new Match();

        match.setId(Long.parseLong(matchInput.getId()));
        match.setCity(matchInput.getCity());
        match.setUmpire1(matchInput.getUmpire1());
        match.setUmpire2(matchInput.getUmpire2());
        match.setTossWinner(matchInput.getToss_winner());
        match.setMatchWinner(match.getMatchWinner());
        match.setPlayerOfMatch(matchInput.getPlayer_of_match());
        match.setMatchResult(matchInput.getResult());
        match.setResultMargin(matchInput.getResult_margin());
        match.setVenue(matchInput.getVenue());

        match.setMatchDate(LocalDate.parse(matchInput.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        String teamToBatFirstInn;
        String teamToBatSecondInn;

        if ("bat".equals(matchInput.getToss_decision())) {
            teamToBatFirstInn = matchInput.getToss_winner();
            teamToBatSecondInn = teamToBatFirstInn.equals(matchInput.getTeam1())
                                    ? matchInput.getTeam2() : matchInput.getTeam1();
        } else {
            teamToBatSecondInn = matchInput.getToss_winner();
            teamToBatFirstInn = teamToBatSecondInn.equals(matchInput.getTeam1())
                    ? matchInput.getTeam2() : matchInput.getTeam1();
        }

        match.setTeamToBatFirstInn(teamToBatFirstInn);
        match.setTeamToBatSecondInn(teamToBatSecondInn);
        return match;
    }
}
