# Language Detection using unigram and bigram models
COMP 472: Mini-Project 3

Train unigram and bigram models using texts found online to determine if a sentence is english, french, italian. 
Note: You can uncomment the commented code to additionally support portuguese. However, since portuguese is similar to italian the predication may be affected.

## To Run
Simply run the NGram.java class. If you would like to provide some sentences to the prediction algorithm. 
Add the sentences to the list of sentences in Input/first10TestSentences.txt file on a new line. The prediction of the sentence will be available in the Output/Sentences folder in the file Out1(where 1 is the sentence number in the list).

### Explanation of the code
The online texts are used to train the models

```
System.out.println("Printing Bigram - English");
Bigram bigramEnglish = new Bigram();                                                          // Create Bigram Model
ArrayList<Character> englishBigramCharacterArray; 
englishBigramCharacterArray = cleanInput(".\\Input\\en-moby-dick.txt");                       // Clean the file(i.e. è to e, etc)
englishBigramCharacterArray.addAll(cleanInput(".\\Input\\en-the-little-prince.txt"));         // Add another file to training data
bigramEnglish.trainBigram(englishBigramCharacterArray);                                       // Train model using text files
writeToFile(".\\Output\\Models\\bigramEN.txt", bigramEnglish.printProfessorBigramOutput());   // Write the Output to file
// bigramEnglish.printVerboseBigram();
// bigramEnglish.printProfessorBigramOutput();
```
The models are then used to predict the provided sentences.

Note: Additional texts can be provided to further train the model. However, they have to be added in the respective language section
i.e
```
englishBigramCharacterArray = cleanInput(".\\Input\\en-moby-dick.txt");                       // Clean the file(i.e. è to e, etc)
englishBigramCharacterArray.addAll(cleanInput(".\\Input\\en-the-little-prince.txt"));         // Add another file to training data
```

### Example Solution Output
#### Given Sentence: Velvet robes are incredibly awesome. (From Output/Sentence/Out13.txt
```
Velvet robes are incredibly awesome.
UNIGRAM MODEL

UNIGRAM: v
ENGLISH: P(v) = 0.009044418667053675 ==> log prob of sentence so far: -2.043619342325931
FRENCH: P(v) = 0.0148647537495474 ==> log prob of sentence so far: -1.82784228094936
OTHER: P(v) = 0.022002348155660902 ==> log prob of sentence so far: -1.6575309675129444

UNIGRAM: e
ENGLISH: P(e) = 0.1230056600050325 ==> log prob of sentence so far: -2.9536942467206924
FRENCH: P(e) = 0.17101499241940113 ==> log prob of sentence so far: -2.5948080954718167
OTHER: P(e) = 0.12301084536844117 ==> log prob of sentence so far: -2.5675875643985253

UNIGRAM: l
ENGLISH: P(l) = 0.04489842582741422 ==> log prob of sentence so far: -4.301463132141693
FRENCH: P(l) = 0.053924672937911214 ==> log prob of sentence so far: -3.863020575757339
OTHER: P(l) = 0.065302813790392 ==> log prob of sentence so far: -3.7526556696883393

UNIGRAM: v
ENGLISH: P(v) = 0.009044418667053675 ==> log prob of sentence so far: -6.345082474467624
FRENCH: P(v) = 0.0148647537495474 ==> log prob of sentence so far: -5.690862856706699
OTHER: P(v) = 0.022002348155660902 ==> log prob of sentence so far: -5.410186637201283

                                         ... (Ouput shortened)

According to the unigram model, the sentence is in English
--------------------------------------------------------------------------------------------
BIGRAM: ve
ENGLISH: P(e|v) = 0.6694524495677233 ==> log prob of sentence so far: -0.17428026499063828
FRENCH: P(e|v) = 0.32969855578171947 ==> log prob of sentence so far: -0.48188295524508973
OTHER: P(e|v) = 0.3275033115831821 ==> log prob of sentence so far: -0.4847843042369888

BIGRAM: el
ENGLISH: P(l|e) = 0.04686226914720261 ==> log prob of sentence so far: -1.5034569509761921
FRENCH: P(l|e) = 0.06321111982659008 ==> log prob of sentence so far: -1.6810894710365982
OTHER: P(l|e) = 0.14635206321334504 ==> log prob of sentence so far: -1.3193854549126534

BIGRAM: lv
ENGLISH: P(v|l) = 0.005916540741601767 ==> log prob of sentence so far: -3.7313890915401444
FRENCH: P(v|l) = 0.003195699844894903 ==> log prob of sentence so far: -4.176523489452053
OTHER: P(v|l) = 0.011468117475856595 ==> log prob of sentence so far: -3.259893321836762

                                         ... (Ouput shortened)

According to the bigram model, the sentence is in English
--------------------------------------------------------------------------------------------

```

## References
Italian and Portguese texts are from
1. https://archive.org/details/EbookItaIlPiccoloPrincipeAntoineDeSaintExupery1
2. http://www.gutenberg.org/ebooks/46898
3. http://www.gutenberg.org/ebooks/19663
English and french texts provided by the professor
4. http://www.gutenberg.org/ebooks/15047
