import java.io.*;
import java.text.Normalizer;
import java.util.ArrayList;

public class NGram {
    public static void main(String[] args) {

        System.out.println("Printing Bigram - English");
        Bigram bigramEnglish = new Bigram();
        ArrayList<Character> englishBigramCharacterArray;
        englishBigramCharacterArray = cleanInput(".\\Input\\en-moby-dick.txt");
        englishBigramCharacterArray.addAll(cleanInput(".\\Input\\en-the-little-prince.txt"));
        bigramEnglish.trainBigram(englishBigramCharacterArray);
        writeToFile(".\\Output\\Models\\bigramEN.txt", bigramEnglish.printProfessorBigramOutput());
        // bigramEnglish.printVerboseBigram();
        // bigramEnglish.printProfessorBigramOutput();

        System.out.println("Printing Bigram - French");
        Bigram bigramFrench = new Bigram();
        ArrayList<Character> frenchBigramCharacterArray;
        frenchBigramCharacterArray = cleanInput(".\\Input\\fr-le-petit-prince.txt");
        frenchBigramCharacterArray.addAll(cleanInput(".\\Input\\fr-vingt-mille-lieues-sous-les-mers.txt"));
        bigramFrench.trainBigram(frenchBigramCharacterArray);
        writeToFile(".\\Output\\Models\\bigramFR.txt", bigramFrench.printProfessorBigramOutput());
        // bigramFrench.printVerboseBigram();
        // bigramFrench.printProfessorBigramOutput();

        System.out.println("Printing Bigram - Italian");
        Bigram bigramItalian = new Bigram();
        ArrayList<Character> italianBigramCharacterArray;
        italianBigramCharacterArray = cleanItalianFile(".\\Input\\it-il piccolo-principe.txt");
        italianBigramCharacterArray.addAll(cleanItalianFile(".\\Input\\it-la-novellaja-fiorentina.txt"));
        bigramItalian.trainBigram(italianBigramCharacterArray);
        writeToFile(".\\Output\\Models\\bigramOT.txt", bigramItalian.printProfessorBigramOutput());
        // bigramItalian.printVerboseBigram();
        // bigramItalian.printProfessorBigramOutput();

        /*
            System.out.println("Printing Bigram - Portuguese");
            Bigram bigramPortuguese = new Bigram();
            ArrayList<Character> portugueseBigramCharacterArray;
            portugueseBigramCharacterArray = cleanItalianFile(".\\Input\\ps-bases-da-ortografia.txt.txt");
            portugueseBigramCharacterArray.addAll(cleanItalianFile(".\\Input\\ps-reprezentacao-a-academia.txt"));
            bigramPortuguese.trainBigram(portugueseBigramCharacterArray);
            writeToFile(".\\Output\\Models\\bigramOT2.txt", bigramPortuguese.printProfessorBigramOutput());
            // bigramPortuguese.printVerboseBigram();
            // bigramPortuguese.printProfessorBigramOutput();
        */

        System.out.println("Print Unigram - English");
        Unigram unigramEnglish = new Unigram();
        ArrayList<Character> englishUnigramCharacterArray;
        englishUnigramCharacterArray = cleanInput(".\\Input\\en-moby-dick.txt");
        englishUnigramCharacterArray.addAll(cleanInput(".\\Input\\en-the-little-prince.txt"));
        unigramEnglish.trainUnigram(englishUnigramCharacterArray);
        writeToFile(".\\Output\\Models\\unigramEN.txt", unigramEnglish.printProfessorUnigramOutput());
        // unigramEnglish.printVerboseUnigram();
        // unigramEnglish.printProfessorUnigramOutput();

        System.out.println("Print Unigram - French");
        Unigram unigramFrench = new Unigram();
        ArrayList<Character> frenchUnigramCharacterArray;
        frenchUnigramCharacterArray = cleanInput(".\\Input\\fr-le-petit-prince.txt");
        frenchUnigramCharacterArray.addAll(cleanInput(".\\Input\\fr-vingt-mille-lieues-sous-les-mers.txt"));
        unigramFrench.trainUnigram(frenchUnigramCharacterArray);
        writeToFile(".\\Output\\Models\\unigramFR.txt", unigramFrench.printProfessorUnigramOutput());
        // unigramFrench.printVerboseUnigram();
        // unigramFrench.printProfessorUnigramOutput();

        System.out.println("Print Unigram - Italian");
        Unigram unigramItalian = new Unigram();
        ArrayList<Character> italianUnigramCharacterArray;
        italianUnigramCharacterArray = cleanItalianFile(".\\Input\\it-il piccolo-principe.txt");
        italianUnigramCharacterArray.addAll(cleanItalianFile(".\\Input\\it-la-novellaja-fiorentina.txt"));
        unigramItalian.trainUnigram(italianUnigramCharacterArray);
        writeToFile(".\\Output\\Models\\unigramOT.txt", unigramItalian.printProfessorUnigramOutput());
        // unigramItalian.printVerboseUnigram();
        // unigramItalian.printProfessorUnigramOutput();

        /*
            System.out.println("Print Unigram - Portuguese");
            Unigram unigramPortuguese = new Unigram();
            ArrayList<Character> portugeueseUnigramCharacterArray;
            portugeueseUnigramCharacterArray = cleanItalianFile(".\\Input\\ps-bases-da-ortografia.txt");
            portugeueseUnigramCharacterArray.addAll(cleanItalianFile(".\\Input\\ps-reprezentacao-a-academia.txt"));
            unigramPortuguese.trainUnigram(portugeueseUnigramCharacterArray);
            writeToFile(".\\Output\\Models\\unigramOT2.txt", unigramPortuguese.printProfessorUnigramOutput());
            // unigramPortuguese.printVerboseUnigram();
            // unigramPortuguese.printProfessorUnigramOutput();
        */

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(".\\Input\\first10TestSentences.txt"));
            String line = reader.readLine();
            double englishProbability;
            double englishTotalProbability = 0;
            double frenchProbability;
            double frenchTotalProbability = 0;
            double italianProbability;
            double italianTotalProbability = 0;
            /*
            double portugueseProbability;
            double portugueseTotalProbability = 0;
            */
            String response = "";
            int responseCount = 1;

            while (line != null) {
                response = "";
                response+=(line + "\n");
                response+=("UNIGRAM MODEL" + "\n\n");
                ArrayList<Character> sentenceCharacterArray = cleanInputSentence(line);

                englishProbability = 0;
                englishTotalProbability = 0;
                frenchProbability = 0;
                frenchTotalProbability = 0;
                italianProbability = 0;
                italianTotalProbability = 0;

                /*
                portugueseProbability=0;
                portugueseTotalProbability = 0;
                */

                for (char ch : sentenceCharacterArray) {

                    response+=("UNIGRAM: " + ch +"\n");

                    englishProbability = unigramEnglish.calculateLogSentencePobability(ch);
                    englishTotalProbability += Math.log10(englishProbability);
                    response+=("ENGLISH: P(" + ch + ") = " + englishProbability + " ==> log prob of sentence so far: " + englishTotalProbability +"\n");

                    frenchProbability = unigramFrench.calculateLogSentencePobability(ch);
                    frenchTotalProbability += Math.log10(frenchProbability);
                    response+=("FRENCH: P(" + ch + ") = " + frenchProbability + " ==> log prob of sentence so far: " + frenchTotalProbability +"\n");

                    italianProbability = unigramItalian.calculateLogSentencePobability(ch);
                    italianTotalProbability += Math.log10(italianProbability);
                    response+=("OTHER: P(" + ch + ") = " + italianProbability + " ==> log prob of sentence so far: " + italianTotalProbability +"\n\n");
                    /*
                    portugueseProbability = unigramPortuguese.calculateLogSentencePobability(ch);
                    portugueseTotalProbability += Math.log10(portugueseProbability);
                    response+=("Portuguese: P(" + ch + ") = " + portugueseProbability + " ==> log prob of sentence so far: " + portugueseTotalProbability +"\n\n");
                    */
                }

                if(englishTotalProbability>frenchTotalProbability){
                    if(englishTotalProbability > italianTotalProbability) {
                        response += ("According to the unigram model, the sentence is in English" + "\n");
                    }else{
                        response+=("According to the unigram model, the sentence is in Other" +"\n");
                    }
                } else if((englishTotalProbability == frenchTotalProbability) || (englishTotalProbability == italianTotalProbability) || (italianTotalProbability == frenchTotalProbability)){
                    if((englishTotalProbability == frenchTotalProbability) && (englishTotalProbability == italianTotalProbability) && (italianTotalProbability == frenchTotalProbability)){
                        response+=("According to the unigram model, the sentence is equally French and English and Other" +"\n");
                    } else if(englishTotalProbability == frenchTotalProbability){
                        response+=("According to the unigram model, the sentence is equally French and English" +"\n");
                    } else if(englishTotalProbability == italianTotalProbability){
                        response+=("According to the unigram model, the sentence is equally English and Other" +"\n");
                    } else if(italianTotalProbability == frenchTotalProbability){
                        response+=("According to the unigram model, the sentence is equally French and Other" +"\n");
                    }
                } else{
                    if(frenchTotalProbability > italianTotalProbability) {
                        response += ("According to the unigram model, the sentence is in French" + "\n");
                    }else{
                        response += ("According to the unigram model, the sentence is in Other" + "\n");
                    }
                }

                /*
                 if(portugueseTotalProbability>frenchTotalProbability){
                    if(portugueseTotalProbability > italianTotalProbability) {
                        response += ("According to the unigram model, the sentence is in Portuguese" + "\n");
                    }else{
                        response+=("According to the unigram model, the sentence is in Other" +"\n");
                    }
                } else if((portugueseTotalProbability == frenchTotalProbability) || (portugueseTotalProbability == italianTotalProbability) || (italianTotalProbability == frenchTotalProbability)){
                    if((portugueseTotalProbability == frenchTotalProbability) && (portugueseTotalProbability == italianTotalProbability) && (italianTotalProbability == frenchTotalProbability)){
                        response+=("According to the unigram model, the sentence is equally French and Portuguese and Other" +"\n");
                    } else if(portugueseTotalProbability == frenchTotalProbability){
                        response+=("According to the unigram model, the sentence is equally French and Portuguese" +"\n");
                    } else if(portugueseTotalProbability == italianTotalProbability){
                        response+=("According to the unigram model, the sentence is equally Portuguese and Other" +"\n");
                    } else if(italianTotalProbability == frenchTotalProbability){
                        response+=("According to the unigram model, the sentence is equally French and Other" +"\n");
                    }
                } else{
                    if(frenchTotalProbability > italianTotalProbability) {
                        response += ("According to the unigram model, the sentence is in French" + "\n");
                    }else{
                        response += ("According to the unigram model, the sentence is in Other" + "\n");
                    }
                }
                 */

                response+=("--------------------------------------------------------------------------------------------"+"\n");

                englishProbability = 0;
                englishTotalProbability = 0;
                frenchProbability = 0;
                frenchTotalProbability = 0;
                italianProbability = 0;
                italianTotalProbability = 0;
                /*
                    portugueseProbability=0;
                    portugueseTotalProbability = 0;
                */
                for(int x = 0; x < sentenceCharacterArray.size()-1; ++ x){
                    response+=("BIGRAM: " + sentenceCharacterArray.get(x) + sentenceCharacterArray.get(x+1) + "\n");

                    englishProbability = bigramEnglish.calculateLogSentencePobability(sentenceCharacterArray.get(x), sentenceCharacterArray.get(x+1));
                    englishTotalProbability +=  Math.log10(englishProbability);
                    response+=("ENGLISH: P(" + sentenceCharacterArray.get(x+1) + "|"  + sentenceCharacterArray.get(x) + ") = " + englishProbability + " ==> log prob of sentence so far: " + englishTotalProbability+"\n");

                    frenchProbability = bigramFrench.calculateLogSentencePobability(sentenceCharacterArray.get(x), sentenceCharacterArray.get(x+1));
                    frenchTotalProbability += Math.log10(frenchProbability);
                    response+=("FRENCH: P(" + sentenceCharacterArray.get(x+1) + "|"  + sentenceCharacterArray.get(x) + ") = " + frenchProbability + " ==> log prob of sentence so far: " + frenchTotalProbability+"\n");

                    italianProbability = bigramItalian.calculateLogSentencePobability(sentenceCharacterArray.get(x), sentenceCharacterArray.get(x+1));
                    italianTotalProbability += Math.log10(italianProbability);
                    response+=("OTHER: P(" + sentenceCharacterArray.get(x+1) + "|"  + sentenceCharacterArray.get(x) + ") = " + italianProbability + " ==> log prob of sentence so far: " + italianTotalProbability+"\n\n");
                    /*
                    portugueseProbability = bigramPortuguese.calculateLogSentencePobability(sentenceCharacterArray.get(x), sentenceCharacterArray.get(x+1));
                    portugueseTotalProbability += Math.log10(portugueseProbability);
                    response+=("Portuguese: P(" + sentenceCharacterArray.get(x+1) + "|"  + sentenceCharacterArray.get(x) + ") = " + portugueseProbability + " ==> log prob of sentence so far: " + portugueseTotalProbability+"\n\n");
                    */
                }

                if(englishTotalProbability>frenchTotalProbability){
                    if(englishTotalProbability > italianTotalProbability) {
                        response += ("According to the bigram model, the sentence is in English" + "\n");
                    }else{
                        response+=("According to the bigram model, the sentence is in Other" +"\n");
                    }
                } else if((englishTotalProbability == frenchTotalProbability) || (englishTotalProbability == italianTotalProbability) || (italianTotalProbability == frenchTotalProbability)){
                    if((englishTotalProbability == frenchTotalProbability) && (englishTotalProbability == italianTotalProbability) && (italianTotalProbability == frenchTotalProbability)){
                        response+=("According to the bigram model, the sentence is equally French and English and Other" +"\n");
                    } else if(englishTotalProbability == frenchTotalProbability){
                        response+=("According to the bigram model, the sentence is equally French and English" +"\n");
                    } else if(englishTotalProbability == italianTotalProbability){
                        response+=("According to the bigram model, the sentence is equally English and Other" +"\n");
                    } else if(italianTotalProbability == frenchTotalProbability){
                        response+=("According to the bigram model, the sentence is equally French and Other" +"\n");
                    }
                } else{
                    if(frenchTotalProbability > italianTotalProbability) {
                        response += ("According to the bigram model, the sentence is in French" + "\n");
                    }else{
                        response += ("According to the bigram model, the sentence is in Other" + "\n");
                    }
                }

                /*
                if(portugueseTotalProbability>frenchTotalProbability){
                    if(portugueseTotalProbability > italianTotalProbability) {
                        response += ("According to the bigram model, the sentence is in Portuguese" + "\n");
                    }else{
                        response+=("According to the bigram model, the sentence is in Other" +"\n");
                    }
                } else if((portugueseTotalProbability == frenchTotalProbability) || (portugueseTotalProbability == italianTotalProbability) || (italianTotalProbability == frenchTotalProbability)){
                    if((portugueseTotalProbability == frenchTotalProbability) && (portugueseTotalProbability == italianTotalProbability) && (italianTotalProbability == frenchTotalProbability)){
                        response+=("According to the bigram model, the sentence is equally French and Portuguese and Other" +"\n");
                    } else if(portugueseTotalProbability == frenchTotalProbability){
                        response+=("According to the bigram model, the sentence is equally French and Portuguese" +"\n");
                    } else if(portugueseTotalProbability == italianTotalProbability){
                        response+=("According to the bigram model, the sentence is equally Portuguese and Other" +"\n");
                    } else if(italianTotalProbability == frenchTotalProbability){
                        response+=("According to the bigram model, the sentence is equally French and Other" +"\n");
                    }
                } else{
                    if(frenchTotalProbability > italianTotalProbability) {
                        response += ("According to the bigram model, the sentence is in French" + "\n");
                    }else{
                        response += ("According to the bigram model, the sentence is in Other" + "\n");
                    }
                }
                 */

                response+=("--------------------------------------------------------------------------------------------"+"\n");
                System.out.println(response);
                writeToFile(".\\M3Output\\Sentences\\out" + responseCount + ".txt", response);
                ++responseCount;
                line = reader.readLine();
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Character> cleanInput(String fileName) {
        ArrayList<Character> characterArray = new ArrayList<>();

        try{
            FileReader fr = new FileReader(fileName);

            // Clean Input to ignore everything except characters + lower case everything
            int i;
            while ((i=fr.read()) != -1) {
                if(i>=65 && i<=90){
                    int characterIntValue = i;
                    characterArray.add((char) (characterIntValue+32));
                }else if(i>=97 && i<=122){
                    characterArray.add((char) i);
                }
            }

        }catch (Exception e){
            System.out.print("Error reading from file!!!");
        }
        return characterArray;
    }

    public static ArrayList<Character> cleanInputSentence(String sentence) {
        ArrayList<Character> characterArray = new ArrayList<>();

        char[] chars = sentence.toCharArray();

        for (char ch : chars) {
            int charValue = (int) ch;
            if(charValue>=65 && charValue<=90){
                int characterIntValue = charValue;
                characterArray.add((char) (characterIntValue+32));
            }else if(charValue>=97 && charValue<=122){
                characterArray.add((char) charValue);
            }
        }

        return characterArray;
    }

    public static ArrayList<Character> cleanItalianFile(String fileName) {
        File file = new File(fileName);
        String response = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null) {
                response+= st;
            }
        } catch(Exception e){
            System.out.print("Error reading from file while cleaning italian input!!!");
        }

        response = Normalizer.normalize(response, Normalizer.Form.NFD);
        response = response.replaceAll("[^\\p{ASCII}]", "");


        ArrayList<Character> characterArray = new ArrayList<>();

        char[] chars = response.toCharArray();

        for (char ch : chars) {
            int charValue = (int) ch;
            if(charValue>=65 && charValue<=90){
                int characterIntValue = charValue;
                characterArray.add((char) (characterIntValue+32));
            }else if(charValue>=97 && charValue<=122){
                characterArray.add((char) charValue);
            }
        }

        return characterArray;
    }

    public static ArrayList<Character> readFile(String fileName) {
        ArrayList<Character> characterArray = new ArrayList<>();

        try{
            FileReader fr = new FileReader(fileName);

            // Clean Input to ignore everything except characters + lower case everything
            int i;
            while ((i=fr.read()) != -1) {
                characterArray.add((char) i);
            }
        }catch (Exception e){
            System.out.print("Error reading from file!!!");
        }
        return characterArray;
    }

    public static void writeToFile(String fileName, String output){
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "utf-8"));
            writer.write(output);
        }catch (Exception e){
            System.out.println("There was an error writing output to file");
        }finally {
            try{
                writer.close();
            }catch (Exception e2){
                System.out.println("There was an error closing writer");

            }
        }
    }
}