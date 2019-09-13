/***
 
Word Count Engine
Implement a document scanning function wordCountEngine, which receives a string document and returns a list of all unique words in it and their number of occurrences, sorted by the number of occurrences in a descending order. If two or more words have the same count, they should be sorted according to their order in the original sentence. Assume that all letters are in english alphabet. You function should be case-insensitive, so for instance, the words “Perfect” and “perfect” should be considered the same word.

The engine should strip out punctuation (even in the middle of a word) and use whitespaces to separate words.

Analyze the time and space complexities of your solution. Try to optimize for time while keeping a polynomial space complexity.

Examples:

input:  document = "Practice makes perfect. you'll only
                    get Perfect by practice. just practice!"

output: [ ["practice", "3"], ["perfect", "2"],
          ["makes", "1"], ["youll", "1"], ["only", "1"], 
          ["get", "1"], ["by", "1"], ["just", "1"] ]
Important: please convert the occurrence integers in the output list to strings (e.g. "3" instead of 3). We ask this because in compiled languages such as C#, Java, C++, C etc., it’s not straightforward to create mixed-type arrays (as it is, for instance, in scripted languages like JavaScript, Python, Ruby etc.). The expected output will simply be an array of string arrays.

Constraints:

[time limit] 5000ms
[input] string document
[output] array.array.string

***/
function wordCountEngine(document) {
  var currentWord = "";
  var dict = {};
  for(let i = 0; i < document.length; i++){
    let currentChar = document[i];
    if(currentChar === document[i-1]) { continue; }
    if(currentChar.match(/[\s]/)) {
      [dict, currentWord] = maintainDictionary(dict, currentWord);
    }
    else {
      if(currentChar.match(/[\w]/)) { currentWord = currentWord.concat(currentChar); }
    }
  }
}

function maintainDictionary(dict, currentWord) {
  if(dict.hasOwnProperty(currentWord)){ dict[currentWord] = ++dict[currentWord]; }
  else { dict[currentWord] = 1; }

  return [dict,""];
}
console.log(wordCountEngine("Every book is a quotation; and you'll every house is a quotation out of all forests, and mines, and stone quarries; and every man is a quotation from all his ancestors."));


/*
 * 1. Scan the sentence until there is a space
 *
 * */
