package com.solvd.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String zipCode;
    private String login;
    private String password;
    private List<Order> orders;
}
