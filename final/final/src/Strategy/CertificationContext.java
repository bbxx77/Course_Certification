package Strategy;

public class CertificationContext implements Certification{
    public Skill[] skills;
    public String disc;

    public CertificationContext(String disc, Skill ...skills) {
        this.skills = skills;
        this.disc = disc;
    }

    @Override
    public String getCertificationDetails() {
        String allSkills = "Skills: ";
        for(Skill skill: this.skills){
            allSkills += skill.applySkill() + " ; ";
        }
        return allSkills + " Description: " + disc;
    }

    public void getCertification() {
        String allSkills = "Skills: ";
        for(Skill skill: this.skills){
            allSkills += skill.applySkill() + " ; ";
        }
        System.out.println(allSkills + " ; Description: " + disc);
    }
}
