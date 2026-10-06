package org.example;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private final List<String> items = new ArrayList<>();

    public void add(String item) {
        if (item != null) {
            item = item.trim();
            if (!item.isEmpty()) {
                items.add(item);
            }
        }
    }

    public boolean remove(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            return true;
        }
        return false;
    }

    public List<String> getAll() {
        return new ArrayList<>(items);
    }

    public int size() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public boolean markDone(int index) {
        if (index >= 0 && index < items.size()) {
            String task = items.get(index);
            if (!task.startsWith("[DONE] ")) {
                items.set(index, "[DONE] " + task);
            }
            return true;
        }
        return false;
    }

    public List<String> search(String query) {
        List<String> result = new ArrayList<>();
        if (query == null || query.isBlank()) {
            return result;
        }
        for (String item : items) {
            if (item.toLowerCase().contains(query.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }
}
