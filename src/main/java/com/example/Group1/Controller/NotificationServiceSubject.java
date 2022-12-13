package com.example.Group1.Controller;

import com.example.Group1.Bean.Event;

import java.util.*;

public class NotificationServiceSubject {
    private final Map<Event, List<String>> observers;

    public NotificationServiceSubject() {
        observers = new HashMap<>();
        Arrays.stream(Event.values()).forEach(event -> observers.put(event, new ArrayList<>()));
    }

    public void subscribe(Event eventType, List listener) {
        for (int i = 0; i < listener.size(); i++) {
            observers.get(eventType).add((String) listener.get(i));

        }
    }

    public void unsubscribe(Event eventType, IListener listener) {
        observers.get(eventType).remove(listener);
    }

}
