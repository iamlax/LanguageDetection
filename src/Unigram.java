import java.util.ArrayList;

public class Unigram {

    private int[] nGramTableCount = new int[26];
    private double[] nGramTableProbabilities = new double[26];
    private NGramUtils nGramUtils = new NGramUtils();
    private ArrayList<Character> characterArray = new ArrayList<>();

    public void trainUnigram(ArrayList<Character> arrayList) {
        characterArray = arrayList;

        // Initialize Array
        for (int x = 0; x < nGramTableCount.length; ++x) {
            nGramTableCount[x] = 0;
        }

        nGramUtils.initializeCharacterValue();

        // Count History
        for(int z=0; z<characterArray.size()-1; ++z){
            char firstChar = characterArray.get(z);
            nGramTableCount[nGramUtils.characterSetValues.get(firstChar)]+=1;
        }

        // Copy Count array into a probability array to do some math
        for(int x=0; x<nGramTableCount.length; x++){
            nGramTableProbabilities[x] = nGramTableCount[x];
        }

        // Calculate bigram probabilities
        for(int x=0; x<nGramTableCount.length; x++){
            nGramTableProbabilities[x] = (nGramTableCount[x] + 0.5)/(characterArray.size() + (26*0.5));
        }
    }

    public double calculateLogSentencePobability(char character) {
        return nGramTableProbabilities[nGramUtils.characterSetValues.get(character)];
    }

    public void printVerboseUnigram() {
        System.out.println("Un-smoothed Bigram N-Gram Counts");
        nGramUtils.printRowHeader();
        System.out.println();
        nGramUtils.format1DArrayInt(nGramTableCount);
        System.out.println();
        System.out.println();

        System.out.println("Count of all characters in file: " + characterArray.size());
        System.out.println();

        System.out.println("Un-smoothed Bigram Probability:");
        nGramUtils.printRowHeader();
        System.out.println();
        nGramUtils.format1DProbDouble(nGramTableProbabilities);
        System.out.println();
        System.out.println();
    }

    public String printProfessorUnigramOutput() {
        System.out.println("Smoothed and logged Unigram Probabilities:");
        String response = "";
        for(int x=0; x<nGramTableProbabilities.length; x++){
            System.out.println("P(" + nGramUtils.letterOptions[x] + ") = " + (nGramTableProbabilities[x]));
            response+= ("P(" + nGramUtils.letterOptions[x] + ") = " + (nGramTableProbabilities[x]) +"\n");
        }
        System.out.println();
        return response;
    }
}