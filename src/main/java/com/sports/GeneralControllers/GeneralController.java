package com.sports.GeneralControllers;

import com.sports.Country.Entities.Country;
import com.sports.Country.Service.CountryService;
import com.sports.League.Entities.League;
import com.sports.League.Service.LeagueService;
import com.sports.SportClub.Entities.SportClub;
import com.sports.SportClub.Service.SportClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sahin on 23.04.2018.
 */
@RestController
@RequestMapping
public class GeneralController {
    @Autowired
    CountryService countryService;
    @Autowired
    LeagueService leagueService;
    @Autowired
    SportClubService sportClubService;


    @GetMapping("/countries")
    @ResponseStatus(HttpStatus.OK)
    public List<Country> getAllCountries(){
        return countryService.getCountries();
    }

    @GetMapping("/leagues")
    @ResponseStatus(HttpStatus.OK)
    public List<League> getAllLeagues(){
        return leagueService.getLeagues();
    }

    @GetMapping("/sportclubs")
    @ResponseStatus(HttpStatus.OK)
    public List<SportClub> getAllClubs(){
        return sportClubService.getSportClubs();
    }

    @GetMapping("/leagues/country/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<League> findLeagueByCountryId(@PathVariable Integer id){
        return leagueService.findByLeague(id);
    }

}
