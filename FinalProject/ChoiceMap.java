/**
 * Alexandra Kerans and Brianna Bukowski
 * 1 May 2019
 * Choice Map Class
 * Can make objects that have a map that stores all the story choices
 */
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

public class ChoiceMap
{
    Map<Integer, Integer[]> choices;  
    
    /**
     * user enters an array of integers (key choices)
     * and an array of arrays [1, 2] (the two choices a user can choose at a certain choice
     */
    public ChoiceMap(int[] keys)
    {
        
    }
}
