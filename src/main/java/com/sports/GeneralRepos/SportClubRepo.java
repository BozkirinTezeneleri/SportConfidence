package com.sports.GeneralRepos;

import com.sports.SportClub.Entities.SportClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sahin on 23.04.2018.
 */
@Repository
public interface SportClubRepo extends JpaRepository<SportClub,Integer> {
    List<SportClub> findSportClubsByLeague_LeagueId(Integer id);
}
