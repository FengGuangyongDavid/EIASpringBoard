package com.spring.board.eia.Helper;

import com.google.common.collect.Lists;
import com.spring.board.eia.domain.SubstanceStaticsJson;
import com.spring.board.eia.domain.SubstanceStatistics;
import com.spring.board.eia.entity.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SubstanceStatisticsHelper {

    public static String ACTIVE = "CURRENT";
    public static String IN_ACTIVE = "HISTORIC";

    public static List<String> columns = Lists.newArrayList("# of \npeople\nused \nopiate\nduring \ntheir\nlifetime"
            ,"# of \npeople\nactively \nusing\nopiates","# of \npeople\nin recovery\nfrom opiate\nuse",
           "# of people\nin treatment\nfor opiate\nusage","# of \npeople\nfor \nusage of\nother \nsubstances",
            "# of people\nin Mental\nHealth \ntreatment","# of \npeople\nreceiving \ntreatment\nfor Dual\nDiagnosis");
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

    public static SubstanceStaticsJson generateGsonObject(SubstanceStatistics substanceStatistics){
        SubstanceStaticsJson substanceStaticsJson = SubstanceStaticsJson.builder().columns(columns)
                .currentValues(getValuesList(ACTIVE,substanceStatistics))
                .historicValues(getValuesList(IN_ACTIVE,substanceStatistics)).build();
return substanceStaticsJson;
    }

    public static List<Integer> getValuesList(String key,SubstanceStatistics substanceStatistics){
        List<Integer> list = new ArrayList<>();
        list.add(getValue(key,substanceStatistics.getOpiatePeopleCountMap()));
        list.add(getValue(key,substanceStatistics.getActiveOpiatePeopleCountMap()));
        list.add(getValue(key,substanceStatistics.getRecoveredOpiatePeopleCountMap()));
        list.add(getValue(key,substanceStatistics.getUsedOpiatePeopleCountMap()));
        list.add(getValue(key,substanceStatistics.getNonOpiatePeopleCountMap()));
        list.add(getValue(key,substanceStatistics.getMentalHealthPeopleCountMap()));
        list.add(getValue(key,substanceStatistics.getDualDiagnosisPeopleCountMap()));
        return list;
    }

    private static Integer getValue(String key,Map<String,Integer> valueMap){
        if (valueMap.containsKey(key)){
            return valueMap.get(key);
        }
        return 20;
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
