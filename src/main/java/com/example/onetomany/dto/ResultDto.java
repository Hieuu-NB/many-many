package com.example.onetomany.dto;

import lombok.*;

@RequiredArgsConstructor
@Builder
@AllArgsConstructor
//@NoArgsConstructor
@Setter
@Getter
@Data
public class ResultDto {
    private Integer code;
    private String message;
}
