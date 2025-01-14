package org.example.mate_matcher.repository;

import org.example.mate_matcher.model.storage.FFPerson;

import java.util.HashMap;
import java.util.Map;

public class PersonStorage {
    private final Map<String, FFPerson> personDatabase;

    public PersonStorage (){
        this.personDatabase = new HashMap<>();
    }


}
