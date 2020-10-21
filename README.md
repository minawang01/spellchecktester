I implemented a spell-checker using a hashtable. I created a class called `SpellChecker` in the file `SpellChecker.java` that implements the interface `SpellCheckerInterface.java`.  The object will try to check for spelling errors in an input file, referencing a provided dictionary file. The `SpellChecker` object must accept the filename of the dictionary in its constructor. There is a sample dictionary file called `words.txt`.

The constructor of the object parses the dictionary file, storing the words in a `HashSet` instance. The `SpellChecker` object uses this dictionary as a reference when checking for spelling errors in a specified input file. Please note that **every word added to the `HashSet` instance must be in lower case**. In addition to the constructor, two methods are implemented to complete the functionality of your `SpellChecker` object.

* ```public List<String> getIncorrectWords(String filename)``` - This method returns a list of all words in the input file that are incorrectly spelled according to the dictionary file provided to the constructor. The String ```filename``` contains the name of the file to be spell-checked.

A word is defined as a sequence of characters with whitespace (one or more spaces and/or tabs) on either side.

The output list contains the incorrect words that remain after processing input data (e.g. `youhow` in the above example).

* ```public Set<String> getSuggestions(String word)``` - This method returns a set of all potential suggestions for the incorrectly spelled word that is provided as input.

In order to generate a suggestion for a given word, the following spell checking techniques are implemented, where a character is defined as one of `a, b, c, ..., z`:

* Add one character - add a character at every point in the string (including at the very beginning and end)
* Remove one character - remove one character at a time from each position in the string
* Swap adjacent characters - swap every pair of adjacent characters in the string

This method returns all possible suggestions from each one of the techniques above. Note that the use of a `Set` object maintains only unique suggestions (i.e. no duplicates).

There is a sample test file to spell-check. This file is called `test.txt`.