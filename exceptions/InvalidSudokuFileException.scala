package exceptions

final case class InvalidSudokuFileException() extends Exception("Invalid sudoku file format")