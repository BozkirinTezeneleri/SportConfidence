package com.sports.Country.Entities;

import lombok.Data;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Created by sahin on 07.03.2018.
 */
@Entity
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int countryId;
    private int id;
    @NotNull
    private String countryName;
}
