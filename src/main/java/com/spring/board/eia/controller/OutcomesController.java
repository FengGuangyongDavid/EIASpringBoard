package com.spring.board.eia.controller;

import com.spring.board.eia.entity.Person;
import com.spring.board.eia.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OutcomesController {
    @Autowired
    private PersonRepository repository;
    @GetMapping("/getOutcomes")
    public String getOutcomes() {

        List<Person> personList = repository.findPersons();
        long totalPersonNo = personList.size();
        long getPermanentHouseNo = personList.stream().filter(person -> person.getPermanentHouse().equalsIgnoreCase("yes")).count();
        long incarceratedNo = personList.stream().filter(person -> person.getCabinStatus().equalsIgnoreCase("active")).count();
        long entrustedAssertiveCommunityNo = personList.stream().filter(person -> person.getEntrustedAssertiveCommunity().equalsIgnoreCase("yes")).count();
        long livePeopleNo = personList.stream().filter(person -> person.getLive().equalsIgnoreCase("yes")).count();
        long longerTermSubstanceReturnNo = personList.stream().filter(person -> person.getLongerTermSubstanceReturn().equalsIgnoreCase("yes")).count();
        long decidedMoveNo = personList.stream().filter(person -> person.getDecidedMove().equalsIgnoreCase("yes")).count();
        long exitByRuleViolationsNo = personList.stream().filter(person -> person.getExitByRuleViolations().equalsIgnoreCase("yes")).count();
        long connectedToMHProviderNo = personList.stream().filter(person -> !person.getMHProvider().isEmpty()).count();
        long documentationAssistanceNo = personList.stream().filter(person -> person.getDocumentationAssistance().equalsIgnoreCase("yes")).count();
        long getAchievementsNo = personList.stream().filter(person -> !person.getAchievements().isEmpty()).count();


        return null;
    }
}
