package edu.learn.ipldashboard.data;

import edu.learn.ipldashboard.model.Team;
import edu.learn.ipldashboard.model.TeamMatchCount;
import edu.learn.ipldashboard.repository.MatchRepository;
import edu.learn.ipldashboard.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;

    public JobCompletionNotificationListener(MatchRepository matchRepository, TeamRepository teamRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");

            Set<TeamMatchCount> firstInnTeamList = matchRepository.findDistinctTeamToBatFirstInn();
            Set<TeamMatchCount> secondInnTeamList = matchRepository.findDistinctTeamToBatSecondInn();
            Set<TeamMatchCount> winnerTeamList = matchRepository.findDistinctMatchWinner();

            Map<String, Long> teamWithMatchCount = secondInnTeamList
                    .stream()
                    .collect(Collectors.toMap(
                            TeamMatchCount::getTeamName,
                            e -> e.getMatchCount() +
                                    getCount(firstInnTeamList, e.getTeamName())
                    ));

            teamWithMatchCount.putAll(
                    firstInnTeamList.stream()
                        .filter(team -> !teamWithMatchCount.containsKey(team.getTeamName()))
                        .collect(Collectors.toMap(
                                TeamMatchCount::getTeamName,
                                e -> e.getMatchCount() +
                                    getCount(secondInnTeamList, e.getTeamName())
                        ))
            );

            teamWithMatchCount.entrySet().stream()
                    .map((e) -> new Team(e.getKey(), e.getValue(), getCount(winnerTeamList, e.getKey()))).
                    forEach(teamRepository::save);

        }
    }

    private Long getCount(Set<TeamMatchCount> teams, String name) {
        Optional<TeamMatchCount> first = teams.stream().filter(t -> name.equals(t.getTeamName())).findFirst();
        if (first.isPresent())
            return first.get().getMatchCount();
        return 0L;
    }
}
