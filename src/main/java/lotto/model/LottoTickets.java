package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoTickets {
    private List<Lotto> tickets = new ArrayList<>();

    public void addTicket(Lotto ticket) {
        tickets.add(ticket);
    }

    public List<Lotto> getTickets() {
        return tickets;
    }
}
