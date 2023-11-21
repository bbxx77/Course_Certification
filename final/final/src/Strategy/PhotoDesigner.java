package Strategy;

import Strategy.Skill;

public class PhotoDesigner implements Skill {
    @Override
    public String applySkill() {
        return "with Photo design skill!";
    }
}