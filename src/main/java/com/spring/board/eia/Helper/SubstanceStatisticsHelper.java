package com.spring.board.eia.Helper;

import com.spring.board.eia.domain.SubstanceStatistics;
import com.spring.board.eia.entity.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SubstanceStatisticsHelper {

    public static String ACTIVE = "ACTIVE";
    public static String IN_ACTIVE = "IN_ACTIVE";
    public static SubstanceStatistics generate(List<Person> personList)
    {
        Map<String,Integer> totalPersonCountMap = new HashMap<>();
        Map<String,Integer>  opiatePeopleCountMap = new HashMap<>();
        Map<String,Integer>  activeOpiatePeopleCountMap = new HashMap<>();
        Map<String,Integer>  recoveredOpiatePeopleCountMap = new HashMap<>();
        Map<String,Integer>  usedOpiatePeopleCountMap = new HashMap<>();
        Map<String,Integer>  nonOpiatePeopleCountMap = new HashMap<>();
        Map<String,Integer>  mentalHealthPeopleCountMap = new HashMap<>();
        Map<String,Integer>  dualDiagnosisPeopleCountMap = new HashMap<>();
        for (Person person : personList){
            String historyOfUse = person.getHistoryOfUse();
            String activeStatus = person.getActiveUser();
            String status= person.getCabinStatus();
            String usedStatus = person.getPreviousUser();
            String nonOpiate = person.getActiveOtherSubstances();
            String mentalHealthStatus = person.getInMentalHealthTreatment();
            String dualDiagnosisStatus = person.getDualDX();
            String recoverStatus = (historyOfUse.equals("Y") && activeStatus.equals("N")) ? "Y" : "N";
            if ("active".equals(status)){
                checkAndAdd("Y",totalPersonCountMap,true);
                checkAndAdd(historyOfUse,opiatePeopleCountMap,true);
                checkAndAdd(activeStatus,activeOpiatePeopleCountMap,true);
                checkAndAdd(recoverStatus,recoveredOpiatePeopleCountMap,true);
                checkAndAdd(usedStatus,usedOpiatePeopleCountMap,true);
                checkAndAdd(nonOpiate,nonOpiatePeopleCountMap,true);
                checkAndAdd(mentalHealthStatus,mentalHealthPeopleCountMap,true);
                checkAndAdd(dualDiagnosisStatus,dualDiagnosisPeopleCountMap,true);
            }else {
                checkAndAdd("Y",totalPersonCountMap,false);
                checkAndAdd(historyOfUse,opiatePeopleCountMap,false);
                checkAndAdd(activeStatus,activeOpiatePeopleCountMap,false);
                checkAndAdd(recoverStatus,recoveredOpiatePeopleCountMap,false);
                checkAndAdd(usedStatus,usedOpiatePeopleCountMap,false);
                checkAndAdd(nonOpiate,nonOpiatePeopleCountMap,false);
                checkAndAdd(mentalHealthStatus,mentalHealthPeopleCountMap,false);
                checkAndAdd(dualDiagnosisStatus,dualDiagnosisPeopleCountMap,false);
            }
        }
        return SubstanceStatistics.builder().activeOpiatePeopleCountMap(activeOpiatePeopleCountMap).dualDiagnosisPeopleCountMap(dualDiagnosisPeopleCountMap)
                .mentalHealthPeopleCountMap(mentalHealthPeopleCountMap).nonOpiatePeopleCountMap(nonOpiatePeopleCountMap)
                .opiatePeopleCountMap(opiatePeopleCountMap).recoveredOpiatePeopleCountMap(recoveredOpiatePeopleCountMap)
                .totalPersonCountMap(totalPersonCountMap).usedOpiatePeopleCountMap(usedOpiatePeopleCountMap).build();
    }

    private static void checkAndAdd(String status,Map<String,Integer> map,boolean isActive){
        if ("Y".equals(status)){
            if (isActive){
                if (map.containsKey(ACTIVE)){
                    map.put(ACTIVE,map.get(ACTIVE) + 1);
                }else {
                    map.put(ACTIVE,1);
                }
            }else {
                if (map.containsKey(IN_ACTIVE)){
                    map.put(IN_ACTIVE,map.get(IN_ACTIVE) + 1);
                }else {
                    map.put(IN_ACTIVE,1);
                }
            }
        }
    }
}
