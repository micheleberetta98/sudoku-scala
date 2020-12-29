package fileio

trait FileIO {
  def readFromFile(filename: String): Unit
  def writeToFile(filename: String): Unit
}