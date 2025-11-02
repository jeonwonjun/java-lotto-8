package lotto.domain.entity;

import java.util.ArrayList;
import java.util.List;
import lotto.util.RandomNumbers;

public class LottoTickets {
    private List<RandomNumbers> tickets = new ArrayList<>();

    public void addTicket(RandomNumbers ticket) {
        tickets.add(ticket);
    }

    public List<RandomNumbers> getTickets() {
        return tickets;
    }
}
