package main.java.edu.metrostate.oodi.hotel;

import java.time.LocalDateTime;

public class Stay {

    private final LocalDateTime startedAt;
    private LocalDateTime endedAt;

    public Stay(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public LocalDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }
}
