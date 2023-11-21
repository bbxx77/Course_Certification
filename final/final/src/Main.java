/*import Decorator.JavaCertification;
import Decorator.PhotoCertification;*/
import Adapter.AdapterCertification;
import Decorator.*;
import User.User;
import Factory.DesignerFactory;
import Factory.DeveloperFactory;
import Factory.ProfessionalFactory;
import Observer.Editor;
import Strategy.Certification;
import Strategy.CertificationContext;
import Strategy.Skill;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private  static ProfessionalFactory prof;
    public static void main(String[] args) throws SQLException {
        User user = User.createUserIns();
        Editor editor = new Editor();
        editor.events.subscribe("Designer", "kamila");
        Scanner scanner = new Scanner(System.in);
        ArrayList<CertificationContext> cf = new ArrayList<CertificationContext>();
        String[] skills = null;
        while (true){
            System.out.println("Enter description");
            String disc = scanner.nextLine();
            System.out.println("Enter the professional (type 'exit' to quit):");
            skills = scanner.nextLine().split(", ");
            if(skills[0].equals("exit")){
                break;
            }
            Skill[] cl = new Skill[skills.length];
            for(int i = 0; i < skills.length; i++){
                cl[i] = createByJob(skills[i]);
            }
            try {
                CertificationContext current = new CertificationContext( disc, cl);
                cf.add(current);
                current.getCertification();
            } catch (RuntimeException e) {
                System.out.println("Invalid input. Please enter 'Developer' or 'Designer'.");
            }
        }

        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter surname");
        String surname = scanner.nextLine();
        System.out.println("Способы отправки");
        String[] methods = scanner.nextLine().split(", ");
        Resume res = new BaseResume();
        if(!name.equals("")){
            res = new Name(name, res);
        }
        if(!surname.equals("")){
            res = new Surname(surname, res);
        }
        res = new DecorCertification(new AdapterCertification(cf), res);
        editor.addRes(res.getResume());
        System.out.println(res.getResume());
        scanner.close();

    }
    static Skill createByJob(String skill) {
        if(skill.equalsIgnoreCase("Java") || skill.equalsIgnoreCase("Python")){
            prof = new DeveloperFactory();
        }
        else if(skill.equalsIgnoreCase("Photo") || skill.equalsIgnoreCase("Video")){
            prof = new DesignerFactory();
        }
        else{
            throw new RuntimeException("error");
        }
        return prof.createSkill(skill);
    }
}