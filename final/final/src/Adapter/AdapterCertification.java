package Adapter;

import Strategy.Certification;
import Strategy.CertificationContext;
import Strategy.Skill;

import java.util.ArrayList;

public class AdapterCertification implements Certification {
    ArrayList<CertificationContext> allCert;
    public AdapterCertification(ArrayList<CertificationContext> allCert){
        this.allCert = allCert;
    }

    @Override
    public String getCertificationDetails() {
        String allSkills = "Skills: ";
        ArrayList<Skill> skills =new ArrayList<>();
        ArrayList<String> disc = new ArrayList<>();
        for(CertificationContext cert: this.allCert){
            disc.add(cert.disc);
            for(Skill sk: cert.skills){
                if(!skills.contains(sk)){
                    skills.add(sk);
                    allSkills += sk.applySkill() + " ; ";
                }
            }
        }
        return allSkills + " Description: " + (disc != null ? disc.toString() : null);
    }

    @Override
    public void getCertification() {
        String allSkills = "Skills: ";
        ArrayList<Skill> skills = null;
        ArrayList<String> disc = null;
        for(CertificationContext cert: this.allCert){
            disc.add(cert.disc);
            for(Skill sk: cert.skills){
                if(!skills.contains(sk)){
                    skills.add(sk);
                    allSkills += sk.applySkill() + " ; ";
                }
            }
        }
        System.out.println(allSkills + " Description: " + (disc != null ? disc.toString() : null));
    }
}
