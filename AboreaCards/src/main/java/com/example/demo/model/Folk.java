package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Folk")
@Table(
        name = "folk",
        uniqueConstraints = {
                @UniqueConstraint(name = "folk_name_unique", columnNames = "name")
        }
)
public class Folk {

    @Id
    @SequenceGenerator(
            name = "folk_sequence",
            sequenceName = "folk_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "folk_sequence"
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

    public Folk() {}

    public Folk(String name)
    {
        this.name = name;
    }
}
