package com.spring.board.eia.controller;

import com.google.common.collect.Lists;
import com.spring.board.eia.entity.Person;
import com.spring.board.eia.repository.PersonRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OutcomesController {
    @Autowired
    private PersonRepository repository;

    @GetMapping("/getOutcomes")
    public String getOutcomes() {

        List<Person> personList = repository.findPersons();
        long totalPersonNo = personList.size();
        long getPermanentHouseNo = personList.stream().filter(person -> person.getPermanentHouse().equalsIgnoreCase("y")).count();
        long incarceratedNo = personList.stream().filter(person -> person.getCabinStatus().equalsIgnoreCase("active")).count();
        long entrustedAssertiveCommunityNo = personList.stream().filter(person -> person.getEntrustedAssertiveCommunity().equalsIgnoreCase("y")).count();
        long livePeopleNo = personList.stream().filter(person -> person.getLive().equalsIgnoreCase("y")).count();
        //long longerTermSubstanceReturnNo = personList.stream().filter(person -> person.getLongerTermSubstanceReturn().equalsIgnoreCase("y")).count();
        long decidedMoveNo = personList.stream().filter(person -> person.getDecidedMove().equalsIgnoreCase("y")).count();
        long exitByRuleViolationsNo = personList.stream().filter(person -> person.getExitByRuleViolations().equalsIgnoreCase("y")).count();
 //       long connectedToMHProviderNo = personList.stream().filter(person -> !person.getMHProvider().isEmpty()).count();
   //     long documentationAssistanceNo = personList.stream().filter(person -> person.getDocumentationAssistance().equalsIgnoreCase("y")).count();
     //   long getAchievementsNo = personList.stream().filter(person -> !person.getAchievements().isEmpty()).count();
        Map<String,List> result = new HashMap<>();
        result.put("category", Lists.newArrayList("#total","#get\nPermanent\nHouse",
                "#incarcerated","#entrusted\nAssertive\nCommunity",
                "#live\nPeople","#connected\nTo\nMHProvider"));
        result.put("data", Lists.newArrayList(totalPersonNo,getPermanentHouseNo,
                incarceratedNo,entrustedAssertiveCommunityNo,
                livePeopleNo,decidedMoveNo));
        JSONObject jsonObject = new JSONObject(result);
        return jsonObject.toString();
    }
}
