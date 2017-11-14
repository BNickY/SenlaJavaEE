package com.senla.bookshop.utils;

import com.senla.bookshop.entities.Entity;
import java.util.Arrays;

public class ArrayWorker {
    private static final int EXPAND_VALUE = 2;
    public static final int START_SIZE = 10;

    //increments the array size in EXPAND_VALUE
    public static Entity[] expandArray(Entity[] entities){
        return Arrays.copyOf(entities, entities.length*EXPAND_VALUE);
    }

    //delete all null references
    public static Entity[] compressArray(Entity[] entities){
        int i, j;
        for(i = j = 0; j < entities.length; j++)
            if(!(entities[j] == null)) entities[i++] = entities[j];
        return Arrays.copyOf(entities,i);
    }

    //find entity in array by id
    public static Entity findById(Entity[] entities, long id){
        for (int i = 0; i < entities.length; i++){
            if(entities[i] != null && (entities[i].getId() == id))
                return entities[i];
        }
        return null;
    }

    //check array for empty space
    public static boolean hasEmptySpace(Entity[] entities) {
        for (Entity cook : entities) if (cook == null) return true;
        return false;
    }

    public static int getNextFreePosition(Entity[] entities) {
        for(int i = 0; i < entities.length; i++)
            if(entities[i] == null) return i;
        return -1;
    }
}