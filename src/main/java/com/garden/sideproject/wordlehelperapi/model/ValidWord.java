package com.garden.sideproject.wordlehelperapi.model;

import lombok.*;
import org.springframework.lang.Nullable;

@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Data
public class ValidWord {

    public boolean valid;

}
