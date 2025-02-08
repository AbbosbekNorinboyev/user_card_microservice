package uz.pdp.card_service.service.impl;

import org.springframework.stereotype.Service;
import uz.pdp.card_service.config.UserClient;
import uz.pdp.card_service.dto.ApiResponse;
import uz.pdp.card_service.dto.CardCreateDTO;
import uz.pdp.card_service.entity.Card;
import uz.pdp.card_service.mapper.CardMapper;
import uz.pdp.card_service.repository.CardRepository;
import uz.pdp.card_service.service.CardService;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    private final CardMapper cardMapper;
    private final CardRepository cardRepository;
    private final UserClient userClient;

    public CardServiceImpl(CardMapper cardMapper, CardRepository cardRepository, UserClient userClient) {
        this.cardMapper = cardMapper;
        this.cardRepository = cardRepository;
        this.userClient = userClient;
    }

    @Override
    public ApiResponse<CardCreateDTO> createCard(CardCreateDTO cardCreateDTO) {
        try {
            Card card;
            List<Integer> allUserIds = getAllUserIds();
            if (allUserIds.contains(cardCreateDTO.getUserId())) {
                card = cardMapper.toEntity(cardCreateDTO);
                cardRepository.save(card);
            } else {
                return ApiResponse.<CardCreateDTO>builder()
                        .code(-1)
                        .message("User not found: " + cardCreateDTO.getUserId())
                        .success(false)
                        .build();
            }
            return ApiResponse.<CardCreateDTO>builder()
                    .code(200)
                    .message("Ok")
                    .success(true)
                    .data(cardMapper.toDto(card))
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ApiResponse<CardCreateDTO> getCard(Integer id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found: " + id));
        return ApiResponse.<CardCreateDTO>builder()
                .code(200)
                .message("Ok")
                .success(true)
                .data(cardMapper.toDto(card))
                .build();
    }

    @Override
    public Integer getUserId(Integer userId) {
        return cardRepository.getUserId(userId);
    }

    @Override
    public ApiResponse<List<CardCreateDTO>> getAllCard() {
        List<Card> cards = cardRepository.findAll();
        if (cards.isEmpty()) {
            return ApiResponse.<List<CardCreateDTO>>builder()
                    .code(-1)
                    .message("Not found cards")
                    .success(false)
                    .build();
        }
        return ApiResponse.<List<CardCreateDTO>>builder()
                .code(200)
                .message("Ok")
                .success(true)
                .data(cards.stream().map(cardMapper::toDto).toList())
                .build();
    }

    @Override
    public ApiResponse<CardCreateDTO> updateCard(CardCreateDTO cardCreateDTO) {
        Card existingCard = cardRepository.findById(cardCreateDTO.getId())
                .orElseThrow(() -> new RuntimeException("Card not found: " + cardCreateDTO.getId()));
        existingCard.setType(cardCreateDTO.getType());
        existingCard.setCode(cardCreateDTO.getCode());
        Card savedCard = cardRepository.save(existingCard);
        return ApiResponse.<CardCreateDTO>builder()
                .code(200)
                .message("Card Successfully updated")
                .success(true)
                .data(cardMapper.toDto(savedCard))
                .build();
    }

    @Override
    public ApiResponse<CardCreateDTO> deleteCard(Integer id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found: " + id));
        cardRepository.delete(card);
        return ApiResponse.<CardCreateDTO>builder()
                .code(200)
                .message("Card successfully deleted")
                .success(true)
                .build();
    }

    @Override
    public ApiResponse<?> deleteCardByUserId(Integer userId) {
        cardRepository.deleteCardByUserId(userId);
        return ApiResponse.builder()
                .code(0)
                .message("Card deleted by userId")
                .success(true)
                .build();
    }

    @Override
    public List<Integer> getAllUserIds() {
        return userClient.getIds();
    }
}
