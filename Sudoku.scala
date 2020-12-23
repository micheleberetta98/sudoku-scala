class Sudoku(var sudoku: Array[Array[Int]]) {
  def solve(): Boolean = {
    for (i <- 0 until 9)
      for (j <- 0 until 9)
        if (sudoku(i)(j) == 0)
          return tryAllNumbers(i, j)
    return true
  }

  def tryAllNumbers(i: Int, j: Int): Boolean = {
    for (n <- 1 until 10)
      if (isPossible(i, j, n)) {
        sudoku(i)(j) = n
        if (solve())
          return true
        sudoku(i)(j) = 0
      }
    return false
  }

  private def isPossible(x: Int, y: Int, n: Int) =
    !(isInRow(x, n) || isInCol(y, n) || isInSquare(x, y, n))

  private def isInRow(x: Int, n: Int): Boolean = {
    for (j <- 0 until 9)
      if (sudoku(x)(j) == n)
        return true
    false
  }

  private def isInCol(y: Int, n: Int): Boolean = {
    for (i <- 0 until 9)
      if (sudoku(i)(y) == n)
        return true
    false
  }

  private def isInSquare(x: Int, y: Int, n: Int): Boolean = {
    val x0 = (x / 3) * 3
    val y0 = (y / 3) * 3
    for (i <- 0 until 3)
      for (j <- 0 until 3)
        if (sudoku(x0 + i)(y0 + j) == n)
          return true
    false
  }

  override def toString(): String =
    sudoku.map(rowToString).mkString("\n")

  private def rowToString(row: Array[Int]) =
    row.map(x => x.toString).mkString(" ")
}