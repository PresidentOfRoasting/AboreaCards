package com.example.demo.model;

import com.example.demo.repos.GameRepository;
import com.example.demo.repos.OriginalCharacterRepository;
import com.example.demo.repos.OwnedCharacterRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Adventure")
@Table(
        name = "adventure",
        uniqueConstraints = {
                @UniqueConstraint(name = "region_idForProgramming_unique", columnNames = "idForProgramming")
        }
)
public class Adventure {

    @Id
    @SequenceGenerator(
            name = "adventure_sequence",
            sequenceName = "adventure_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "adventure_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "region_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "region_adventure_fk"
            )
    )
    private Region region;

    @Column(
            name = "title",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String title;

    @Column(
            name = "text",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String text;

    @Column(
            name = "title2",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String title2;

    @Column(
            name = "text2",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String text2;

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
            name = "countOfPeople",
            nullable = false
    )
    private Integer countOfPeople;

    @Column(
            name = "cardsAmount",
            nullable = false
    )
    private Integer cardsAmount;

    @Column(
            name = "idForProgramming",
            nullable = false
    )
    private Long idForProgramming;

    public static class ThrowDices
    {
        public static int ThrowTenDice()
        {
            int max = 99;
            Random random = new Random();
            int dice = 0;
            int sum = 0;
            do{
                dice = random.nextInt(10) + 1;
                sum += dice;
            }while (dice == 10 && sum < max);
            return sum;
        }
    }
}
