package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "FightingCharacter")
public class FightingCharacter {

    @Id
    @SequenceGenerator(
            name = "fightingCharacter_sequence",
            sequenceName = "fightingCharacter_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "fightingCharacter_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "ownedCharacter_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "ownedCharacter_fightingCharacter_fk"
            )
    )
    private OwnedCharacter ownedCharacter;

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
                    name = "nation_fightingCharacter_fk"
            )
    )
    private Nation nation;

    @ManyToOne
    @JoinColumn(
            name = "folk_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "folk_fightingCharacter_fk"
            )
    )
    private Folk folk;

    @ManyToOne
    @JoinColumn(
            name = "job_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "job_fightingCharacter_fk"
            )
    )
    private Job job;

    @ManyToOne
    @JoinColumn(
            name = "region_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "region_fightingCharacter_fk"
            )
    )
    private Region region;

    @ManyToOne
    @JoinColumn(
            name = "grade_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "grade_fightingCharacter_fk"
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
            name = "starter",
            nullable = false

    )
    private Boolean starter;

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
