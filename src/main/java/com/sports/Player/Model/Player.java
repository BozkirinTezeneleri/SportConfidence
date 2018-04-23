package com.sports.Player.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sports.Country.Entities.Country;
import com.sports.SportClub.Entities.SportClub;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

/**
 * Created by sahin on 07.03.2018.
 */
@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int playerId;
    private String name;
    private String surname;
    @NotNull(message="Please enter a date")
    @JsonFormat(shape = JsonFormat.Shape.ANY, pattern = "yyyy-MM-dd")
    private Date birthDate;
    @Max(210)
    private float Height;
    @Max(210)
    private float weight;
    @NotNull(message="Please enter a date")
    @JsonFormat(shape = JsonFormat.Shape.ANY, pattern = "yyyy-MM-dd")
    private Date contractTimeEnd;
    @NotNull(message="Please enter a date")
    @JsonFormat(shape = JsonFormat.Shape.ANY, pattern = "yyyy-MM-dd")
    private Date contractTimeStart;
    @ManyToOne
    private Country country;
    @ManyToOne
    private SportClub sportClub;
    private String disabilityInformation;
    @NotNull(message="Please enter a info")
    private boolean disabilityState;
    private float testimonial;
}
