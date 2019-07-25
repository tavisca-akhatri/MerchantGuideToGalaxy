public class Parser
{

    public String[] parse(String input)
    {
          WordToRoman r = new WordToRoman();
          String[] output = input.split(" ");
         // map.put(split[0],split[2]);
          String[] words = new String[]{output[0],output[2]};
          r.StoreInHashMap(words);
          return words;
    }

}
