package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Winner")
public class Winner {

    @Id
    @SequenceGenerator(
            name = "winner_sequence",
            sequenceName = "winner_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "winner_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "playerName",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String playerName;

    @Column(
            name = "gf"
    )
    private Long gf;

    @Column(
            name = "regionCount"
    )
    private Long regionCount;

    @Column(
            name = "characterName1",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String characterName1;

    @Column(
            name = "characterName2",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String characterName2;

    @Column(
            name = "characterName3",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String characterName3;

    @Column(
            name = "characterName4",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String characterName4;

    @Column(
            name = "characterName5",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String characterName5;

    @Column(
            name = "comment",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String comment;
}
