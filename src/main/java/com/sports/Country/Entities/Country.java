package com.sports.Country.Entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Created by sahin on 07.03.2018.
 */
@Entity
@Data
public class Country {
    @Id
    private int id;
    @NotNull
    private String CountryName;
}
