package com.spring.board.eia.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
@Builder
public class SubstanceStaticsJson {
    public List<String> columns;
    public List<Integer> currentValues;
    public List<Integer> historicValues;
}
