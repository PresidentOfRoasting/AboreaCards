package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Grade")
@Table(
        name = "grade",
        uniqueConstraints = {
                @UniqueConstraint(name = "grade_name_unique", columnNames = "name")
        }
)
public class Grade {

    @Id
    @SequenceGenerator(
            name = "grade_sequence",
            sequenceName = "grade_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "grade_sequence"
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

    /*@OneToMany(
            mappedBy = "student",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<OriginalCharacter> books = new ArrayList<>();*/

    public Grade() {}

    public Grade(String name)
    {
        this.name = name;
    }
}
