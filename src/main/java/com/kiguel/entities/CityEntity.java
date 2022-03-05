package com.kiguel.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kiguel.enums.StatesEnum;

import lombok.Data;

@Data
@Entity
@Table(name="city")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private StatesEnum state;
    
    private String name;
}
