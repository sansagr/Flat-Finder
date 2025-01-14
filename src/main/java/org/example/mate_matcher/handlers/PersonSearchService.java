package org.example.mate_matcher.handlers;

import org.example.mate_matcher.model.storage.FFHousePreferences;
import org.example.mate_matcher.model.storage.FFPerson;
import org.example.mate_matcher.repository.PersonStorage;

import java.util.ArrayList;
import java.util.List;

public class PersonSearchService {
    private PersonStorage personStorage;

    public PersonSearchService(PersonStorage personStorage){
        this.personStorage = personStorage;
    }

    public List<FFPerson> searchPerson(FFHousePreferences housePreferences){
//        returns list of people meeting the criteria of the house
        List<FFPerson> personList = new ArrayList<>();
        return  personList;
    }
}
