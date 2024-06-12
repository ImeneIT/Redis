package com.example.Redis;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Invoice implements Serializable {

    private static final long serialVersionUID = -4439114469417994311L;


    @GeneratedValue
    @Id
    private Integer invId;

    private String invName;
    private Double invAmount;
}