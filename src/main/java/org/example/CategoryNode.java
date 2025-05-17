package org.example;

import java.util.ArrayList;
import java.util.List;

class CategoryNode {
    int id;
    String name;
    List<CategoryNode> children = new ArrayList<>();

    public CategoryNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter
    public int getId() { return id; }
    public String getName() { return name; }
    public List<CategoryNode> getChildren() { return children; }
}