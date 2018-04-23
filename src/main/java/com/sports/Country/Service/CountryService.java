package com.sports.Country.Service;

import com.sports.Country.Entities.Country;
import com.sports.GeneralRepos.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sahin on 23.04.2018.
 */
@Service
public class CountryService {

        @Autowired
        CountryRepo countryRepo;
        public List<Country> getCountries() {
        return countryRepo.findAll();
    }


}
