package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.domain.TicketsItem;
import ru.netology.repository.TicketsItemRepository;

import java.util.Arrays;
import java.util.Comparator;

@AllArgsConstructor
@Data
public class TicketsItemManager {
    private TicketsItemRepository repository;

    public void add(TicketsItem item){repository.add(item);}

    public TicketsItem[] findAll(String from, String to, Comparator<TicketsItem> comparator) {
        TicketsItem[] result = new TicketsItem[0];
        for(TicketsItem item : repository.getAll()) {
            if(item.getFrom().equalsIgnoreCase(from) && item.getTo().equalsIgnoreCase(to)) {
                TicketsItem[] tmp = new TicketsItem[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }
}