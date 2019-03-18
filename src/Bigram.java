import java.util.ArrayList;

public class Bigram {

    private int[][] nGramTableCount = new int[26][26];
    private double[][] nGramTableProbabilities = new double[26][26];
    private int[] historyTable = new int[26];
    private NGramUtils nGramUtils = new NGramUtils();
    private ArrayList<Character> characterArray = new ArrayList<>();

    public void trainBigram(ArrayList<Character> arrayList) {
        characterArray = arrayList;

        // Initialize Array
        for(int x = 0; x< nGramTableCount.length; ++x) {
            for (int y = 0; x < nGramTableCount[0].length; ++x) {
                nGramTableCount[x][y] = 0;
            }
        }

        nGramUtils.initializeCharacterValue();

        // Count History
        for(int z=0; z<characterArray.size()-1; ++z){
            char firstChar = characterArray.get(z);
            char secondChar = characterArray.get(z+1);

            nGramTableCount[nGramUtils.characterSetValues.get(firstChar)][nGramUtils.characterSetValues.get(secondChar)]+=1;
        }

        // Initialize Array
        for(int x = 0; x< historyTable.length; ++x) {
            historyTable[x] = 0;
        }

        // Count History
        for(int z=0; z<characterArray.size()-1; ++z){
            char firstChar = characterArray.get(z);

            historyTable[nGramUtils.characterSetValues.get(firstChar)]+=1;
        }

        // Copy Count array into a probability array to do some math
        for(int x=0; x<nGramTableCount.length; x++){
            for(int y=0; y<nGramTableCount[x].length; y++) {
                nGramTableProbabilities[x][y] = nGramTableCount[x][y];
            }
        }

        // Calculate bigram probabilities
        for(int x=0; x<nGramTableCount.length; x++){
            for(int y=0; y<nGramTableCount[x].length; y++) {

                nGramTableProbabilities[x][y] = (nGramTableCount[x][y] + 0.5)/(historyTable[x] + (26*0.5));
            }
        }
    }

    public double calculateLogSentencePobability(char firstChar, char secondChar) {
        return nGramTableProbabilities[nGramUtils.characterSetValues.get(firstChar)][nGramUtils.characterSetValues.get(secondChar)];
    }

    public void printVerboseBigram() {
        System.out.println("Un-smoothed Bigram N-Gram Counts");
        System.out.print("  ");
        nGramUtils.printRowHeader();
        System.out.println();
        nGramUtils.format2DArrayInt(nGramTableCount);
        System.out.println();

        System.out.println("Un-smoothed Bigram Vocabulary Counts");
        nGramUtils.printRowHeader();
        System.out.println();
        nGramUtils.format1DArrayInt(historyTable);
        System.out.println();
        System.out.println();

        System.out.println("Un-smoothed Bigram Probability:");
        System.out.print("  ");
        nGramUtils.printRowHeader();
        System.out.println();
        nGramUtils.format2DProbOutputDouble(nGramTableProbabilities);
        System.out.println();
        System.out.println();
    }

    public String printProfessorBigramOutput() {
        System.out.println("Smoothed and logged Bigram Probabilities:");
        String response = "";
        for(int x=0; x<nGramTableProbabilities.length; x++){
            for(int y=0; y<nGramTableProbabilities[x].length; y++) {
                response+= ("P(" + nGramUtils.letterOptions[y] +
                        "|" + nGramUtils.letterOptions[x] +") = " + (nGramTableProbabilities[x][y]) +"\n");
                System.out.println("P(" + nGramUtils.letterOptions[y] +
                        "|" + nGramUtils.letterOptions[x] +") = " + (nGramTableProbabilities[x][y]));
            }
        }
        System.out.println();
        return response;
    }
}