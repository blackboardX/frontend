package sample.model;

import java.util.List;

public class Skill {

    private final int id;
    private String name;
    private List<Integer> children;

    public Skill(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getChildren() {
        return children;
    }

    public void setChildren(List<Integer> children) {
        this.children = children;
    }

    public void makeChild(int index) {
        children.add(index);
    }
}
