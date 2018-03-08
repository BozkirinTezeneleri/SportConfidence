package com.sports.SportClub.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by sahin on 07.03.2018.
 */
@Entity
@Data
public class SportClub {
    @Id
    private int SporClubId;
    private String Name;
    private int LeagueId;
    private String Insignie;
}
