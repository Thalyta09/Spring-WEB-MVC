package com.tconrado.bootcampDIO.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "teste")
public class Jedi {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "Cannot be blank")
    private String name;

    @Column(name = "lastName")
    @NotEmpty(message = "Cannot be blank")
    private String lastName;
}