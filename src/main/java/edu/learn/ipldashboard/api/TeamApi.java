package edu.learn.ipldashboard.api;

import edu.learn.ipldashboard.model.Match;
import edu.learn.ipldashboard.model.Team;
import edu.learn.ipldashboard.repository.MatchRepository;
import edu.learn.ipldashboard.repository.TeamRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" })
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

    @GetMapping(path = "/team/{teamName}/matches")
    public List<Match> getTeam(@PathVariable String teamName, @RequestParam int year) {
        return matchRepository.getTeamMatchListForYear(teamName, year);
    }

    @GetMapping(path = "/team")
    public List<Team> getTeam() {
        return teamRepository.findAll();
    }
}
