package com.sports.SportClub.Entities;

import com.sports.League.Entities.League;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by sahin on 07.03.2018.
 */
@Entity
@Data
public class SportClub {
    @Id
    private int sportClubId;
    private String name;
    @ManyToOne
    private League league;
    private String insignie;
}
