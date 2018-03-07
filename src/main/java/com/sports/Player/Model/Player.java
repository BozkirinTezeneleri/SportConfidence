package com.sports.Player.Model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by sahin on 07.03.2018.
 */
@Entity
@Data
public class Player {
    @Id
    private Integer PlayerId;
    private String Name;
    private String Surname;
    @NotNull(message="Please enter a date")
    @Past(message="Only the past is valid")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date BirthDate;
    @Size(max = 250,min = 135)
    private float Height;
    @Size(max = 200,min = 50)
    private float Weight;
    @NotNull(message="Please enter a date")
    @Past(message="Only the past is valid")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date ContractTimeEnd;
    @NotNull(message="Please enter a date")
    @Past(message="Only the past is valid")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date ContractTimeStart;
    private Integer CitizenShipId;
    private Integer TeamId;
    @NotNull(message="Please enter a info")
    private String DisabilityInformation;
    @NotNull(message="Please enter a info")
    private boolean DisabilityState;
    private float Testimonial;
}
