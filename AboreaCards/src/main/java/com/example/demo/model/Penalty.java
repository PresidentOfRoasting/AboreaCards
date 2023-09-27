package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Penalty")
public class Penalty {
    @Id
    @SequenceGenerator(
            name = "penalty_sequence",
            sequenceName = "penalty_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "penalty_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "type",
            nullable = false

    )
    private Integer type;

    @Column(
            name = "attack",
            nullable = false

    )
    private Integer attack;

    @Column(
            name = "initiative",
            nullable = false

    )
    private Integer initiative;

    @Column(
            name = "armor",
            nullable = false

    )
    private Integer armor;

    @Column(
            name = "livePoints",
            nullable = false

    )
    private Integer livePoints;
}
