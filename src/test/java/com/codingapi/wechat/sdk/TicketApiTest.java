package com.codingapi.wechat.sdk;

import com.codingapi.wechat.sdk.cgibin.api.TicketApi;
import com.codingapi.wechat.sdk.cgibin.model.ticket.Ticket;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@ActiveProfiles(value = "dev")
class TicketApiTest {

    @Autowired
    private TicketApi ticketApi;

    @Test
    void getTicket() {
        Ticket ticket = ticketApi.getTicket();
        assertFalse(ticket.isExpire());
        assertNotNull(ticket.getTicket());
        System.out.println(ticket.getTicket());
    }
}