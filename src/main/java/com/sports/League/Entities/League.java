package com.sports.League.Entities;

import com.sports.Country.Entities.Country;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Created by sahin on 07.03.2018.
 */
@Entity
@Data
public class League {
    @Id
    private int leagueId;
    private String leagueName;
    @ManyToOne
    private Country country;
}
