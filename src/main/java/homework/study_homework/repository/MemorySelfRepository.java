package homework.study_homework.repository;

import homework.study_homework.domain.Self;

import java.util.*;

public class MemorySelfRepository implements SelfRepository{

    private static Map<Long, Self> store = new HashMap<>();

    private static Long sequence = 1L;
    @Override
    public Self save(Self self) {
        self.setId(++sequence);
        store.put(self.getId(), self);
        return self;
    }


    @Override
    public Optional<Self> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Self> findByName(String name) {
        return store.values().stream()
                .filter(self -> self.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Self> findAll() {
        return new ArrayList<>(store.values());
    }
}
