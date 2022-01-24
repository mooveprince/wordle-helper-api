package com.garden.sideproject.wordlehelperapi.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Error {
    public int errorCode;
    public String errorDesc;
}
