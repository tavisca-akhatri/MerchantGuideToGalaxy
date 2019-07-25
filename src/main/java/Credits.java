public class Credits
{
    public double getCredits(String s)
    {
        WordToRoman r = new WordToRoman();
        RomanToNumber number = new RomanToNumber();
        AnswerToQuestions answer = new AnswerToQuestions();
        String output[] = s.split("is ");
        String result[] = output[0].split(" ");
        String resultnumber[] = output[1].split(" ");
        String roman = "";
        for(int i = 0 ; i < 2 ; i++)
        {
            roman += r.getRoman(result[i]);
        }
        double num = number.getArithmeticNumber(roman);
        int total = Integer.parseInt(resultnumber[0]);
        double numberresult = total / num;
        answer.StoreInMap(result[result.length-1],numberresult);
        return numberresult;
    }
}
