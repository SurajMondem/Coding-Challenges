import java.util.*;

@SuppressWarnings("WeakerAccess")
public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);  //System.in is a standard input stream
        System.out.print("Enter a string: ");
        String str= sc.next();   //reads string before the space
        System.out.println("Sorted Output: "+ occurrenceSort(str));
    }

    private static String occurrenceSort (String input){
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        LinkedHashMap<Integer, Integer> index = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();

        // Insert input into map (HashMap) in form of (Character, No. of Occurrence)<Character, Integer>
        for(int i = 0; i< input.length(); i++){
            if(map.containsKey(input.toLowerCase().charAt(i))){
                map.put(input.toLowerCase().charAt(i), map.get(input.toLowerCase().charAt(i)) + 1);
            }
            else{
                map.put(input.toLowerCase().charAt(i), 1);
            }
        }

        // Insert input into index (HashMap) in form of (Index, No. of Occurrence)<Integer, Integer>
        for(int i = 0; i< input.length(); i++){
                index.put(i, map.get(input.toLowerCase().charAt(i)));
        }

        // Program to Find the First Non-Repeating Character of the Input
        for(int i = 0; i< input.length(); i++){
            if(map.get(input.toLowerCase().charAt(i)) == 1){
                System.out.println("The First Non-Repeating Character of " + input + " is " + input.charAt(i));
                break; //Out of Loop as soon the first Character is found
            }
        }

        // Sorting the index (HashMap) by its value
        index.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(result ->  // appending to sb (StringBuilder) the index values of input String after Sort
                    {
                        int key = result.getKey();
                        sb.append(input.charAt(key));
                    }
                );

        return sb.toString();
    }
}
