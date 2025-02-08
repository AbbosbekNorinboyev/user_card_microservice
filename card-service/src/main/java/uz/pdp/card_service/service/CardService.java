package uz.pdp.card_service.service;

import org.springframework.http.ResponseEntity;
import uz.pdp.card_service.dto.ApiResponse;
import uz.pdp.card_service.dto.CardCreateDTO;
import uz.pdp.card_service.entity.Card;

import java.util.List;

public interface CardService {
    ApiResponse<CardCreateDTO> createCard(CardCreateDTO cardCreateDTO);

    ApiResponse<CardCreateDTO> getCard(Integer id);
    Integer getUserId(Integer userId);
    ApiResponse<List<CardCreateDTO>> getAllCard();

    ApiResponse<CardCreateDTO> updateCard(CardCreateDTO cardCreateDTO);

    ApiResponse<CardCreateDTO> deleteCard(Integer id);
    ApiResponse<?> deleteCardByUserId(Integer userId);

    List<Integer> getAllUserIds();
}
