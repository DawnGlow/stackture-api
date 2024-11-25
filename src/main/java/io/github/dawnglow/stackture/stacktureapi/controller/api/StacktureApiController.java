package io.github.dawnglow.stackture.stacktureapi.controller.api;

import io.github.dawnglow.stackture.stacktureapi.domain.TechStack;
import io.github.dawnglow.stackture.stacktureapi.service.StackService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StacktureApiController {
    private final StackService stackService;

    @GetMapping("/api/tech-stacks")
    public List<TechStack> getTechStacks() {
        // 미리 준비된 기술 스택 목록 반환
        return stackService.getTechStacks();
    }
}
