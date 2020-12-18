package ru.netology.domain;

import java.util.Comparator;

public class TicketsComparatorByTravelTime implements Comparator<TicketsItem> {
    public int compare(TicketsItem o1, TicketsItem o2) {
        return o1.getTravelTime() - o2.getTravelTime();
    }
}
