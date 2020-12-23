object Main {
  def main(args: Array[String]) = {
    if (validateArgs(args)) {
      val input = args(0)
      val output = if (args.length > 1) Some(args(1)) else None
      solveSudoku(input, output)
    } else {
      println("USAGE:")
      println("  scala Main INPUT_FILE [OUTPUT_FILE]")
    }
  }

  def validateArgs(args: Array[String]) = {
    args.length > 0
  }

  def solveSudoku(input: String, output: Option[String]) = {
    val sudoku = new SudokuHandler()

    sudoku.readFromFile(input)
    val solved = sudoku.solve()
    if (solved) {
      println("The sudoku was solved!")
      println(sudoku.toPrettyString())
      output match {
        case Some(file) => sudoku.writeToFile(file)
        case None       => ()
      }
    } else {
      println("The sudoku is unsolvable")
    }
  }
}