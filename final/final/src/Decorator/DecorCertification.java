package Decorator;

import Strategy.Certification;

public class DecorCertification implements Resume{
    Certification certification;
    Resume res;
    public DecorCertification(Certification certification, Resume res){
        this.certification = certification;
        this.res = res;
    }
    @Override
    public String getResume(){
        return res.getResume() +  "Certification: " + certification.getCertificationDetails() + "\n";
    }

    @Override
    public String getConcrete() {
        return certification.getCertificationDetails();
    }

    @Override
    public Resume getRes() {
        return res;
    }
}
