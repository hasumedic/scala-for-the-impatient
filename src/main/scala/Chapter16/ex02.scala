package Chapter16

object ex02 extends App {

  val xml = <ul>
    <li>Opening bracket: [</li>
    <li>Closing bracked: ]</li>
    <li>Opening brace: {{</li>
    <li>Closing brace: }}</li>
  </ul>

  //A single opening brace would start a Scala block. In order to fix it, it needs to be prefixed by another brace
}
