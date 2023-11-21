package Decorator;

public class Surname implements Resume{
    String surname;
    Resume res;
    public Surname(String surname, Resume res){
        this.surname = surname;
        this.res = res;
    }

    @Override
    public String getResume(){
        return res.getResume() +  "Surname: " + surname + "\n";
    }

    @Override
    public String getConcrete() {
        return surname;
    }

    @Override
    public Resume getRes() {
        return res;
    }
}
