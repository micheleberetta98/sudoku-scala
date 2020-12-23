object Main extends App {
  val sudoku = new Sudoku()

  sudoku.readFromFile("test-data/input.txt")
  sudoku.writeToFile("test-data/output.txt")
}