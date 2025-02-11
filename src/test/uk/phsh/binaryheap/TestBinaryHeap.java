package uk.phsh.binaryheap;

import org.junit.Before;
import org.junit.Test;
import uk.phsh.binaryheap.collection.BinaryHeapMin;
import uk.phsh.binaryheap.data.Ticket;
import static org.junit.Assert.*;

public class TestBinaryHeap {
    BinaryHeapMin<Ticket> _ticketHeap;
    Ticket _ticket;

    @Before
    public void setUp() {
        _ticketHeap = new BinaryHeapMin<>();
        _ticket = new Ticket(Ticket.getNewId(), "Peter Blackburn", (byte)3, "Peter Blackburn's ticket test");
    }

    private void insertTestTicket() {
        _ticketHeap.insert(_ticket, (byte)3);
    }

    @Test
    public void testSize() {
        _ticketHeap.clear();
        assertEquals(0, _ticketHeap.size());
        addTestItems();
        assertEquals(4, _ticketHeap.size());
    }

    @Test
    public void testClear() {
        addTestItems();
        _ticketHeap.clear();
        assertEquals(0, _ticketHeap.size());
    }

    @Test
    public void testInsert() {
        _ticketHeap.clear();
        assertEquals(0, _ticketHeap.size());
        insertTestTicket();
        assertEquals(1, _ticketHeap.size());
    }

    @Test
    public void testGetMin() {
        addTestItems();
        assertEquals(0, _ticketHeap.getMin().getPriority());
    }

    @Test
    public void testRemoveMin() {
        addTestItems();
        assertNotNull(_ticketHeap.getMin());
        assertEquals(0, _ticketHeap.getMin().getPriority());
        assertEquals(4, _ticketHeap.size());
        _ticketHeap.removeMin();
        assertEquals(1, _ticketHeap.getMin().getPriority());
        assertEquals(3, _ticketHeap.size());
    }

    @Test
    public void testContains() {
        addTestItems();
        assertTrue(_ticketHeap.contains(Ticket.getCurrentId()));
        assertFalse(_ticketHeap.contains(4784349));
    }

    private void addTestItems() {
        assertNotNull(_ticketHeap);
        _ticketHeap.clear();
        assertEquals(0, _ticketHeap.size());
        for(int i = 0; i < 4; i++) {
            Ticket t = new Ticket(Ticket.getNewId(), "Name " + i, (byte)i, "Description " + i);
            _ticketHeap.insert(t, (byte)i);
        }
    }
}
