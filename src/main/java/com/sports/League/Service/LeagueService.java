package com.sports.League.Service;

import com.sports.GeneralRepos.LeagueRepo;
import com.sports.League.Entities.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sahin on 23.04.2018.
 */
@Service
public class LeagueService {

    @Autowired
    LeagueRepo leagueRepo;

    public List<League> getLeagues() {
        return leagueRepo.findAll();
    }
}
