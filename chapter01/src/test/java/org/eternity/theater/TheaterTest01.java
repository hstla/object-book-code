package org.eternity.theater;

import org.eternity.theater.step01.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


class TheaterTest01 {

    @Test
    public void 입장_성공_테스트() throws Exception {
        //given
        Ticket ticket = new Ticket(5000L);
        TicketOffice ticketOffice = new TicketOffice(10000L, ticket);
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        Theater theater = new Theater(ticketSeller);
        Bag bag = new Bag(10000);
        Audience audience = new Audience(bag);

        //when
        theater.enter(audience);
        //then
        assertThat(bag.getAmount()).isEqualTo(5000);
    }

    @Test
    public void 초대장_입장_성공() throws Exception {
        //given



        //when

        //then

    }
}