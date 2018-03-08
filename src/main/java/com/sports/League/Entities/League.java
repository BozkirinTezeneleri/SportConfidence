package com.sports.League.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by sahin on 07.03.2018.
 */
@Entity
@Data
public class League {
    @Id
    private int LeagueId;
    @NotNull
    private String CountryName;
    private int CountryId;
}
