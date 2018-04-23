package com.sports.SportClub.Service;

import com.sports.GeneralRepos.SportClubRepo;
import com.sports.SportClub.Entities.SportClub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sahin on 23.04.2018.
 */
@Service
public class SportClubService {

    @Autowired
    SportClubRepo sportClubRepo;


    public List<SportClub> getSportClubs() {
        return sportClubRepo.findAll();
    }

}
