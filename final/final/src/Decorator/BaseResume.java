package Decorator;

import java.util.Date;

public class BaseResume implements Resume{
    public BaseResume(){
    }
    @Override
    public String getResume(){
        return "Your resume\n";
    }

    @Override
    public String getConcrete() {
        return "Base";
    }

    @Override
    public Resume getRes() {
        return null;
    }
}
