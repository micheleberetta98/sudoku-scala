package pretty

// Singleton di utilità per il pretty printing
object Borders {
  val horizontal = "─"
  val topMid = "┬"
  val topLeft = "┌"
  val topRight = "┐"
  val bottomMid = "┴"
  val bottomLeft = "└"
  val bottomRight = "┘"
  val vertical = "│"
  val leftMid = "├"
  val midMid = "┼"
  val rightMid = "┤"

  // Crea un bordo orizzontale con i necessari separatori
  // sections indica quante sezioni sono da fare
  // elsPerSection indica il numero di elementi per sezione
  def makeBorder(position: String, sections: Int, elsPerSection: Int) = {
    val makeFullStringBorder = makeFullBorder(sections, elsPerSection)(_, _, _)
    position match {
      case "top" => makeFullStringBorder(topLeft, topMid, topRight)
      case "middle" => makeFullStringBorder(leftMid, midMid, rightMid)
      case "bottom" => makeFullStringBorder(bottomLeft, bottomMid, bottomRight)
      case _     => ""
    }
  }

  private def makeFullBorder(sections: Int, elsPerSection: Int)(left: String, mid: String, right: String) =
    List(
      left,
      makeSectionBorder(mid, sections, elsPerSection),
      right,
    ).mkString

  private def makeSectionBorder(sep: String, sections: Int, elsPerSection: Int) =
    (makeSectionPart(sep, elsPerSection) * sections).init

  // Il +1 è dovuto al fatto che si vuole mettere uno spazio vuoto
  // sia prima sia dopo il contenuto
  // È possibile usare (*) anche tra String e Int in Scala, ed il funzionamento
  // è uguale a quello di Python ("-" * 3 = "---")
  private def makeSectionPart(sep: String, elsPerSection: Int) =
    List(horizontal * (elsPerSection * 2 + 1), sep).mkString
}