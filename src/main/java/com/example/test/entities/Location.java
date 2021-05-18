package com.example.test.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "locations")
@Data
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "dimension")
    private String dimension;
}
