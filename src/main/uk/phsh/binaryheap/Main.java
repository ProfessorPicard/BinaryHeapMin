package uk.phsh.binaryheap;

import uk.phsh.binaryheap.collection.BinaryHeapMin;
import uk.phsh.binaryheap.data.Ticket;

public class Main {
    public static void main(String[] args) {
        BinaryHeapMin<Ticket> binaryHeapMin = new BinaryHeapMin<>();
        Ticket t1 = new Ticket(Ticket.getNewId(), "Chloe", (byte) 3, "Chloe's Ticket");
        binaryHeapMin.insert(t1, t1.getPriority());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Ticket t2 = new Ticket(Ticket.getNewId(), "Pete", (byte) 1, "Pete's Ticket");
        binaryHeapMin.insert(t2, t2.getPriority());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Ticket t3 = new Ticket(Ticket.getNewId(), "Eli", (byte) 2, "Eli's Ticket");
        binaryHeapMin.insert(t3, t3.getPriority());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Ticket t4 = new Ticket(Ticket.getNewId(), "Sophie", (byte) 1, "Sophie's Ticket");
        binaryHeapMin.insert(t4, t4.getPriority());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Ticket t5 = new Ticket(Ticket.getNewId(), "Aimee", (byte) 4, "Aimee's Ticket");
        binaryHeapMin.insert(t5, t5.getPriority());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Ticket t6 = new Ticket(Ticket.getNewId(), "Jay", (byte) 2, "Jay's Ticket");
        binaryHeapMin.insert(t6, t6.getPriority());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        binaryHeapMin.prettyString();
        System.out.println("Size: " + binaryHeapMin.size());
        System.out.println("Minimum Node: " + binaryHeapMin.getRoot());
        System.out.println("Contains Pete?: " + binaryHeapMin.contains(t2.getUniqueIdentifier()));
        binaryHeapMin.removeRoot();
        binaryHeapMin.prettyString();
        System.out.println("Size: " + binaryHeapMin.size());
        System.out.println("Minimum Node: " + binaryHeapMin.getRoot());
        System.out.println("Contains Pete?: " + binaryHeapMin.contains(t2.getUniqueIdentifier()));
    }


}