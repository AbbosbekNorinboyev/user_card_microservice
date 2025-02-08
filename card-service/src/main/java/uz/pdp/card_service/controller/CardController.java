package uz.pdp.card_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.card_service.dto.ApiResponse;
import uz.pdp.card_service.dto.CardCreateDTO;
import uz.pdp.card_service.service.CardService;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping
    public ApiResponse<CardCreateDTO> createCard(@RequestBody CardCreateDTO cardCreateDTO) {
        return cardService.createCard(cardCreateDTO);
    }

    @GetMapping("/{id}")
    public ApiResponse<CardCreateDTO> getCard(@PathVariable Integer id) {
        return cardService.getCard(id);
    }

    @GetMapping("/{userId}")
    public Integer getUserId(@PathVariable Integer userId) {
        return cardService.getUserId(userId);
    }

    @GetMapping
    public ApiResponse<List<CardCreateDTO>> getAllCard() {
        return cardService.getAllCard();
    }

    @PutMapping
    public ApiResponse<CardCreateDTO> updatedCard(@RequestBody CardCreateDTO cardCreateDTO) {
        return cardService.updateCard(cardCreateDTO);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<CardCreateDTO> deleteCard(@PathVariable Integer id) {
        return cardService.deleteCard(id);
    }

    @DeleteMapping("/userId/{userId}")
    public ApiResponse<?> deleteCardByUserId(@PathVariable Integer userId) {
        return cardService.deleteCardByUserId(userId);
    }

    @GetMapping("/list/userIds")
    public List<Integer> ids() {
        return cardService.getAllUserIds();
    }


}
