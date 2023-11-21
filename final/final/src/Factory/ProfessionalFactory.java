package Factory;
import Strategy.Skill;
public abstract class ProfessionalFactory{

    public abstract Skill createSkill(String skill);
}