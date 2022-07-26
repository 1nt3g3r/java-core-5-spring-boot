package com.goit5.testapp.feature.user;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "\"user\"")
@Data
@Entity
public class User {
    @Id
    private String email;

    private String fullName;

    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
