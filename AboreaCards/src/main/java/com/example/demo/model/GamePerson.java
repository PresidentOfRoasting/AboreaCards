package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "GamePerson")
public class GamePerson {
    @Id
    @SequenceGenerator(
            name = "gamePerson_sequence",
            sequenceName = "gamePerson_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "gamePerson_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "game_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "gamePerson_game_fk"
            )
    )
    private Game game;

    @ManyToOne
    @JoinColumn(
            name = "person_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "gamePerson_person_fk"
            )
    )
    private Person person;

    @Column(
            name = "gf",
            nullable = false

    )
    private Integer gf = 25;
}
