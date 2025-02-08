package uz.pdp.card_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.card_service.entity.Card;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Integer> {
    @Query(value = "select c.id from card c", nativeQuery = true)
    List<Integer> getCardIds();

    @Query(value = "select c.userId from card c where c.userId = ?1", nativeQuery = true)
    Integer getUserId(Integer userId);

    @Transactional
    @Modifying
    @Query(value = "delete from card c where c.user_id = ?1", nativeQuery = true)
    void deleteCardByUserId(Integer userId);
}