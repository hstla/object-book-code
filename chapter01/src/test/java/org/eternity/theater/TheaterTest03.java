package org.eternity.theater;

import org.eternity.theater.step03.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class TheaterTest03 {

    private Ticket ticket;
    private TicketOffice ticketOffice;
    private TicketSeller ticketSeller;
    private Theater theater;

    @BeforeEach
    void setUp() {
        ticket = new Ticket(5000L);
        ticketOffice = new TicketOffice(10000L, ticket);
        ticketSeller = new TicketSeller(ticketOffice);
        theater = new Theater(ticketSeller);
    }

    @Test
    void 초대장_없이_입장_테스트() {
        //given
        Bag bag = new Bag(10000L);
        Audience audience = new Audience(bag);

        //when
        theater.enter(audience);

        //then
        assertThat(bag.hasTicket()).isEqualTo(true);
    }

    @Test
    void 초대장으로_입장_테스트() {
        //given
        Bag bag = new Bag(10000L, new Invitation());
        Audience audience = new Audience(bag);

        //when
        theater.enter(audience);

        //then
        assertThat(bag.hasTicket()).isEqualTo(true);
    }
}