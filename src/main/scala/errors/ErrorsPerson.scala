package errors

sealed trait ErrorsPerson extends Exception

case class WrongName(message: String) extends ErrorsPerson
case class WrongAge(message: String) extends ErrorsPerson
case class WrongDni(message:String) extends ErrorsPerson