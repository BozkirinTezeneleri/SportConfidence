package com.sports.Country.Entities;

import lombok.Data;
<<<<<<< HEAD
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
=======
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
>>>>>>> 2f426eb55c7fcf27d7f1341c076c5e2a13bfcab6
import javax.validation.constraints.NotNull;

/**
 * Created by sahin on 07.03.2018.
 */
@Entity
@Data
public class Country {
    @Id
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int CountryId;
=======
    private int id;
>>>>>>> 2f426eb55c7fcf27d7f1341c076c5e2a13bfcab6
    @NotNull
    private String CountryName;
}
