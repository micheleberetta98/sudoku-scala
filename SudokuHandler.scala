import java.io.PrintWriter

class SudokuHandler extends Sudoku(Array.ofDim(9, 9)) with FileIO {
  def solve() = 
    println("TODO: Implement")

  def readFromFile(filename: String) = {
    val lines = io.Source.fromFile(filename).mkString.split("\n")
    var row = 0
    var col = 0
    for (line <- lines) {
      col = 0
      for (x <- toListOfInts(line)) {
        sudoku(row)(col) = x
        col += 1
      }
      row += 1
    }
  }
  
  def writeToFile(filename: String) = {
    val output = toString
    new PrintWriter(filename) {
      write(output)
      close
    }
  }

  private def toListOfInts(s: String) =
    s.split(" +").map(x => x.toInt)
}