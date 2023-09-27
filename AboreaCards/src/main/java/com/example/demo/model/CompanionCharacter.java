package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "CompanionCharacter")
@Table(
        name = "companionCharacter",
        uniqueConstraints = {
                @UniqueConstraint(name = "companionCharacter_name_unique", columnNames = "name")
        }
)
public class CompanionCharacter {

    @Id
    @SequenceGenerator(
            name = "companionCharacter_sequence",
            sequenceName = "companionCharacter_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "companionCharacter_sequence"
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

    @ManyToOne
    @JoinColumn(
            name = "nation_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "nation_originalCharacter_fk"
            )
    )
    private Nation nation;

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
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;

    @ManyToOne
    @JoinColumn(
            name = "originalCharacter_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "originalCharacter_companionCharacter_fk"
            )
    )
    private OriginalCharacter originalCharacter;

    public CompanionCharacter() {}

    public CompanionCharacter(String name)
    {
        this.name = name;
    }
}
