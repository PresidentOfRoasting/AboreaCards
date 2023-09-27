package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "CharacterToDraw")
public class CharacterToDraw {

    @Id
    @SequenceGenerator(
            name = "characterToDraw_sequence",
            sequenceName = "originalCharacter_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "characterToDraw_sequence"
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
                    name = "game_characterToDraw_fk"
            )
    )
    private Game game;

    @ManyToOne
    @JoinColumn(
            name = "originalCharacter_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "originalCharacter_characterToDraw_fk"
            )
    )
    private OriginalCharacter originalCharacter;

    @Column(
            name = "count",
            nullable = false

    )
    private Integer count;
}