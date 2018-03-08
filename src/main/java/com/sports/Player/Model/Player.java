package com.sports.Player.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private int PlayerId;
    private String Name;
    private String Surname;
    @NotNull(message="Please enter a date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthDate;
    @Max(210)
    private float Height;
    @Max(210)
    private float Weight;
    @NotNull(message="Please enter a date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date contractTimeEnd;
    @NotNull(message="Please enter a date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date contractTimeStart;
    private Integer CitizenShipId;
    private Integer TeamId;
    private String DisabilityInformation;
    @NotNull(message="Please enter a info")
    private boolean DisabilityState;
    private float Testimonial;
}
