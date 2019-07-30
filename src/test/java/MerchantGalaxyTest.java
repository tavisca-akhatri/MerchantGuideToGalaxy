import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MerchantGalaxyTest
{
    @Test
    void canParseWordToRomanNumeral()
    {
        wordparser parsedWord = new wordparser();
        WordToRoman roman = new WordToRoman();
        assertArrayEquals(new String[]{"glob","I"},parsedWord.wordParser("glob is I",roman));
        assertArrayEquals(new String[]{"prok","V"},parsedWord.wordParser("prok is V",roman));
        assertArrayEquals(new String[]{"pish","X"},parsedWord.wordParser("pish is X",roman));
        assertArrayEquals(new String[]{"tegj","L"},parsedWord.wordParser("tegj is L",roman));
    }

   @Test
   void canParseSentenceToWords()
   {
       sentenceparser parseSentence = new sentenceparser();
       assertArrayEquals(new String[]{"glob","glob","Silver","34"}, parseSentence.sentenceParser("glob glob Silver is 34 Credits"));
       assertArrayEquals(new String[]{"glob","prok","Gold","57800"},parseSentence.sentenceParser("glob prok Gold is 57800 Credits"));
       assertArrayEquals(new String[]{"pish","pish","Iron","3910"}, parseSentence.sentenceParser("pish pish Iron is 3910 Credits"));

   }

   @Test
    void canParseMuchToWords()
   {
       sentenceparser muchSentence = new sentenceparser();
       assertArrayEquals(new String[]{"pish","tegj","glob","glob"},muchSentence.questionParser("how much is pish tegj glob glob ?"));
   }

   @Test
    void canParseManyToWords()
   {
       sentenceparser manySentence = new sentenceparser();
       assertArrayEquals(new String[]{"glob","prok","Silver"},manySentence.questionParser("how many Credits is glob prok Silver ?"));
       assertArrayEquals(new String[]{"glob","prok","Gold"},manySentence.questionParser("how many Credits is glob prok Gold ?"));
       assertArrayEquals(new String[]{"glob","prok","Iron"},manySentence.questionParser("how many Credits is glob prok Iron ?"));
   }

   @Test
    void canParseUselessMessageToWords()
   {
       sentenceparser errorSentence = new sentenceparser();
       assertArrayEquals(new String[]{"I have no idea what you are talking about"},errorSentence.questionParser("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
   }

   @Test
    void canConvertWordsIntoRomanNumerals()
   {
       WordToRoman roman = new WordToRoman();
      wordparser parsedWord  = new wordparser();
      parsedWord.wordParser("glob is I", roman);
      parsedWord.wordParser("prok is V", roman);
      parsedWord.wordParser("pish is X", roman);
      parsedWord.wordParser("teqj is L", roman);

      assertEquals("II" ,roman.getRoman("glob glob"));
      assertEquals("IV", roman.getRoman("glob prok"));
      assertEquals("XX", roman.getRoman(("pish pish")));
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
       wordparser parsedWord = new wordparser();
       WordToRoman roman = new WordToRoman();
       parsedWord.wordParser("glob is I",roman);
       parsedWord.wordParser("prok is V",roman);
       parsedWord.wordParser("pish is X",roman);
       parsedWord.wordParser("teqj is L",roman);
       //sentenceparser p1 = new sentenceparser();
       //p1.wordParser("glob prok Gold is 57800 Credits");
       assertEquals(17,credits.getCredits("glob glob Silver is 34 Credits  ",roman));
       assertEquals(14450,credits.getCredits("glob prok Gold is 57800 Credits ",roman));
       assertEquals(195.5,credits.getCredits("pish pish Iron is 3910 Credits  ",roman));
   }

   @Test
   void canCalculateMuchQuestions()
   {
       AnswerToQuestions answer = new AnswerToQuestions();
       wordparser parsedWord = new wordparser();
       WordToRoman roman = new WordToRoman();
       parsedWord.wordParser("glob is I",roman);
       parsedWord.wordParser("prok is V",roman);
       parsedWord.wordParser("pish is X",roman);
       parsedWord.wordParser("tegj is L",roman);
       assertEquals(42, answer.getAnswer("how much is pish tegj glob glob ?",roman));
   }

   @Test
    void canCalculateManyQuestions()
   {
       AnswerToQuestions answer = new AnswerToQuestions();
       wordparser parsedWord = new wordparser();
       WordToRoman roman = new WordToRoman();
       parsedWord.wordParser("glob is I",roman);
       parsedWord.wordParser("prok is V",roman);
       parsedWord.wordParser("pish is X",roman);
       parsedWord.wordParser("tegj is L",roman);
       Credits credits = new Credits();
       credits.getCredits("glob glob Silver is 34 Credits  ",roman);
       assertEquals(68,answer.getAnswer("how many Credits is glob prok Silver ?",roman));
       credits.getCredits("glob prok Gold is 57800 Credits ",roman);
       assertEquals(57800,answer.getAnswer("how many Credits is glob prok Gold ?",roman));
       credits.getCredits("pish pish Iron is 3910 Credits ",roman);
       assertEquals(782,answer.getAnswer("how many Credits is glob prok Iron ?",roman));
   }

   @Test
    void unitTest()
   {

   }
}
