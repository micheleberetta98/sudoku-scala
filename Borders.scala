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

  private def makeSectionPart(sep: String, elsPerSection: Int) =
    List(horizontal * (elsPerSection * 2 + 1), sep).mkString
}