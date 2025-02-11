package uk.phsh.binaryheap.data;

import uk.phsh.binaryheap.interfaces.I_NodeElement;

public class Ticket implements I_NodeElement {

    private static long _currentId = 0;
    public static long getNewId() {
        _currentId++;
        return _currentId;
    }

    public static long getCurrentId() { return _currentId; }

    long uniqueId;
    String creatorName;
    String ownerName;
    byte priority;
    long createdTimestamp;
    long solvedTimestamp;
    boolean solved;
    String description;

    public Ticket(long uniqueId) {
        this(uniqueId, "", (byte)-1, "");
    }

    public Ticket(long uniqueId, String creatorName, byte priority, String description) {
        this.uniqueId = uniqueId;
        this.creatorName = creatorName;
        this.priority = priority;
        this.description = description;
        this.createdTimestamp = System.currentTimeMillis() / 1000;
    }

    public long getUniqueId() { return uniqueId; }

    public String getCreatorName() { return creatorName; }
    public void setCreatorName(String creatorName) { this.creatorName = creatorName; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public byte getPriority() { return priority; }
    public void setPriority(byte priority) { this.priority = priority; }

    public long getCreatedTimestamp() { return createdTimestamp; }

    public long getSolvedTimestamp() { return solvedTimestamp; }
    public void setSolvedTimestamp(long solvedTimestamp) { this.solvedTimestamp = solvedTimestamp; }

    public boolean isSolved() { return solved; }
    public void setSolved(boolean solved) { this.solved = solved; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Ticket [uniqueId=" + uniqueId + ", creatorName=" + creatorName + ", ownerName=" +
                ownerName + ", priority=" + priority + ", createdTimestamp=" +
                createdTimestamp + ", description=" + description + ", solvedTimestamp=" + solvedTimestamp + ", solved=" + solved + "]";
    }

    @Override
    public long getTimeCreated() {
        return createdTimestamp;
    }

    @Override
    public long getUniqueIdentifier() {
        return uniqueId;
    }
}
