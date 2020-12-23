object Main extends App {
  val sudoku = new SudokuHandler()

  sudoku.readFromFile("test-data/input.txt")
  val solved = sudoku.solve()
  if (solved) {
    println("The sudoku was solved!")
    println(sudoku.toPrettyString())
    sudoku.writeToFile("test-data/output.txt")
  } else {
    println("The sudoku is unsolvable")
  }
}