import java.util.HashMap;

public class WordToRoman
{
    private HashMap<String,String> map = new HashMap<>();
    public void StoreInHashMap(String[] input)
    {
        this.map.put(input[0],input[1]);
    }
    public String getRoman(String input)
    {
        String[] output = input.split(" ");
        String roman ="";
        for(String s : output)
        {
          //System.out.print(s);
            roman+=this.map.get(s);
        }
       //System.out.println(roman);
        return roman;
    }
}
