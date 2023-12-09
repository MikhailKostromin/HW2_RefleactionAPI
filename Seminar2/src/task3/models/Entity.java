package task3.models;

import task3.Column;

import java.util.UUID;

public class Entity {
    @Column(name ="id", primeryKey = true)
    private UUID id;
}
