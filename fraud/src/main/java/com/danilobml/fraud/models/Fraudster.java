package com.danilobml.fraud.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


// NOTE - This DB table simulates an external API that checks fraudsters 
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fraudster {
    
    @Id
    @SequenceGenerator(
        name = "fraudster_id_sequence",
        sequenceName = "fraudster_id_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.IDENTITY,
        generator = "fraudster_id_sequence"
    )
    private int id;
    private String email;

}
