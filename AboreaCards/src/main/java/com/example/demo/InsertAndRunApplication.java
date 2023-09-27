package com.example.demo;

import com.example.demo.model.Job;
import com.example.demo.model.Nation;
import com.example.demo.model.OriginalCharacter;
import com.example.demo.model.Region;
import com.example.demo.repos.JobRepository;
import com.example.demo.repos.NationRepository;
import com.example.demo.repos.OriginalCharacterRepository;
import com.example.demo.repos.RegionRepository;
import javassist.NotFoundException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.FileReader;

@SpringBootApplication
public class InsertAndRunApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsertAndRunApplication.class, args);
    }

    @Bean
    CommandLineRunner insertData(NationRepository nationRepository, JobRepository jobRepository, RegionRepository regionRepository, OriginalCharacterRepository originalCharacterRepository)
    {
        return args -> {

            String nationCsv = "C:/Users/Tobiasz Mylak/Desktop/Verschiedenes/Api/AboreaCards/Nation.csv";

            try (BufferedReader br = new BufferedReader(new FileReader(nationCsv))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(";");
                    Nation nation = new Nation();
                    nation.setName(values[0]);
                    nationRepository.save(nation);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            String jobCsv = "C:/Users/Tobiasz Mylak/Desktop/Verschiedenes/Api/AboreaCards/Job.csv";

            try (BufferedReader br = new BufferedReader(new FileReader(jobCsv))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(";");
                    Job job = new Job();
                    job.setName(values[0]);
                    jobRepository.save(job);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            String regionCsv = "C:/Users/Tobiasz Mylak/Desktop/Verschiedenes/Api/AboreaCards/Region.csv";

            try (BufferedReader br = new BufferedReader(new FileReader(regionCsv))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(";");
                    Region region = new Region();
                    region.setName(values[0]);
                    region.setFirst(Integer.valueOf(values[1]));
                    region.setSecond(Integer.valueOf(values[2]));
                    region.setThird(Integer.valueOf(values[3]));
                    region.setFourth(Integer.valueOf(values[4]));
                    region.setFifth(Integer.valueOf(values[5]));
                    region.setSixth(Integer.valueOf(values[6]));
                    region.setSeventh(Integer.valueOf(values[7]));
                    region.setEighth(Integer.valueOf(values[8]));
                    region.setAmountOfMoney(Integer.valueOf(values[9]));
                    regionRepository.save(region);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            String originalCharacterCsv = "C:/Users/Tobiasz Mylak/Desktop/Verschiedenes/Api/AboreaCards/OriginalCharacters.csv";

            try (BufferedReader br = new BufferedReader(new FileReader(originalCharacterCsv))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(";");
                    OriginalCharacter originalCharacter = new OriginalCharacter();
                    originalCharacter.setName(values[0]);
                    Nation orignalCharacterNation = nationRepository.findByName(values[1]);
                    try {
                        originalCharacter.setNation(orignalCharacterNation);
                    }
                    catch (Exception e)
                    {
                        throw new NotFoundException("Nation not found");
                    }
                    Job orignalCharacterJob = jobRepository.findByName(values[2]);
                    try {
                        originalCharacter.setJob(orignalCharacterJob);
                    }
                    catch (Exception e)
                    {
                        throw new NotFoundException("Job not found");
                    }
                    Region orignalCharacterRegion = regionRepository.findByName(values[3]);
                    try {
                        originalCharacter.setRegion(orignalCharacterRegion);
                    }
                    catch (Exception e)
                    {
                        throw new NotFoundException("Region not found");
                    }
                    originalCharacter.setAttack(Integer.valueOf(values[4]));
                    originalCharacter.setInitiative(Integer.valueOf(values[5]));
                    originalCharacter.setArmor(Integer.valueOf(values[6]));
                    originalCharacter.setLivePoints(Integer.valueOf(values[7]));
                    originalCharacter.setHunter(Boolean.valueOf(values[8]));
                    originalCharacter.setStarter(Boolean.valueOf(values[9]));
                    originalCharacter.setNamed(Boolean.valueOf(values[10]));
                    originalCharacter.setEnemy(Boolean.valueOf(values[11]));
                    originalCharacter.setCompanion(Boolean.valueOf(values[12]));
                    originalCharacter.setDoubleAttack(Boolean.valueOf(values[15]));
                    originalCharacter.setDescription(values[16]);
                    if (Boolean.valueOf(values[10]))
                    {
                        originalCharacter.setUpgradable(false);
                    }
                    else
                    {
                        originalCharacter.setUpgradable(true);
                    }
                    originalCharacter.setTavern(true);
                    originalCharacter.setNewFace(true);
                    originalCharacter.setAdventure(false);
                    originalCharacter.setTripleAttack(false);
                    originalCharacter.setAmount(Integer.valueOf(values[17]));
                    originalCharacterRepository.save(originalCharacter);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            String originalCharacterCsv2 = "C:/Users/Tobiasz Mylak/Desktop/Verschiedenes/Api/AboreaCards/OriginalCharacters2.csv";

            try (BufferedReader br = new BufferedReader(new FileReader(originalCharacterCsv2))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(";");
                    OriginalCharacter originalCharacter = originalCharacterRepository.findByName(values[0]);
                    if (originalCharacter != null)
                    {
                        if (Integer.valueOf(values[3]) == 1)
                        {
                            originalCharacter.setTavern(true);
                        }
                        else
                        {
                            originalCharacter.setTavern(false);
                        }
                        if (Integer.valueOf(values[4]) == 1)
                        {
                            originalCharacter.setAdventure(true);
                        }
                        else
                        {
                            originalCharacter.setAdventure(false);
                        }
                        if (Integer.valueOf(values[5]) == 1)
                        {
                            originalCharacter.setNewFace(true);
                        }
                        else
                        {
                            originalCharacter.setNewFace(false);
                        }
                        originalCharacterRepository.save(originalCharacter);
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
