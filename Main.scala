object Main extends App {
  val sudoku = new SudokuHandler()

  sudoku.readFromFile("test-data/input.txt")
  sudoku.solve()
  sudoku.writeToFile("test-data/output.txt")
}