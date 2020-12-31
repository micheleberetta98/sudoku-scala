package pretty

// Indica i tipi che sono "pretty-printable"
trait Prettifiable {
  def toPrettyString(): String
}