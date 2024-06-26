package com.WEATHER.model;

import lombok.*;

@Data
@NoArgsConstructor
public class Customer
{
    private Integer ID;
    private String name;
    private String email;
    private String city;
}
