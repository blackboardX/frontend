package sample.model;

import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.parser.JSONParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Decomposition {
    private List<Skill> skills = new ArrayList<Skill>();

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public int skillsSize() {
        return skills.size();
    }

    public void makeChild(int parentIndex, int childIndex) {
        skills.get(parentIndex).makeChild(childIndex);
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public Decomposition() {

    }
}
