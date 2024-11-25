package io.github.dawnglow.stackture.stacktureapi.repository;

import io.github.dawnglow.stackture.stacktureapi.domain.TechStack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class StackRepository {
    private final Map<Long, TechStack> store = new HashMap<>();

    private long sequence = 0L;

    public TechStack save(TechStack techStack) {
        techStack.setId(++sequence);
        store.put(techStack.getId(), techStack);
        return techStack;
    }

    public TechStack findById(Long id) {
        return store.get(id);
    }

    public List<TechStack> findAll() {
        return new ArrayList<>(store.values());
    }
}
