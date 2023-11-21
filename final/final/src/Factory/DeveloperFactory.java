package Factory;
import Strategy.JavaDeveloper;
import Strategy.PythonDeveloper;
import Strategy.Skill;

public class DeveloperFactory extends ProfessionalFactory {
    @Override
    public Skill createSkill(String skill) {
        return skill.equals("Java") ?  new JavaDeveloper() : new PythonDeveloper();
    }
}