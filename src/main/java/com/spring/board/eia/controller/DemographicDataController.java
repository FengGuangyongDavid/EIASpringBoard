package com.spring.board.eia.controller;

import com.spring.board.eia.Helper.SubstanceStatisticsHelper;
import com.spring.board.eia.domain.SubstanceStatistics;
import com.spring.board.eia.entity.DemographicDataType;
import com.spring.board.eia.entity.Person;
import com.spring.board.eia.repository.PersonRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class DemographicDataController {
    @Autowired
    private PersonRepository repository;
    @GetMapping("/getGenderInfo")
    public String getGenderInfo() {

        List<Person> personList = repository.findPersons();
        Set<String> dataSet= personList.stream().map(Person::getGender).collect(Collectors.toSet());
        return getString(dataSet, personList, DemographicDataType.gender);
    }
    @GetMapping("/getRacialInfo")
    public String getRacialInfo() {
        List<Person> personList = repository.findPersons();
        Set<String> dataSet= personList.stream().map(Person::getRacial).collect(Collectors.toSet());
        return getString(dataSet, personList,DemographicDataType.racial);
    }
    @GetMapping("/getAgeInfo")
    public String getAgeInfo() {

        List<Person> personList = repository.findPersons();
        Set<String> dataSet= personList.stream().map(p->String.valueOf(p.getAge())).collect(Collectors.toSet());
        return getString(dataSet, personList,DemographicDataType.age);

    }
    @GetMapping("/getSubstanceInfo")
    public String getSubstanceInfo() {
        List<Person> personList = repository.findPersons();
        SubstanceStatistics substanceStatistics = SubstanceStatisticsHelper.generate(personList);
        JSONObject jsonObject = new JSONObject(substanceStatistics);
        return jsonObject.toString();
    }

    private static String getString(Set<String> dataSet, List<Person> personList, DemographicDataType type) {
        List<Object> data = new ArrayList<>();

        dataSet.forEach(param->{
            long count=0;
            if (type.equals(DemographicDataType.gender)) {
                 count = personList.stream().filter(person -> person.getGender().equalsIgnoreCase(param)).count();
            } else if (type.equals(DemographicDataType.age)) {
                count = personList.stream().filter(person -> String.valueOf(person.getAge()).equalsIgnoreCase(param)).count();
            }else if (type.equals(DemographicDataType.racial)){
                count = personList.stream().filter(person -> person.getRacial().equalsIgnoreCase(param)).count();
            }
            Map<String,Object> map = new HashMap();
            map.put("name", param);
            map.put("value", count);
            data.add(map);
        });
        Map<String,Object> result = new HashMap<>();
        result.put("name","Demographic Data - "+type.getDisplayName());
        result.put("data", data);
        JSONObject jsonObject = new JSONObject(result);
        return jsonObject.toString();
    }



}
