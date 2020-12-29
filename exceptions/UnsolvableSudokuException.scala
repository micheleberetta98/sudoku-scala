package exceptions

final case class UnsolvableSudokuException() extends Exception("Unsolvable sudoku")