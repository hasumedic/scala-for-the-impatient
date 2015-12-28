package Chapter08

class Person(val name: String) {
  override def toString = getClass.getName + "[name" + name + "]"
}

class SecretAgent(codename: String) extends Person(codename) {
  override val name = "secret"
  override val toString = "secret"
}

// How many "name" fields are there? How many "name" getter methods are there? 1 in each class

//public class Chapter8.Person {
//  private final java.lang.String name;
//  public java.lang.String name();
//  public java.lang.String toString();
//  public Chapter8.Person(java.lang.String);
//}
//
//public class Chapter8.SecretAgent extends Chapter8.Person {
//  private final java.lang.String name;
//  private final java.lang.String toString;
//  public java.lang.String name();
//  public java.lang.String toString();
//  public Chapter8.SecretAgent(java.lang.String);
//}
