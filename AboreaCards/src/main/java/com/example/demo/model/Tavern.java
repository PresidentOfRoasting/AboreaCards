package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Tavern")
public class Tavern {

    @Id
    @SequenceGenerator(
            name = "tavern_sequence",
            sequenceName = "tavern_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "tavern_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "idOfRound",
            nullable = false

    )
    private Integer idOfRound = 0;

    @OneToMany(
            mappedBy = "tavern",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<OriginalCharacter> originalCharacters = new ArrayList<>();

    public Tavern() {}
}
