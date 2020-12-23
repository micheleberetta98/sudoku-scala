class Sudoku(var sudoku: Array[Array[Int]]) extends Prettifiable {
  def solve(): Boolean = {
    for (i <- 0 until 9)
      for (j <- 0 until 9)
        if (sudoku(i)(j) == 0)
          return tryAllNumbers(i, j)
    return isOk()
  }

  private def tryAllNumbers(i: Int, j: Int): Boolean = {
    for (n <- 1 until 10)
      if (isPossible(i, j, n)) {
        sudoku(i)(j) = n
        if (solve())
          return true
        sudoku(i)(j) = 0
      }
    return false
  }

  private def isOk(): Boolean = {
    for (i <- 0 until 9)
      for (j <- 0 until 9)
        if (!isPossible(i, j, sudoku(i)(j)))
          return false
    true
  }

  private def isPossible(x: Int, y: Int, n: Int) =
    !(isInRow(x, y, n) || isInCol(x, y, n) || isInSquare(x, y, n))

  private def isInRow(x: Int, y: Int, n: Int): Boolean = {
    for (j <- 0 until 9)
      if (j != y && sudoku(x)(j) == n)
        return true
    false
  }

  private def isInCol(x: Int, y: Int, n: Int): Boolean = {
    for (i <- 0 until 9)
      if (i != x && sudoku(i)(y) == n)
        return true
    false
  }

  private def isInSquare(x: Int, y: Int, n: Int): Boolean = {
    val x0 = (x / 3) * 3
    val y0 = (y / 3) * 3
    for (i <- 0 until 3)
      for (j <- 0 until 3)
        if (x0 + i != x && y0 + j != y && sudoku(x0 + i)(y0 + j) == n)
          return true
    false
  }

  override def toString() =
    sudoku.map(rowToString).mkString("\n")

  private def rowToString(row: Array[Int]) =
    row.map(x => x.toString).mkString(" ")

  def toPrettyString() = {
    val prettyRows = sudoku.grouped(3).map(
      group => group.map(rowToPrettyString).mkString("\n")
    ).toArray
    List(
      Borders.makeBorder("top", 3, 3),
      prettyRows(0),
      Borders.makeBorder("middle", 3, 3),
      prettyRows(1),
      Borders.makeBorder("middle", 3, 3),
      prettyRows(2),
      Borders.makeBorder("bottom", 3, 3),
    ).mkString("\n")
  }

  private def rowToPrettyString(row: Array[Int]) =
    List(
      Borders.vertical,
      row.grouped(3).map(rowToString).mkString(" " + Borders.vertical + " "),
      Borders.vertical
    ).mkString(" ")
}