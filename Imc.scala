import java.util.Scanner

object Imc extends App {
  val poids = List("Poids insuffisant", "Poids normal", "Excès de poids", "Obésité, classe I", "Obésité, classe II", "Obésité, classe III")
  val risques = List("Accru", "Moindre", "Accru", "Élevé", "Très élevé", "Extrêmement élevé")
  val imcs = List(0, 18.5, 25, 30, 35, 39.9)

  def getUserInputs: (Double, Double) = {
    val lecteur = new Scanner(System.in)
    var poid: Double = 0
    var taille: Double = 0

    try {
      while (poid == 0 || taille == 0) {
        println("Entrez votre poid: ")
        poid = lecteur.nextDouble()
        println("Entrez votre taille: ")
        taille = lecteur.nextDouble()
      }
    } catch { case _: Exception => getUserInputs }
    (poid, taille)
  }

  def calculImc(poid: Double, taille: Double): Double = poid / Math.pow(taille, 2)

  def classifyImc(imc: Double): (String, String) = {
    var i: Int = -1
    for (j <- imcs.indices) if (imc > imcs(j)) i += 1
    (poids(i), risques(i))
  }

  def createMessage(imc: Double, poid: String, risque: String): String = s"Votre IMC: $imc, $poid, risque: $risque"

  def main(): Unit = {
    val (poid, taille) = getUserInputs
    val imc = calculImc(poid, taille)
    val (poid_cat, risque_cat) = classifyImc(imc)
    val msg = createMessage(imc, poid_cat, risque_cat)
    println(msg)
  }

  main()
}
