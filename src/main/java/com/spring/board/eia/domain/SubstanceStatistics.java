package com.spring.board.eia.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Map;

@Data
@Getter
@Builder
public class SubstanceStatistics {
    Map<String,Integer> totalPersonCountMap;
    Map<String,Integer>  opiatePeopleCountMap;
    Map<String,Integer>  activeOpiatePeopleCountMap;
    Map<String,Integer>  recoveredOpiatePeopleCountMap;
    Map<String,Integer>  usedOpiatePeopleCountMap;
    Map<String,Integer>  nonOpiatePeopleCountMap;
    Map<String,Integer>  mentalHealthPeopleCountMap;
    Map<String,Integer>  dualDiagnosisPeopleCountMap;
}
