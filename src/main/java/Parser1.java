public class Parser1
{

    public String[] wordparse(String input)
    {
          WordToRoman roman = new WordToRoman();
          String[] output = input.split(" ");
         // map.put(split[0],split[2]);
          String[] words = new String[]{output[0],output[2]};
          roman.StoreInHashMap(words);
          return words;
    }

}
