package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Nation")
@Table(
        name = "nation",
        uniqueConstraints = {
                @UniqueConstraint(name = "nation_name_unique", columnNames = "name")
        }
)
public class Nation {

    @Id
    @SequenceGenerator(
            name = "nation_sequence",
            sequenceName = "nation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "nation_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    public Nation() {}

    public Nation(String name)
    {
        this.name = name;
    }
}
