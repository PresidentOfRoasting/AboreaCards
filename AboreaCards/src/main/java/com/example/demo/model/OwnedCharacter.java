package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "OwnedCharacter")
public class OwnedCharacter {

    @Id
    @SequenceGenerator(
            name = "ownedCharacter_sequence",
            sequenceName = "ownedCharacter_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "ownedCharacter_sequence"
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
                    name = "game_ownedCharacter_fk"
            )
    )
    private Game game;

    @ManyToOne
    @JoinColumn(
            name = "person_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "person_ownedCharacter_fk"
            )
    )
    private Person person;

    @ManyToOne
    @JoinColumn(
            name = "originalCharacter_id",
            referencedColumnName = "id",
            nullable = true,
            foreignKey = @ForeignKey(
                    name = "originalCharacter_ownedCharacter_fk"
            )
    )
    private OriginalCharacter originalCharacter;

    @ManyToOne
    @JoinColumn(
            name = "companionCharacter_id",
            referencedColumnName = "id",
            nullable = true,
            foreignKey = @ForeignKey(
                    name = "companionCharacter_ownedCharacter_fk"
            )
    )
    private CompanionCharacter companionCharacter;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @ManyToOne
    @JoinColumn(
            name = "nation_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "nation_ownedCharacter_fk"
            )
    )
    private Nation nation;

    @ManyToOne
    @JoinColumn(
            name = "folk_id",
            referencedColumnName = "id",
            nullable = true,
            foreignKey = @ForeignKey(
                    name = "folk_ownedCharacter_fk"
            )
    )
    private Folk folk;

    @ManyToOne
    @JoinColumn(
            name = "job_id",
            referencedColumnName = "id",
            nullable = true,
            foreignKey = @ForeignKey(
                    name = "job_ownedCharacter_fk"
            )
    )
    private Job job;

    @ManyToOne
    @JoinColumn(
            name = "region_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "region_ownedCharacter_fk"
            )
    )
    private Region region;

    @ManyToOne
    @JoinColumn(
            name = "grade_id",
            referencedColumnName = "id",
            nullable = true,
            foreignKey = @ForeignKey(
                    name = "grade_ownedCharacter_fk"
            )
    )
    private Grade grade;

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

    @Column(
            name = "hunter",
            nullable = false

    )
    private Boolean hunter;

    @Column(
            name = "named",
            nullable = false

    )
    private Boolean named;

    @Column(
            name = "companion",
            nullable = false

    )
    private Boolean companion;

    @Column(
            name = "doubleAttack",
            nullable = false

    )
    private Boolean doubleAttack;

    @Column(
            name = "tripleAttack",
            nullable = false

    )
    private Boolean tripleAttack;

    @Column(
            name = "upgradable",
            nullable = false

    )
    private Boolean upgradable;

    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            name = "amount",
            nullable = false

    )
    private Integer amount;
}
