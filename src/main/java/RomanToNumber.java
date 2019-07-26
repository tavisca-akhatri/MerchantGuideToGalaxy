import java.util.HashMap;

public class RomanToNumber
{
    public static HashMap<Character,Integer> map = new HashMap<>(){
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D',500);
            put('M',1000);
        }
    };
    public double getArithmeticNumber(String input)
    {
        double number = 0;
        if(input.length() == 1)
        {
            number = map.get(input.charAt(0));
            //System.out.println(number);
        }
        else {
            for(int i = 0 ; i < input.length()-1 ; i++) //II
            {
//                System.out.println(input);
//                System.out.println(map.get(input.charAt(i)));
                if(map.get(input.charAt(i)) < map.get(input.charAt(i+1)))
                {
                    number -= map.get(input.charAt(i));
                }
                else
                {
                    number += map.get(input.charAt(i));
                }
            }
            number += map.get(input.charAt(input.length()-1));
        }

        return number;
    }
}
