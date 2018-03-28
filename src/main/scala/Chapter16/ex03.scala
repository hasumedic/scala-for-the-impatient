package Chapter16

import scala.xml.Text

object ex03 extends App {


  val xml: String = <li>Fred</li> match {
    case <li>{Text(t)}</li> => t
  }

  println(xml)


// This "Fred" doesn't get converted into Text("Fred"), but to Atom("Fred"), hence producing a match error

//    val xml2 = <li>{"Fred"}</li> match {
//      case <li>{Text(t)}</li> => t
//    }
//
//    println(xml2)

}
