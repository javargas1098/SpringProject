package com.example.test.entities;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "episodes")
@Data
public class Episode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue
    @Column(name = "episode")
    private Integer id;

    @Column(name = "name")
    private String episodeName;

    @Transient
    private List<Character> characters;
}
