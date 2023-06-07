package collections;

import java.util.*;

public class SortHashMapByValues {
    public static void main(String[] args) {

        // create a map and store elements to it
        LinkedHashMap<String, Integer> capitals = new LinkedHashMap<>();
        capitals.put("Nepal", 2);
        capitals.put("India", 100);
        capitals.put("United States", 5);
        capitals.put("England", 10);
        capitals.put("Australia", 50);

        // call the sortMap() method to sort the map
        Map<String, Integer> result = sortMap(capitals);

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.print("Key: " + entry.getKey());
            System.out.println(" Value: " + entry.getValue());
        }
    }

    public static LinkedHashMap sortMap(LinkedHashMap map) {
        List capitalList = new LinkedList<>(map.entrySet());

        // call the sort() method of Collections
        Collections.sort(capitalList, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
            }
        });

        // create a new map
        LinkedHashMap linkedHashMap = new LinkedHashMap<>();

        for (Iterator it = capitalList.iterator(); it.hasNext();) {
            Map.Entry<String, Integer> entry =  (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }

        return linkedHashMap;
    }

    private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, final boolean order)
    {

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
