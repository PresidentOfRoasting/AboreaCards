package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Fight")
public class Fight {

    @Id
    @SequenceGenerator(
            name = "fight_sequence",
            sequenceName = "fight_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "fight_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;


    public static class FightCalculation {

        private List<FightingCharacter> player1 = new ArrayList<>();
        private List<FightingCharacter> player2 = new ArrayList<>();

        public void CalculateRound()
        {
            List<FightingCharacter> min = null;
            List<FightingCharacter> max = null;

            while (min.size() > 0 && max.size() > 0) {
                if (player1.size() > player2.size())
                {
                    min = player2;
                    max = player1;
                }
                else
                {
                    min = player1;
                    max = player2;
                }
                for (int i = 0; i < min.size(); i++)
                {
                    var character1 = min.get(i);
                    var character2 = max.get(i);

                    if (character1.getInitiative() > character2.getInitiative())
                    {
                        OneOnOneOneRound(character1, character2);
                    }
                    else if (character1.getInitiative() < character2.getInitiative())
                    {
                        OneOnOneOneRound(character2, character1);
                    }
                    else
                    {
                        Random random = new Random();
                        int coin =  random.nextInt(2) + 1;
                        if (coin == 1)
                        {
                            OneOnOneOneRound(character1, character2);
                        }
                        else
                        {
                            OneOnOneOneRound(character2, character1);
                        }
                    }
                }
                if (min != max)
                {
                    for (int i = min.size() + 1; i < max.size(); i++) {
                        var character1 = max.get(i);
                        var character2 = min.get(min.size());
                        if (character1.getLivePoints() <= 0)
                        {
                            max.remove(character1);
                            character1 = max.get(i);
                        }
                        if (character2.getLivePoints() <= 0)
                        {
                            min.remove(character2);
                            character2 = min.get(min.size());
                        }
                        LastOnOneOneRound(character1, character2);
                    }
                }
                for (int i = 0; i < min.size(); i++)
                {
                    var character = min.get(i);
                    if (character.getLivePoints() < 1)
                    {
                        min.remove(character);
                    }
                }
                for (int i = 0; i < max.size(); i++)
                {
                    var character = max.get(i);
                    if (character.getLivePoints() < 1)
                    {
                        max.remove(character);
                    }
                }
            }
        }

        public void OneOnOneOneRound(FightingCharacter character1, FightingCharacter character2)
        {
            if (character1.getAttack() > character2.getArmor()) {
                int livePoints1 = character2.getLivePoints() - (character1.getAttack() - character2.getArmor());
                character2.setLivePoints(livePoints1);
            }

            int attack1 = 0;
            if (character2.getAttack() == 1)
            {
                attack1 = 1;
            }
            else if (character2.getAttack() / 2 == 0)
            {
                attack1 = character2.getAttack() / 2;
            }
            else
            {
                attack1 = character2.getAttack() / 2;
                attack1++;
            }
            if (attack1 > character1.getArmor()) {
                int livePoints2 = character1.getLivePoints() - (attack1 - character1.getArmor());
                character1.setLivePoints(livePoints2);
            }

            if (character2.getLivePoints() > 0)
            {
                if (character2.getAttack() > character1.getArmor())
                {
                    int livePoints3 = character1.getLivePoints() - (character2.getAttack() - character1.getArmor());
                    character1.setLivePoints(livePoints3);
                }

                int attack2 = 0;
                if (character2.getAttack() == 1)
                {
                    attack2 = 1;
                }
                else if (character2.getAttack() / 2 == 0)
                {
                    attack2 = character2.getAttack() / 2;
                }
                else
                {
                    attack2 = character2.getAttack() / 2;
                    attack2++;
                }
                if (attack2 > character2.getArmor())
                {
                    int livePoints4 = character2.getLivePoints() - (attack2 - character2.getArmor());
                    character2.setLivePoints(livePoints4);
                }
            }
        }


        public void LastOnOneOneRound(FightingCharacter character1, FightingCharacter character2)
        {
            if (character1.getAttack() > character2.getArmor())
            {
                int livePoints1 = character2.getLivePoints() - (character1.getAttack() - character2.getArmor());
                character2.setLivePoints(livePoints1);
            }

            int attack1 = 0;
            if (character2.getAttack() == 1)
            {
                attack1 = 1;
            }
            else if (character2.getAttack() / 2 == 0)
            {
                attack1 = character2.getAttack() / 2;
            }
            else
            {
                attack1 = character2.getAttack() / 2;
                attack1++;
            }
            if (attack1 > character1.getArmor())
            {
                int livePoints2 = character1.getLivePoints() - (attack1 - character1.getArmor());
                character1.setLivePoints(livePoints2);
            }
        }
    }
}
