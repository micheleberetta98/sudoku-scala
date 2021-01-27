package sudoku

import java.io.PrintWriter
import fileio._
import exceptions._

// SudokuHandler estende Sudoku con il trait FileIO
// per la lettura/scrittura su file
class SudokuHandler extends Sudoku(Array.ofDim(9, 9)) with FileIO {
  def trySolve() = {
    val ok = solve()
    if (!ok)
      throw UnsolvableSudokuException()
  }

  override def readFromFile(filename: String) = {
    val lines = io.Source.fromFile(filename).mkString.split("\n")
    if (lines.length != 9) {
      throw InvalidSudokuFileException()
    }

    var row = 0
    var col = 0
    
    lines.foreach(line => {
      col = 0
      val nums = toListOfInts(line)
      if (nums.length != 9) {
        throw InvalidSudokuFileException()
      }

      for (x <- nums) {
        sudoku(row)(col) = x
        col += 1
      }
      row += 1
    })
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
