package ch.zumbo.pm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StorageTest {
    private Storage storage;

    @BeforeEach
    void init() {
        storage = new Storage();
    }

    @Test
    void testStorage() {
        String testData = "Hello World!";
        storage.setData(testData);
        assertEquals(testData, storage.getData());
    }

}
