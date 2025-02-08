package uz.pdp.card_service.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CardCreateDTO {
    private Integer id;
    private String type;
    private String code;
    private Integer userId;
}
