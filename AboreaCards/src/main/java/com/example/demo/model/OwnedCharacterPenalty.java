package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "OwnedCharacterPenalty")
public class OwnedCharacterPenalty {
    @Id
    @SequenceGenerator(
            name = "ownedCharacterPenalty_sequence",
            sequenceName = "ownedCharacterPenalty_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "ownedCharacterPenalty_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "ownedCharacter_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "ownedCharacterPenalty_ownedCharacter_fk"
            )
    )
    private OwnedCharacter ownedCharacter;

    @ManyToOne
    @JoinColumn(
            name = "penalty_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "ownedCharacterPenalty_penalty_fk"
            )
    )
    private Penalty penalty;
}
