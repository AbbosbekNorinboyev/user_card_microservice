package uz.pdp.card_service.service;

import uz.pdp.card_service.dto.ApiResponse;
import uz.pdp.card_service.dto.CardCreateDTO;

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
