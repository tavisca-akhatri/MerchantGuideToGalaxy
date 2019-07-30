public class wordparser
{
    public String[] wordParser(String input, WordToRoman roman)
    {
          String[] output = input.split(" ");
          String[] words = new String[]{output[0],output[2]};
          roman.StoreInHashMap(words);
          return words;
    }
}
