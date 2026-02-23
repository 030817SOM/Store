package com.example.store.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
    private String name;

    @Id
    private Long id;

    @Column(unique = true)
    private String email;
    private String password;


}
