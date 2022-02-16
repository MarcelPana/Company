package com.example.company.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table( name = "address")

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name ="street_number" )
    private String streetNumber;

    @Column( name = "city")
    private String city;

    @Column(name ="country")
    private String country;



}
