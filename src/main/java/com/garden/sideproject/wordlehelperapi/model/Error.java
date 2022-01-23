package com.garden.sideproject.wordlehelperapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class Error {
    public int errorCode;
    public String errorDesc;
}
