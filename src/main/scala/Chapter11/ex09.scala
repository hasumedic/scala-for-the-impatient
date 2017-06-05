package Chapter11

class RichFile(val fullName: String)

object RichFile {

  type Path = String
  type FileName = String
  type Extension = String

  def unapply(file: RichFile): Option[(Path, FileName, Extension)] = {
    val splitBySlash = file.fullName.split("/")

    val path = splitBySlash.dropRight(1).mkString("/")
    val filenameWithExtension = splitBySlash.last
    val filename = filenameWithExtension.takeWhile(_ != '.')
    val extension = filenameWithExtension.split('.').last

    Some(path, filename, extension)
  }
}
