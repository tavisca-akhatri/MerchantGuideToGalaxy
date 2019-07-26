import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MerchantGalaxyTest
{
    @Test
    void canParseWordToRomanNumeral()
    {
        Parser1 m = new Parser1();
        assertArrayEquals(new String[]{"glob","I"},m.wordparse("glob is I"));
        assertArrayEquals(new String[]{"prok","V"},m.wordparse("prok is V"));
        assertArrayEquals(new String[]{"pish","X"},m.wordparse("pish is X"));
        assertArrayEquals(new String[]{"tegj","L"},m.wordparse("tegj is L"));
    }

   @Test
   void canParseSentenceToWords()
   {
       Parser2 p = new Parser2();
       assertArrayEquals(new String[]{"glob","glob","Silver","34"},p.sentenceparse("glob glob Silver is 34 Credits"));
       assertArrayEquals(new String[]{"glob","prok","Gold","57800"},p.sentenceparse("glob prok Gold is 57800 Credits"));
       assertArrayEquals(new String[]{"pish","pish","Iron","3910"},p.sentenceparse("pish pish Iron is 3910 Credits"));

   }

   @Test
    void canParseMuchToWords()
   {
       Parser2 p = new Parser2();
       assertArrayEquals(new String[]{"pish","tegj","glob","glob"},p.questionparse("how much is pish tegj glob glob ?"));
   }

   @Test
    void canParseManyToWords()
   {
       Parser2 p = new Parser2();
       assertArrayEquals(new String[]{"glob","prok","Silver"},p.questionparse("how many Credits is glob prok Silver ?"));
       assertArrayEquals(new String[]{"glob","prok","Gold"},p.questionparse("how many Credits is glob prok Gold ?"));
       assertArrayEquals(new String[]{"glob","prok","Iron"},p.questionparse("how many Credits is glob prok Iron ?"));
   }

   @Test
    void canParseUselessMessageToWords()
   {
       Parser2 p = new Parser2();
       assertArrayEquals(new String[]{"I have no idea what you are talking about"},p.questionparse("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
   }

   @Test
    void canConvertWordsIntoRomanNumerals()
   {
      Parser1 p = new Parser1();
      p.wordparse("glob is I");
      p.wordparse("prok is V");
      p.wordparse("pish is X");
      p.wordparse("teqj is L");
      WordToRoman w = new WordToRoman();
      assertEquals("II" , w.getRoman("glob glob"));
      assertEquals("IV",w.getRoman("glob prok"));
      assertEquals("XX",w.getRoman(("pish pish")));
   }

   @Test
    void canConvertSingleRomanNumeralsIntoNumbers()
   {
       RomanToNumber r = new RomanToNumber();
       assertEquals(5, r.getArithmeticNumber("V"));
       assertEquals(10, r.getArithmeticNumber("X"));
       assertEquals(50, r.getArithmeticNumber("L"));
       assertEquals(100, r.getArithmeticNumber("C"));
   }

   @Test
    void canConvertAnyRomanNumeralsIntoNumbers()
   {
       RomanToNumber r = new RomanToNumber();
       assertEquals(2006,r.getArithmeticNumber("MMVI"));
       assertEquals(1944,r.getArithmeticNumber("MCMXLIV"));
       assertEquals(1903,r.getArithmeticNumber("MCMIII"));
   }

   @Test
    void canFindTheValueOfTheRequiredEntity()
   {
       Credits c =  new Credits();
       Parser1 p = new Parser1();
       p.wordparse("glob is I");
       p.wordparse("prok is V");
       p.wordparse("pish is X");
       p.wordparse("teqj is L");
       //Parser2 p1 = new Parser2();
       //p1.wordparse("glob prok Gold is 57800 Credits");
       assertEquals(17,c.getCredits("glob glob Silver is 34 Credits  "));
       assertEquals(14450,c.getCredits("glob prok Gold is 57800 Credits "));
       assertEquals(195.5,c.getCredits("pish pish Iron is 3910 Credits  "));
   }

   @Test
   void canCalculateMuchQuestions()
   {
       AnswerToQuestions answer = new AnswerToQuestions();
       Parser1 p = new Parser1();
       p.wordparse("glob is I");
       p.wordparse("prok is V");
       p.wordparse("pish is X");
       p.wordparse("tegj is L");
       assertEquals(42, answer.getAnswer("how much is pish tegj glob glob ?"));
   }

   @Test
    void canCalculateManyQuestions()
   {
       AnswerToQuestions answer = new AnswerToQuestions();
       Parser1 p = new Parser1();
       p.wordparse("glob is I");
       p.wordparse("prok is V");
       p.wordparse("pish is X");
       p.wordparse("tegj is L");
       Credits c = new Credits();
       c.getCredits("glob glob Silver is 34 Credits  ");
       assertEquals(68,answer.getAnswer("how many Credits is glob prok Silver ?"));
       c.getCredits("glob prok Gold is 57800 Credits ");
       assertEquals(57800,answer.getAnswer("how many Credits is glob prok Gold ?"));
       c.getCredits("pish pish Iron is 3910 Credits ");
       assertEquals(782,answer.getAnswer("how many Credits is glob prok Iron ?"));
   }

}
