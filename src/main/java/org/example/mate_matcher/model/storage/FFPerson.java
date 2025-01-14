package org.example.mate_matcher.model.storage;

import lombok.Data;
import org.example.mate_matcher.model.enums.Gender;

@Data
public class FFPerson {
    private String id;
    private String name;
    private int age;
    private Gender gender;
    private Boolean isSmoker;
    private Boolean isDrinker;
    private Boolean isVegetarian;

    public FFPerson(String id, String name, int age, Gender gender, Boolean isSmoker, Boolean isDrinker, Boolean isVegetarian){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.isSmoker = isSmoker;
        this.isDrinker = isDrinker;
        this.isVegetarian = isVegetarian;
    }
}
