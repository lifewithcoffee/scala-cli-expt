package rlt.pkg1

object StringTest {

  def demoMultilineString{
    val plain =
      """
      |this is
      |multiple
      |string
      """.stripMargin

    println(plain)
  }

  def demoMultilineString2{
    val plain =
      """
      this is
      multiple
      string2
      """.stripMargin

    println(plain)
  }

  def simpleTemplate(name: String){
    println(s"Hi $name")
  }

  def main(args: Array[String]){
    demoMultilineString
    demoMultilineString2
    simpleTemplate("RL")
  }
}
