package uk.phsh.binaryheap;
import org.junit.Before;
import org.junit.Test;
import uk.phsh.binaryheap.data.Ticket;
import static org.junit.Assert.*;

public class TestTicket {

    Ticket _ticket;
    long _timeCreated;

    @Before
    public void setUp() {
        _timeCreated = System.currentTimeMillis() / 1000;
        _ticket = new Ticket(Ticket.getNewId(), "Peter Blackburn", (byte)3, "Peter Blackburn's ticket test");
    }

    @Test
    public void testGetUniqueIdentifier() {
        assertEquals(Ticket.getCurrentId(), _ticket.getUniqueIdentifier());
    }

    @Test
    public void testGetCreatedTimestamp() {
        assertEquals(_timeCreated, _ticket.getCreatedTimestamp());
    }

    @Test
    public void testGetCreatorName() {
        assertEquals("Peter Blackburn", _ticket.getCreatorName());
    }

    @Test
    public void testGetPriority() {
        assertEquals((byte)3, _ticket.getPriority());
    }

}
