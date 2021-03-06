package Entities;

public class EntityFactory {
    private static EntityFactory instance;

    public static EntityFactory getInstance(){
        if(instance == null)
            instance = new EntityFactory();
        return instance;
    }

    public Entity createEntity(String type){
        switch(type){
            case "sprite":
                return new Sprite();
            case "card":
                return new Card();
            case "correctCard":
                return new CorrectCard();
        }
        return null;
    }

}
