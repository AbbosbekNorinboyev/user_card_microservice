package uz.pdp.card_service.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "USER-SERVICE")
public interface UserClient {
    @GetMapping("/api/users/ids/list")
    List<Integer> getIds();
}
