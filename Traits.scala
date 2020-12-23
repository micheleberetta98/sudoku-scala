trait FileReader {
  def readFromFile(filename: String): Unit
}

trait FileWriter {
  def writeToFile(filename: String): Unit
}