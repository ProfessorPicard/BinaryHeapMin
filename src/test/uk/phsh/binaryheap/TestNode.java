package uk.phsh.binaryheap;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import uk.phsh.binaryheap.data.Node;
import uk.phsh.binaryheap.data.Ticket;

public class TestNode {
    Node<Ticket> _node;
    Ticket _ticket;

    @Before
    public void setup() {
        _ticket = new Ticket(Ticket.getNewId(), "Peter Blackburn", (byte)3, "Peter Blackburn's ticket test");
        _node = new Node<>(_ticket, (byte)3);
    }

    @Test
    public void testElementData() {
        Ticket t = _node.getElement();
        assertNotNull(t);
        assertEquals("Peter Blackburn", t.getCreatorName());
        assertEquals((byte)3, t.getPriority());
    }
}
