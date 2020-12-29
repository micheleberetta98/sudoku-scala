# Sudoku solver in Scala

This is a little project in Scala that solves a sudoku using backtracking.
It also pretty prints the sudoku if it's been solved.

## Installation

You will need Scala installed on your system:
- macOS: `brew install scala`
- Ubuntu: `sudo apt install scala`
- Windows: look around [here](https://www.scala-lang.org/download/install.html)

When you can access both `scalac` and `scala` from the command line, just do
```
scalac *.scala fileio/*.scala pretty/*.scala sudoku/*scala
scala Main inputFile
```
And it will compile and execute.

## Usage

You can specify two arguments:
- the first is the input file and it's required
- the second is the output file and it's optional

The input file must be a text file and have 9 lines. Each lines must have 9 numbers separated by spaces.
You can use `0` to denotate empty sudoku cells.

An example of an input file can be
```
0 0 0 2 6 0 7 0 1
6 8 0 0 7 0 0 9 0
1 9 0 0 0 4 5 0 0
8 2 0 1 0 0 0 4 0
0 0 4 6 0 2 9 0 0
0 5 0 0 0 3 0 2 8
5 1 9 3 2 6 8 7 4
2 4 8 9 5 7 1 3 6
7 6 3 4 1 8 2 5 9
```

## If you use Eclipse

If you want to use Eclipse, make sure that:
1. Your text file encoding is UTF-8. You can check under `Window > Preferences > General > Workspace`.
   Otherwise characters like those in `pretty/Borders.scala` will not show properly.
2. You pass the CLI argument to the executable. You can check by right-clicking the project, then selecting
   `Run As > Run Configurations...`. In the newly opened window there's an "Arguments" tab, an there will be a textfield where you can enter the paths to the input file (and output file if you need it).
   The path is relative to the working directory shown in the window.
