package io.github.dawnglow.stackture.stacktureapi.service;

import io.github.dawnglow.stackture.stacktureapi.domain.TechStack;
import io.github.dawnglow.stackture.stacktureapi.repository.StackRepository;
import io.github.dawnglow.stackture.stacktureapi.utils.CsvParser;
import jakarta.annotation.PostConstruct;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StackService {
    private final StackRepository stackRepository;

    public List<TechStack> getTechStacks() {
        return stackRepository.findAll();
    }

    public TechStack getTechStack(Long id) {
        return stackRepository.findById(id);
    }

    public TechStack addTechStack(TechStack techStack) {
        return stackRepository.save(techStack);
    }

    @PostConstruct
    public void init() {
        CsvParser.getTechStacks().forEach(stackRepository::save);
    }
}
