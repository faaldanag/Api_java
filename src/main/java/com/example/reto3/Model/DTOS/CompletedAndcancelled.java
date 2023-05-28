package com.example.reto3.Model.DTOS;

public class CompletedAndcancelled {
    private Long completed;
    private Long Cancelled;

    public CompletedAndcancelled(Long completed, Long cancelled) {
        this.completed = completed;
        Cancelled = cancelled;
    }

    public Long getCompleted() {
        return completed;
    }

    public void setCompleted(Long completed) {
        this.completed = completed;
    }

    public Long getCancelled() {
        return Cancelled;
    }

    public void setCancelled(Long cancelled) {
        Cancelled = cancelled;
    }
}
