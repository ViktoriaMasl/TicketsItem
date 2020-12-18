package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.TicketsItem;
import ru.netology.exception.NotFoundException;

import java.util.Arrays;
import java.util.Comparator;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketsItemRepository {
    private TicketsItem[] items = new TicketsItem[0];

    public void add(TicketsItem item) {
        int lenght = items.length + 1;
        TicketsItem[] tmp = new TicketsItem[lenght];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public TicketsItem[] getAll(String from, String to, Comparator<TicketsItem> comparator) {
        TicketsItem[] result = new TicketsItem[0];
        for (TicketsItem item : items) {
            if (item.getFrom().equalsIgnoreCase(from) && item.getTo().equalsIgnoreCase(to)) {
                TicketsItem[] tmp = new TicketsItem[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }

    TicketsItem findById(int id) {
        for (TicketsItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        TicketsItem result = findById(id);

        if (result == null) throw new NotFoundException("Element with id: " + id + " not found");
        int lenght = items.length - 1;
        TicketsItem[] tmp = new TicketsItem[lenght];
        int index = 0;
        for (TicketsItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;

    }
}
