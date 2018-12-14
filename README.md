# Scrabble Solver

A simple scrabble solver used to find all valid permutations of the given tiles and calculate their respective scores.

## Installation

In the ScrabbleSolver directory type:

```sh
mkdir classes;
javac -d classes src/com/scrabblesolver/*.java;
jar cfm ScrabbleSolver.jar manifest.txt -C classes com;
java -jar ScrabbleSolver.jar;
```

## Usage

```sh
Input letter tiles or type 'q' to exit: "dad"

3 Points
[AD, DA]
5 Points
[ADD, DAD]
```

## License
[MIT](https://choosealicense.com/licenses/mit/)