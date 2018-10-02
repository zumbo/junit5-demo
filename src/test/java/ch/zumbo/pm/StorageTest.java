package ch.zumbo.pm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StorageTest {
    private Storage storage;

    @BeforeEach
    void init() {
        storage = new Storage();
    }

    @RepeatedTest(3)
    void testStorage() {
        String testData = "Hello World!";
        storage.setData(testData);
        assertEquals(testData, storage.getData());
    }

    @Test
    void testException() {
        String testData = "Hello World!";
        storage.setData(testData);
        assertThrows(RuntimeException.class, () -> storage.setData(testData));
    }
}
