class Sudoku(var sudoku: Array[Array[Int]]) {
  def isPossible(x: Int, y: Int, n: Int) = {
    !(isInRow(x, n) || isInCol(y, n) || isInSquare(x, y, n))
  }

  private def isInRow(x: Int, n: Int) = {
    for (j <- 0 until 9)
      if (sudoku(x)(j) == n)
        true
    false
  }

  private def isInCol(y: Int, n: Int) = {
    for (i <- 0 until 9)
      if (sudoku(i)(y) == n)
        true
    false
  }

  private def isInSquare(x: Int, y: Int, n: Int) = {
    val x0 = x / 3
    val y0 = y / 3
    for (i <- 0 until 3)
      for (j <- 0 until 3)
        if (sudoku(x0 + i)(y0 + j) == n)
          true
    false
  }

  override def toString(): String = {
    sudoku.map(rowToString).mkString("\n")
  }

  private def rowToString(row: Array[Int]) =
    row.map(x => x.toString).mkString(" ")
}