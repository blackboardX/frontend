package sample.model;

import javafx.util.Pair;

import java.util.*;

public class DecompositionBuilder {
    int rootId;
    LinkedList<Map<String, LinkedList<Map<String, String>>>> adjacencyList;
    String skillName;

    public int getRootId() {
        return rootId;
    }

    public void setRootId(int rootId) {
        this.rootId = rootId;
    }

    public LinkedList<Map<String, LinkedList<Map<String, String>>>> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(LinkedList<Map<String, LinkedList<Map<String, String>>>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Decomposition toDecomposition() {
        adjacencyList.sort((Map<String, LinkedList<Map<String, String>>> tm1,
                            Map<String, LinkedList<Map<String, String>>> tm2) -> {
            Integer key1 = Integer.parseInt((String) tm1.keySet().toArray()[0]);
            Integer key2 = Integer.parseInt((String) tm2.keySet().toArray()[0]);
            return key1.compareTo(key2);
        });

        Decomposition decomposition = new Decomposition();

        decomposition.addSkill(new Skill(rootId, skillName));

        for (Map<String, LinkedList<Map<String, String>>> adjacency : adjacencyList) {
            List<Integer> children = new ArrayList<>();

            for (Map<String, String> child : ((LinkedList<Map<String, String>>) adjacency.values().toArray()[0])) {
                Integer childId = Integer.parseInt(child.get("childId"));

                decomposition.addSkill(new Skill(
                        childId,
                        (String) child.values().toArray()[0]
                ));

                children.add(childId);
            }

            for (int i = 0; i < decomposition.skillsSize(); ++i) {
                if (decomposition.getSkills().get(i).getId()
                        == Integer.parseInt((String) adjacency.keySet().toArray()[0])) {
                    decomposition.getSkills().get(i).setChildren(children);
                }
            }
        }

        return decomposition;
    }
}
