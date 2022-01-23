package com.garden.sideproject.wordlehelperapi.model;

import lombok.*;

@Getter
@Builder
@EqualsAndHashCode
public class ValidWord {
    public boolean valid;
    public Error error;
}
