package fileio

// Trait che permette di rappresentare un tipo su file
trait FileIO {
  def readFromFile(filename: String): Unit
  def writeToFile(filename: String): Unit
}