import java.util.HashMap;

public class WordToRoman
{
    public static HashMap<String,String> map = new HashMap<>();
    public void StoreInHashMap(String[] input)
    {
        map.put(input[0],input[1]);
    }
    public String getRoman(String input)
    {
        String[] output = input.split(" ");
        String roman ="";
        for(String s : output)
        {
            roman+=map.get(s);
        }

        return roman;
    }
}
