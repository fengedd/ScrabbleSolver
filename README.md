# Scrabble Solver

A simple scrabble solver used to find all valid permutations of the given tiles and calculate their respective scores. 

## How it works
Scrabble Solver uses the official Scrabble dictionary and works by putting all word entries into a hash table using the word entry itself sorted by their lexicographic order as the key. 

## Installation

In the ScrabbleSolver directory type:

```sh
> java -jar ScrabbleSolver.jar
```

## Usage

```sh
> Input letter tiles or type 'q' to exit: 'dad'

3 Points
[AD, DA]
5 Points
[ADD, DAD]
```

## License
[MIT](https://choosealicense.com/licenses/mit/)