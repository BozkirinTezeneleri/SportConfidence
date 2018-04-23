package com.sports.GeneralRepos;

import com.sports.SportClub.Entities.SportClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sahin on 23.04.2018.
 */
@Repository
public interface SportClubRepo extends JpaRepository<SportClub,Integer> {
}
