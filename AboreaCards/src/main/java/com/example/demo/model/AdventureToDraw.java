package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "AdventureToDraw")
public class AdventureToDraw {

    @Id
    @SequenceGenerator(
            name = "adventureToDraw_sequence",
            sequenceName = "adventureToDraw_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "adventureToDraw_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "adventure_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "adventure_adventureToDraw_fk"
            )
    )
    private Adventure adventure;

    @Column(
            name = "count"
    )
    private Long count;
}
