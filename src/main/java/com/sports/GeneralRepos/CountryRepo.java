package com.sports.GeneralRepos;

import com.sports.Country.Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sahin on 23.04.2018.
 */
@Repository
public interface CountryRepo extends JpaRepository<Country,Integer> {
}
