package com.danilobml.fraud.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FraudCheckHistory {

    @Id
    @SequenceGenerator(
        name = "fraud_id_sequence",
        sequenceName = "fraud_id_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.IDENTITY,
        generator = "fraud_id_sequence"
    )
    private Integer Id;
    private String email;
    private Boolean isFrausdster;
    private LocalDateTime createdAt;
    
}
