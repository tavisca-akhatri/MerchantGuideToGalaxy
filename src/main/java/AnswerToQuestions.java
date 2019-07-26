import java.util.HashMap;

public class AnswerToQuestions
{
    static public HashMap<String,Double> map = new HashMap<>();
    public void StoreInMap(String entity, double value)
    {
        map.put(entity,value);
    }
    public double getAnswer(String s,WordToRoman romanNumber)
    {
        String[] output = s.split("is ");
        String result[] = output[1].split(" ");
        RomanToNumber r = new RomanToNumber();
        String roman ="";
        double answer = 0;
        if(s.contains("how much"))
        {
            for(int i = 0 ; i < result.length-1 ; i++)
            {
                roman += romanNumber.getRoman(result[i]);
            }
            answer = r.getArithmeticNumber(roman);
        }
        else if(s.contains("how many"))
        {
            double x = map.get(result[result.length-2]);
            for(int i = 0 ; i < result.length-2 ; i++)
            {
                roman += romanNumber.getRoman(result[i]);
            }
            double y = r.getArithmeticNumber(roman);
            answer = x*y;
        }
        return answer;
    }
}
