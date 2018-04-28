package com.sports.GeneralRepos;

import com.sports.League.Entities.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sahin on 23.04.2018.
 */
@Repository
public interface LeagueRepo extends JpaRepository<League,Integer> {
    List<League> findLeaguesByCountry_CountryId(Integer id);
}
