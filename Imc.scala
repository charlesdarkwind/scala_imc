import scala.io.Source

object lists extends App {

  val myList2 = List("Introduction à la Programmation",
    "Pratique de la Programmation",
    "Structure de données",
    "Principe de la Programmation",
    "Algorithmie",
    "Langages de Programmation")

  //=============================================================================================
  // Exer 1, find sum
  // functional
  val myList = List(15, 39, 22, 98, 37, 19, 5)
  // method 1
  val sum1: Int = myList.sum // 235
  // method 2
  val sum2: Int = myList.reduce((a, b) => a + b) // 235

  //=============================================================================================
  // Exer 2
  // Combien d'éléments contiennent le mot "Programmation"
  val res1 = myList2.count(p => p contains "Programmation") // 4

  // Combien d'éléments ne contiennent pas le mot "Programmation"
  val res2 = myList2.count(p => !(p contains "Programmation")) // 2

  // Déterminer s’il y’a au moins un élément qui ne contient pas le mot "Programmation"
  val res3 = myList2.count(p => !(p contains "Programmation")) >= 1 // true

  // Déterminer si la lettre o (maj ou min) est présente dans tous les éléments de la collection
  val res4 = myList2.count(p => p.toLowerCase contains "o") == myList2.length // true

  // Déterminer s'il y'a au moins un élément qui contient le mot "Programmation"
  val res5 = myList2.count(p => p contains "Programmation") >= 1 // true

  println(res1, res2, res3, res4, res5)

  //=============================================================================================
  // Exer 3
  // Elements contenant un espace
  val res6 = myList2.filter(e => e contains " ")

  // Sans espaces
  val res7 = myList2.filter(e => !(e contains " "))

  println(res6)
  println(res7)

  //=============================================================================================
  // Exer 4
  // 1. lire le fichier, afficher le temps pris à le lire et le nombre de mots dans le fichier
  def lireFichier(file_path: String): Array[String] = {
    val temps_depart = System.currentTimeMillis()
    val F = Source.fromFile(file_path)
    var tab = new Array[String](0)

    for (ligne <- F.getLines()) {
      tab = tab :+ ligne.mkString
    }

    val len = tab.length
    val duree = System.currentTimeMillis() - temps_depart
    println(s"Nombre de mots: $len. Duree de l'execution: $duree ms.")

    tab
  }

  val mots = lireFichier("C:\\Users\\guild\\IdeaProjects\\IMC\\src\\english_words.txt")


  // 2. Afficher tout les mots contenat "issis"
  mots
    .filter(mot => mot contains "issis")
    .foreach(mot => println(mot))


  // 3. Mot de longueur superieur ou egale a 18
  mots
    .filter(mot => mot.length >= 18)
    .foreach(mot => println(mot))


  // 4. Mots ne contenant pas de voyelles
  def contains_no_vowel(mot: String): Boolean = {
    val voyelles = List('a', 'e', 'i', 'o', 'u', 'y')
    var bool = true
    voyelles.foreach(v => {
      if (mot contains v) bool = false
    })
    bool
  }

  val resp = mots filter contains_no_vowel
  resp foreach println



  //=============================================================================================
  // Exer 5
  // 1. Obtenir la collection transformée qui contient la longueur de chacun des éléments de la collection d'origine
  val res8 = myList2.map(el => el.length)
  println(res8)

  // 2. Obtenir la collection transformée qui contient les éléments en majuscule de chaque élément de la collection d'origine
  val res9 = myList2.map(el => el.toUpperCase)
  println(res9)

  // 3. Obtenir la collection transformée qui a chaque élément préfixé par le mot "Livre:" au début de chaque élément de la collection d'origine
  val res10 = myList2.map(el => "Livre: " + el)
  println(res10)
}

