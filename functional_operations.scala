object soso extends App {

  val myList2 = List("Introduction à la Programmation",
    "Pratique de la Programmation",
    "Structure de données",
    "Principe de la Programmation",
    "Algorithmie",
    "Langages de Programmation")


  // Exer 1, find sum
  // functional
  val myList = List(15, 39, 22, 98, 37, 19, 5)
  // method 1
  val sum1: Int = myList sum // 235
  // method 2
  val sum2: Int = myList.reduce((a, b) => a + b) // 235


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
}
