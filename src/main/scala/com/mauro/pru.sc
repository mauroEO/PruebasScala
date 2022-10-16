//import io.jvm.uuid._

import scala.util.matching.Regex
/*
val random = UUID.random
val texto:String = random.toString
val texto2:String=random.string
val SubmitEventRoute(UUID(eventId)) = "/event/EF72505A-A9A6-4CD7-A14C-8F27C96FD727/submit"
val id:String="3123123"
val completo:String= random+id

 */


val f = (x:Int) => x + 1
val f2 = f.compose((x:Int)=>x-1)
println(f(1))
print(f2(1))
f.toString()



val funcionLoca = List(1,2,3).map{
  case 1 => 10
  case 2 => 20
  case 3 => 30
}
println(funcionLoca)

def uuid = java.util.UUID.randomUUID.toString
def uuid2 = java.util.UUID.randomUUID.toString

uuid
uuid2

val SubmitEventRoute: Regex = "/event/([^/]+)/submit".r



class caja(valor : Int){
  def upDate(f:Int=>Int)= f(valor)
  def imprimir(texto:String):Unit= println(s"$texto = $valor")
}

val insta =new caja(10)
insta.upDate(_*2)
insta.imprimir("teasdasdasdasdsaxto")

val que = ("a"+4)*3

var funcion:Int=>Int = x => x*2

funcion(10)

funcion = x=>x+2
funcion(10)

var suma = 0
var arrayDearray2 = Array(Array(1,2,3,4),Array(6,7,8,9))

var qqq = Array(1,2,3)

for(
  j <- qqq
  if j % 2!=0
)yield  j

for(array <-arrayDearray2; elemento <- array) suma += elemento
suma

val dos = arrayDearray2.map(_.map(x=>x+x))
dos
val f: Option[Int] = Some(1)

f.map(_+2)

var total = 0
val items= Array(1,2,3)
for (elemento <- items) total += elemento
total

val t: (Int, Boolean, String) = (1,true,"uno")

val (a,b,c) = t

t._1
t._2
t._3

val array = Array(1,2,3,4)
val array = Array[Int](1,2,3,4)

val arrayDearray = Array(Array(1,2,3,4),Array(6,7,8,9))
arrayDearray.flatten
arrayDearray.map(_.map(_+2))
arrayDearray.flatMap(x=>x.map(_+2))

val opt:Option[Int] = None


opt.getOrElse("no tiene nada")

opt match {
  case Some(value) => s"el valor tiene algo= $value"
  case None => "no tiene un choto"
}
/*
import cats.effect
import cats.effect.IO
import cats.effect.unsafe.implicits.global
import com.mauro.{Animal, Bird, Fish, Mammal, Perro}
import com.typesafe.config.ConfigException.IO

def tipoDeAnimal(animal: Animal): String = {
  animal match {
    case Bird(name) => name
    case Fish(name) => name
    case Mammal(name, selcharco) => if (selcharco) {
      name + " es del mar"
    } else {
      name + " No es del mar"
    }
    case _ => "esto no se que mierda es"
  }
}

tipoDeAnimal(Perro("asd"))

def patronDETipos(tipo: Any): String = {
  tipo match {
    case _: Int => "es un entero"
    case _: String => "esto es un string"
    case _ => "esto no se que mierda es"
  }
}

patronDETipos(1)
patronDETipos("asd")
patronDETipos(Perro("asd"))

def regexPatterns(toMatch: String): String = {
  val numeric = """(\d+)""".r
  val alphabetic = """([a-zA-Z]+)""".r
  val alphanumeric = """([a-zA-Z\d]+)""".r

  toMatch match {
    case numeric(value) => s"I'm a numeric with value $value"
    case alphabetic(value) => s"I'm an alphabetic with value $value"
    case alphanumeric(value) => s"I'm an alphanumeric with value $value"
    case _ => s"I contain other characters than alphanumerics. My value $toMatch"
  }
}

regexPatterns("1234")
regexPatterns("adasd")
regexPatterns("adas123123d")

def optionPAtron(option: Option[String]): String = {
  option match {
    case Some(value) => s"esto tieme algo el valor es: $value"
    case None => "esto no tiene nada"
  }
}

optionPAtron(Some("asd"))
optionPAtron(None)


def binderPatternMatching(animal: Any): String = {
  animal match {
    case m@Mammal(_, true) => s"${m.name} is a mammal from sea"
    case m@Mammal(_, _) => s"${m.name} is a mammal, fromSea:${m.fromSea}"
    case _ => "unknown animal"
  }
}
binderPatternMatching(Mammal("arriba", fromSea = true))
binderPatternMatching(Mammal("abajo", fromSea = false))

def binderPatternWithPartMatch(animal: Any): String = {
  animal match {
    case Mammal(name@"Lion", _) => s"$name is a mammal"
    case Mammal(name@"pescado", _) => s"$name naaaaaaaaa"
    case Mammal(name@"lagarto", _) => s"$name naaaaaaaaa"

    case _ => "unknown"
  }
}

binderPatternWithPartMatch(Mammal("Lion", fromSea = false))
binderPatternWithPartMatch(Mammal("garo", fromSea = false))
binderPatternWithPartMatch(Mammal("pescado", fromSea = false))
binderPatternWithPartMatch(Mammal("lagarto", fromSea = false))

sealed abstract class CardSuit

case class Spike() extends CardSuit

case class Diamond() extends CardSuit

case class Heart() extends CardSuit

case class Club() extends CardSuit

def algo(card: CardSuit): String = {
  card match {
    case Spike() => "Spike"
    case Diamond() => "Diamond"
    case Heart() => "Heart"
    case Club() => "Club"
  }
}

algo(Spike())
algo(Diamond())
algo(Heart())
algo(Club())

def closuresPatternMatching(list: List[Any]): List[Any] = {
  list.collect { case i: Int if i < 10 => i }
}

closuresPatternMatching(List(1, "", Spike(), 11, 3.4, Perro(""), 3, 4, 5))

case class Parasito(animal2: Animal, animal: Animal)

def paterParasito(parasito: Parasito): String = {
  parasito match {
    case Parasito(animal2: Perro, animal: Perro) => s"parasita a un perro llamado ${animal.name} "
    case Parasito(_, animal: Fish) => s"parasita a un pescado llamado $animal.name"
    case Parasito(_, animal2: Perro) => "parasita algo"
    case Parasito(_, _) => "parasita algo"

  }
}


paterParasito(Parasito(Fish("coco"), Perro("coco")))
paterParasito(Parasito(Perro("coco"), Fish("coco")))
paterParasito(Parasito(Fish("coco"), Mammal("coco", fromSea = false)))


def validarCuil(cuil: String): Either[Exception, String] = {
  Either.cond(cuil.length != 11, cuil, new Exception(""))
}
validarCuil("1234567890")
validarCuil("12345678902")

import cats.effect.IO

def suma = {
  IO("asdasdasd")
}


def add[A](xs: List[A], x: A): List[A] = x :: xs
def drop[A](xs: List[A]): (A, List[A]) = (xs.head, xs.tail)

val lista = List(1, 2, 3, 4, 5)

println(drop(lista))

add(lista, 99)


case class State(value: Int) {

  def flatMap(f: Int => State): State = {
    val newState = f(value)
    State(newState.value)
  }

  def map(f: Int => Int) = State(f(value))
}

sealed trait Direccion
case object este extends Direccion
case object oeste extends Direccion
case object norte extends Direccion
case object sur extends Direccion


def coso(direccion:Direccion):IO[String]= direccion match {
  case este => IO("este")
  case oeste => IO("oeste")
  case norte => IO("norte")
  case sur => IO("sur")
}

val swq: IO[String] = coso(este)

println(coso(este))

val lista = List.range(1,10)
val pares = lista.filter(i=> i%2 ==0)
val pares2 = lista.filter(_%2 ==0)


trait monada[E]{
  def flatMap[A,B](F:A=>monada[B]):monada[B]
  def map[A,B](F: A=>B ):monada[B]
  def pure[A](a:A):monada[A]
}

case class error(mensaje:String="esto es un errrrrror",numero:Int=10)

def calcular(a:Int,b:Int):Either[error,Int]={
  Either.cond(
    a>=b,
    a-b,
    error(numero=a-b))
}

calcular(10,5).map(_+5)
calcular(10,50)



 */