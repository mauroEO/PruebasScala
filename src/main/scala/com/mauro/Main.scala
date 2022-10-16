package com.mauro

import slick.jdbc.PostgresProfile.api._

object Main extends App {
/*
  def s: Either[Throwable, Int] = Right(10)

  val cc: Either[Throwable, String] = s.map(x => x.toString)

  def s2: Option[Either[Throwable, Int]] = Some(Right(10))

  val cc2: Option[String] = s2.map(_.toString)


  println(patron("uno"))


  def patron(palabra: String): Int = {
    palabra match {
      case "uno" => 1
      case _ => 1000000

    }
  }

  def tipoDeAnimal(animal:List[Animal]):String={
    animal match {
      case Bird(name) => name
      case Fish(name) => name
      case Mammal(name, selcharco) => selcharco match {
        case true => name+" es del mar"
        case false => name+" No es del mar"
      }
      case _ => "esto no se que mierda es"
    }

  }
*/

}

abstract class Animal
case class Mammal(name: String, fromSea: Boolean) extends Animal
case class Bird(name: String) extends Animal
case class Fish(name: String) extends Animal
case class Perro(name: String) extends Animal
