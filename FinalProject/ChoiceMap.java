/**
 * Alexandra Kerans and Brianna Bukowski
 * 1 May 2019
 * Choice Map Class
 * Can make objects that have a map that stores all the story choices
 */

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/*MAP NOTES
 *     key value, collection value (only stores objects)
 * Map<String,    Integer          > myMap = new Map<>(); <-- making a map
 * myMap.put("Bob", 12); <--- adding new keys and values
 * myMap.put("Bob", 5); <--- modifying an existing key's values
 * myMap.get("Bob"); <--- returns the value associated with the key
 * myMap.remove("Bob"); <--- removes the key and values associated with it
 * 
 * for(String key : myMap.keySet()) <--- for every key all the keys (.keySet() returns a list of the keys)
 * {
 *     myMap.get(key); <--- get the value associated with the key
 *     }
 */

/*
 * Planning
 * Methods Needed
 * - set the current key choice
 * - get the current key choice
 * - get the choices associated with the key
 */
public class ChoiceMap
{
    //current key choice the player is on
    private int curKey;
    
    //list of all keys
    private int[] keys;
    
    //list of all values associated with the keys
    private int[][] keyVals;
    
    Map<Integer, int[]> choices = new HashMap<Integer, int[]>();  
    
    /**
     * user enters an array of integers (key choices)
     * and an array of arrays [1, 2] (the two choices a user can choose at a certain choice
     */
    public ChoiceMap(int[] k, int[][] kV)
    {
        keys = k;
        keyVals = kV;
        curKey = keys[0];
        
        //putting the keys and values into the map
        for(int i = 0; i < keys.length; i++)
        {
            choices.put(keys[i], keyVals[i]);
        }
    }
    
    //SETTERS
    /**
     * sets the current key choice
     */
    public void setKey(int newKey)
    {
        curKey = newKey;
    }
    
    
    //GETTERS
    /**
     * gets the current key choice
     */
    public int getKey()
    {
        return curKey;
    }
    
    /**
     * gets the choices associated with the current key
     */
    public int[] getKeyValues()
    {
        return choices.get(curKey);
    }
}
