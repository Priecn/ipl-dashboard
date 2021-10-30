package edu.learn.ipldashboard.api;

import edu.learn.ipldashboard.model.Team;
import edu.learn.ipldashboard.repository.MatchRepository;
import edu.learn.ipldashboard.repository.TeamRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamApi {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    public TeamApi(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping(path = "/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        Team team = teamRepository.findByName(teamName);
        team.setMatchList(matchRepository.getLatestMatchListByTeamName(team.getName()));
        return team;
    }
}
