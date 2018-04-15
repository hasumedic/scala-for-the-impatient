package Chapter17

object ex08 {

  //Why can't you define a 'replaceFirst' method with the following signature in a mutable Pair[T]?
  // def replaceFirst[R >: T](newFirst: R) { first = newFirst }

  // The main problem in a mutable structure is that types are 'fixed'. It cannot reassign a different type R on a
  // covariant [+T], when [R >: T]

}
