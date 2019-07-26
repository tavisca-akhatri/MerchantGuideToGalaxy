public class Parser1
{
    public String[] wordParser(String input)
    {
          WordToRoman roman = new WordToRoman();
          String[] output = input.split(" ");
          String[] words = new String[]{output[0],output[2]};
          roman.StoreInHashMap(words);
          return words;
    }
}
