object Main extends App {
  val sudoku = new SudokuSolver()

  sudoku.readFromFile("test-data/input.txt")
  sudoku.writeToFile("test-data/output.txt")
}