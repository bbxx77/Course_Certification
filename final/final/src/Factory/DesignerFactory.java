package Factory;
import Strategy.*;
public class DesignerFactory extends ProfessionalFactory {
    @Override
    public Skill createSkill(String skill) {
        return skill.equals("Video") ?  new VideoDesigner() : new PhotoDesigner();
    }
}