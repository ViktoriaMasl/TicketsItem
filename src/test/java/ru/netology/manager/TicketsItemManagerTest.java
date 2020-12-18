package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketsItem;
import ru.netology.repository.TicketsItemRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketsItemManagerTest {
    private TicketsItemRepository repository = new TicketsItemRepository();
    private TicketsItemManager manager = new TicketsItemManager(repository);

    private TicketsItem first = new TicketsItem(1, 7000, "LED", "GOJ", 135);
    private TicketsItem second = new TicketsItem(2, 9500, "FRU", "OGZ", 180);
    private TicketsItem third = new TicketsItem(3, 4500, "LED", "GOJ", 90);
    private TicketsItem fourth = new TicketsItem(4, 6300, "IST", "OTP", 235);

    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    void shouldFindAllExist() {
        assertArrayEquals(new TicketsItem[]{third, first}, manager.findAll("LED", "GOJ"));
        assertArrayEquals(new TicketsItem[]{second}, manager.findAll("FRU", "OGZ"));
        assertArrayEquals(new TicketsItem[]{fourth}, manager.findAll("IST", "OTP"));
    }

    @Test
    void shouldFindAllNotExist() {
        assertArrayEquals(new TicketsItem[]{}, manager.findAll("FRU", "GOJ"));
    }


}