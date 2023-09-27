package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Game")
@Table(
        name = "Game"
)
public class Game {

    @Id
    @SequenceGenerator(
            name = "game_sequence",
            sequenceName = "game_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "game_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;

    @Column(
            name = "gameState",
            nullable = false
    )
    private Integer gameState;

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
            name = "roundNumber",
            nullable = false
    )
    private Integer roundNumber;

    @Column(
            name = "first",
            nullable = false
    )
    private Integer first;

    @Column(
            name = "second",
            nullable = false
    )
    private Integer second;

    @Column(
            name = "third",
            nullable = false
    )
    private Integer third;

    @Column(
            name = "Fourth",
            nullable = false
    )
    private Integer fourth;

    @Column(
            name = "idOfPersonInCharge",
            nullable = false
    )
    private Integer idOfPersonInCharge;
}
