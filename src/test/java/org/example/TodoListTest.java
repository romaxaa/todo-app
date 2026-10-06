package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TodoListTest {

    @Test
    void addAndList() {
        TodoList t = new TodoList();
        t.add(" task1 ");
        assertEquals(1, t.size());
        assertEquals("task1", t.getAll().get(0));
    }

    @Test
    void remove() {
        TodoList t = new TodoList();
        t.add("a");
        t.add("b");
        assertTrue(t.remove(0));
        assertEquals(1, t.size());
        assertFalse(t.remove(10));
    }

    @Test
    void addEmptyIgnored() {
        TodoList t = new TodoList();
        t.add(" ");
        assertEquals(0, t.size());
    }

    @Test
    void clearList() {
        TodoList t = new TodoList();
        t.add("task");
        t.clear();
        assertEquals(0, t.size());
    }

    @Test
    void markDone() {
        TodoList t = new TodoList();
        t.add("buy bread");
        assertTrue(t.markDone(0));
        assertEquals("[DONE] buy bread", t.getAll().get(0));
    }

    @Test
    void searchTasks() {
        TodoList t = new TodoList();
        t.add("buy milk");
        t.add("wash car");
        List<String> found = t.search("milk");
        assertEquals(1, found.size());
        assertEquals("buy milk", found.get(0));
    }
}
