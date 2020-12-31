package pretty

object Separators extends Enumeration {
  type T = Value

  val Hor = Value("─")
  val TopMid = Value("┬")
  val TopLeft = Value("┌")
  val TopRight = Value("┐")
  val BtmMid = Value("┴")
  val BtmLeft = Value("└")
  val BtmRight = Value("┘")
  val Vertical = Value("│")
  val LeftMid = Value("├")
  val MidMid = Value("┼")
  val RightMid = Value("┤")
}