package Chapter11

object Exercise10 {

  object RichFile {
    def unapplySeq(file: RichFile): Option[Seq[String]] = Some(file.fullName.split("/").filter(_.nonEmpty))
  }

}

