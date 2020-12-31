package sudoku

import java.io.PrintWriter
import fileio._
import exceptions._
class SudokuHandler extends Sudoku(Array.ofDim(9, 9)) with FileIO {
  def trySolve() = {
    val ok = solve()
    if (!ok)
      throw UnsolvableSudokuException()
  }

  override def readFromFile(filename: String) = {
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
  
  override def writeToFile(filename: String) = {
    val output = toString
    new PrintWriter(filename) {
      write(output)
      close
    }
  }

  private def toListOfInts(s: String) =
    s.filter(_ >= ' ').split(" +").map(x => x.toInt)
}
