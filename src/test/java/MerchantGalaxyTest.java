import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MerchantGalaxyTest
{
    @Test
    void canParseWordToRomanNumeral()
    {
        Parser1 parsedWord = new Parser1();
        assertArrayEquals(new String[]{"glob","I"},parsedWord.wordParser("glob is I"));
        assertArrayEquals(new String[]{"prok","V"},parsedWord.wordParser("prok is V"));
        assertArrayEquals(new String[]{"pish","X"},parsedWord.wordParser("pish is X"));
        assertArrayEquals(new String[]{"tegj","L"},parsedWord.wordParser("tegj is L"));
    }

   @Test
   void canParseSentenceToWords()
   {
       Parser2 parseSentence = new Parser2();
       assertArrayEquals(new String[]{"glob","glob","Silver","34"}, parseSentence.sentenceParser("glob glob Silver is 34 Credits"));
       assertArrayEquals(new String[]{"glob","prok","Gold","57800"},parseSentence.sentenceParser("glob prok Gold is 57800 Credits"));
       assertArrayEquals(new String[]{"pish","pish","Iron","3910"}, parseSentence.sentenceParser("pish pish Iron is 3910 Credits"));

   }

   @Test
    void canParseMuchToWords()
   {
       Parser2 muchSentence = new Parser2();
       assertArrayEquals(new String[]{"pish","tegj","glob","glob"},muchSentence.questionParser("how much is pish tegj glob glob ?"));
   }

   @Test
    void canParseManyToWords()
   {
       Parser2 manySentence = new Parser2();
       assertArrayEquals(new String[]{"glob","prok","Silver"},manySentence.questionParser("how many Credits is glob prok Silver ?"));
       assertArrayEquals(new String[]{"glob","prok","Gold"},manySentence.questionParser("how many Credits is glob prok Gold ?"));
       assertArrayEquals(new String[]{"glob","prok","Iron"},manySentence.questionParser("how many Credits is glob prok Iron ?"));
   }

   @Test
    void canParseUselessMessageToWords()
   {
       Parser2 errorSentence = new Parser2();
       assertArrayEquals(new String[]{"I have no idea what you are talking about"},errorSentence.questionParser("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
   }

   @Test
    void canConvertWordsIntoRomanNumerals()
   {
      Parser1 parsedWord  = new Parser1();
      parsedWord.wordParser("glob is I");
      parsedWord.wordParser("prok is V");
      parsedWord.wordParser("pish is X");
      parsedWord.wordParser("teqj is L");
      WordToRoman romanNumber = new WordToRoman();
      assertEquals("II" ,romanNumber.getRoman("glob glob"));
      assertEquals("IV",romanNumber.getRoman("glob prok"));
      assertEquals("XX",romanNumber.getRoman(("pish pish")));
   }

   @Test
    void canConvertSingleRomanNumeralsIntoNumbers()
   {
       RomanToNumber romanNumber = new RomanToNumber();
       assertEquals(5, romanNumber.getArithmeticNumber("V"));
       assertEquals(10,romanNumber.getArithmeticNumber("X"));
       assertEquals(50,romanNumber.getArithmeticNumber("L"));
       assertEquals(100,romanNumber.getArithmeticNumber("C"));
   }

   @Test
    void canConvertAnyRomanNumeralsIntoNumbers()
   {
       RomanToNumber romanNumber = new RomanToNumber();
       assertEquals(2006,romanNumber.getArithmeticNumber("MMVI"));
       assertEquals(1944,romanNumber.getArithmeticNumber("MCMXLIV"));
       assertEquals(1903,romanNumber.getArithmeticNumber("MCMIII"));
   }

   @Test
    void canFindTheValueOfTheRequiredEntity()
   {
       Credits credits =  new Credits();
       Parser1 parsedWord = new Parser1();
       parsedWord.wordParser("glob is I");
       parsedWord.wordParser("prok is V");
       parsedWord.wordParser("pish is X");
       parsedWord.wordParser("teqj is L");
       //Parser2 p1 = new Parser2();
       //p1.wordParser("glob prok Gold is 57800 Credits");
       assertEquals(17,credits.getCredits("glob glob Silver is 34 Credits  "));
       assertEquals(14450,credits.getCredits("glob prok Gold is 57800 Credits "));
       assertEquals(195.5,credits.getCredits("pish pish Iron is 3910 Credits  "));
   }

   @Test
   void canCalculateMuchQuestions()
   {
       AnswerToQuestions answer = new AnswerToQuestions();
       Parser1 parsedWord = new Parser1();
       parsedWord.wordParser("glob is I");
       parsedWord.wordParser("prok is V");
       parsedWord.wordParser("pish is X");
       parsedWord.wordParser("tegj is L");
       assertEquals(42, answer.getAnswer("how much is pish tegj glob glob ?"));
   }

   @Test
    void canCalculateManyQuestions()
   {
       AnswerToQuestions answer = new AnswerToQuestions();
       Parser1 parsedWord = new Parser1();
       parsedWord.wordParser("glob is I");
       parsedWord.wordParser("prok is V");
       parsedWord.wordParser("pish is X");
       parsedWord.wordParser("tegj is L");
       Credits credits = new Credits();
       credits.getCredits("glob glob Silver is 34 Credits  ");
       assertEquals(68,answer.getAnswer("how many Credits is glob prok Silver ?"));
       credits.getCredits("glob prok Gold is 57800 Credits ");
       assertEquals(57800,answer.getAnswer("how many Credits is glob prok Gold ?"));
       credits.getCredits("pish pish Iron is 3910 Credits ");
       assertEquals(782,answer.getAnswer("how many Credits is glob prok Iron ?"));
   }

   @Test
    void unitTest()
   {
       

   }

}
