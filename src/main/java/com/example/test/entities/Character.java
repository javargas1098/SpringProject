package com.example.test.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "characters")
@Data
public class Character implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "species")
    private String species;
    @Column(name = "image")
    private String image;
    @Column(name = "gender")
    private String gender;

    @ManyToOne
    @JoinColumn(name = "id_location")
    private Location location;

}
