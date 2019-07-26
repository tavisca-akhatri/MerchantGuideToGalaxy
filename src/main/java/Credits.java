public class Credits
{
    public double getCredits(String s, WordToRoman romanNumber)
    {

        RomanToNumber number = new RomanToNumber();
        AnswerToQuestions answer = new AnswerToQuestions();
        String output[] = s.split("is ");
        String result[] = output[0].split(" ");
        String resultnumber[] = output[1].split(" ");
        String roman = "";
        for(int i = 0 ; i < result.length-1 ; i++)
        {
            roman += romanNumber.getRoman(result[i]);
        }
        //System.out.println(roman);
        double num = number.getArithmeticNumber(roman);
        int total = Integer.parseInt(resultnumber[0]);
        double numberresult = total / num;
        answer.StoreInMap(result[result.length-1],numberresult);
        return numberresult;
    }
}
