package fr.mika.infirmier.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String number;
    private String street;
    private int zipCode;
    private String city;
}
