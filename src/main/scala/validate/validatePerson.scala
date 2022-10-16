package validate

import cats.effect.IO
import entities.Person
import errors.{ErrorsPerson, WrongAge, WrongDni, WrongName}

case class validatePerson() {

  private def validateAge(age: Int): IO[Either[ErrorsPerson, Unit]] = {
    if (age < 18) IO.pure(Right()) else IO.pure(Left(WrongAge("medor de edad")))
  }

  private def validateName(name: String): IO[Either[ErrorsPerson, Unit]] = {
    if (name.length < 5) IO.pure(Right()) else IO(Left(WrongName("nombre muy  corto")))
  }

  private def validateDni(dni: Int): IO[Either[ErrorsPerson, Unit]] = {
    if (dni < 9000) IO.pure(Right()) else IO.pure(Left(WrongDni("dni muy  corto")))
  }

  def valdiatePersona(person: Person): IO[Either[ErrorsPerson, Person]] = {
    val result =
      for (
        _ <- validateName(person.name);
        _ <- validateAge(person.age);
        _ <- validateAge(person.age)
      ) yield Person(name = person.name, age = person.age, dni = person.dni)

    result.left
  }
}
