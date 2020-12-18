package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.domain.TicketsComparatorByTravelTime;
import ru.netology.domain.TicketsItem;
import ru.netology.repository.TicketsItemRepository;

@AllArgsConstructor
@Data
public class TicketsItemManager {
    private TicketsItemRepository repository;

    public void add(TicketsItem item) {
        repository.add(item);
    }

    public TicketsItem[] findAll(String from, String to) {
        TicketsComparatorByTravelTime comparator = new TicketsComparatorByTravelTime();
        return repository.getAll(from, to, comparator);
    }
}
