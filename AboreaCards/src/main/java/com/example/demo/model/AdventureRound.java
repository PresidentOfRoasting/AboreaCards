package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "AdventureRound")
public class AdventureRound {

    @Id
    @SequenceGenerator(
            name = "adventureRound_sequence",
            sequenceName = "adventureRound_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "adventureRound_sequence"
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
            name = "region_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "region_originalCharacter_fk"
            )
    )
    private Region region;

    @Column(
            name = "idOfRound"
    )
    private Integer idOfRound;

    @Column(
            name = "count"
    )
    private Integer count = 0;
}
