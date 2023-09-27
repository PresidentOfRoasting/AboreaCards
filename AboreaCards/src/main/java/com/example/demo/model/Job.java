package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Job")
@Table(
        name = "job",
        uniqueConstraints = {
                @UniqueConstraint(name = "job_name_unique", columnNames = "name")
        }
)
public class Job {

    @Id
    @SequenceGenerator(
            name = "job_sequence",
            sequenceName = "job_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "job_sequence"
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

    public Job() {}

    public Job(String name)
    {
        this.name = name;
    }
}
