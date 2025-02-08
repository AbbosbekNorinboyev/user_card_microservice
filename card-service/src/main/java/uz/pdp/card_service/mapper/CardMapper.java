package uz.pdp.card_service.mapper;

import org.springframework.stereotype.Component;
import uz.pdp.card_service.dto.CardCreateDTO;
import uz.pdp.card_service.entity.Card;

@Component
public class CardMapper {
    public Card toEntity(CardCreateDTO cardCreateDTO) {
        return Card.builder()
                .type(cardCreateDTO.getType())
                .code(cardCreateDTO.getCode())
                .userId(cardCreateDTO.getUserId())
                .build();
    }

    public CardCreateDTO toDto(Card card) {
        return CardCreateDTO.builder()
                .id(card.getId())
                .type(card.getType())
                .code(card.getCode())
                .userId(card.getUserId())
                .build();
    }
}
