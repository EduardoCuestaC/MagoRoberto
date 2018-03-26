package Entities;

import java.util.HashMap;

public class EntityFactory {
    private static EntityFactory instance;
    private HashMap<String, Entity> options =  new HashMap<>();

    public static EntityFactory getInstance(){
        if(instance == null)
            instance = new EntityFactory();
        return instance;
    }

    public Entity createEntity(String type){
        return options.getOrDefault(type, null);
    }


    private EntityFactory() {
        options.put("square", new Sprite());
    }
}
