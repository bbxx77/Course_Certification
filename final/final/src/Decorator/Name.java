package Decorator;

public class Name implements Resume{
    String name;
    Resume res;
    public Name(String name, Resume res){
        this.name = name;
        this.res = res;
    }
    @Override
    public String getResume(){
        return res.getResume() +  "Name: " + name + "\n";
    }

    @Override
    public String getConcrete() {
        return name;
    }

    @Override
    public Resume getRes() {
        return res;
    }
}
