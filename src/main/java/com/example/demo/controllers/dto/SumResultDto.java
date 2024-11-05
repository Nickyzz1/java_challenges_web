package com.example.demo.controllers.dto;
// record, classe imutável
// dto transportar dados de um local para outra na solução
public record SumResultDto(
    Integer result,
    Boolean isEven
) {}
