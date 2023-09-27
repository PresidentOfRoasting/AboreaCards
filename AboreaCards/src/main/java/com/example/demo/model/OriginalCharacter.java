package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "OriginalCharacter")
@Table(
        name = "originalCharacter",
        uniqueConstraints = {
                @UniqueConstraint(name = "originalCharacter_name_unique", columnNames = "name")
        }
)
public class OriginalCharacter {

    @Id
    @SequenceGenerator(
            name = "originalCharacter_sequence",
            sequenceName = "originalCharacter_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "originalCharacter_sequence"
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

    @ManyToOne
    @JoinColumn(
            name = "folk_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "folk_originalCharacter_fk"
            )
    )
    private Folk folk;

    @ManyToOne
    @JoinColumn(
            name = "job_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "job_originalCharacter_fk"
            )
    )
    private Job job;

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

    @ManyToOne
    @JoinColumn(
            name = "grade_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "grade_originalCharacter_fk"
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
            name = "tavern",
            nullable = false

    )
    private Boolean tavern;

    @Column(
            name = "newFace",
            nullable = false

    )
    private Boolean newFace;

    @Column(
            name = "adventure",
            nullable = false

    )
    private Boolean adventure;

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
            name = "enemy",
            nullable = false

    )
    private Boolean enemy;

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

    @Lob
    @Column(
            name = "image_data"/*,
            columnDefinition = "BYTEA"*/
    )
    private byte[] imageData;

    @OneToMany(
            mappedBy = "originalCharacter",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<CompanionCharacter> companionCharacters = new ArrayList<>();
}
