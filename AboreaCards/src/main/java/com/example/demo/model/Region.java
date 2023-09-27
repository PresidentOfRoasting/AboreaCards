package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Region")
@Table(
        name = "region",
        uniqueConstraints = {
                @UniqueConstraint(name = "region_name_unique", columnNames = "name")
        }
)
public class Region {

    @Id
    @SequenceGenerator(
            name = "region_sequence",
            sequenceName = "region_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "region_sequence"
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
            name = "fourth",
            nullable = false
    )
    private Integer fourth;

    @Column(
            name = "fifth",
            nullable = false
    )
    private Integer fifth;

    @Column(
            name = "sixth",
            nullable = false
    )
    private Integer sixth;

    @Column(
            name = "seventh",
            nullable = true
    )
    private Integer seventh;

    @Column(
            name = "eighth",
            nullable = true
    )
    private Integer eighth;

    @Column(
            name = "amountOfMoney",
            nullable = false
    )
    private Integer amountOfMoney;

    public Region() {}

    public Region(String name)
    {
        this.name = name;
    }
}
