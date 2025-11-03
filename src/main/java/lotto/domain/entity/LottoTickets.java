package lotto.domain.entity;

import java.util.ArrayList;
import java.util.List;
import lotto.util.RandomNumbers;

public class LottoTickets {
    private List<Lotto> tickets = new ArrayList<>();

    public void addTicket(Lotto ticket) {
        tickets.add(ticket);
    }

    public List<Lotto> getTickets() {
        return tickets;
    }
}
