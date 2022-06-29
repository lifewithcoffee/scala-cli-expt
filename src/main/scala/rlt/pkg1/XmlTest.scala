package rlt.pkg1

import scala.xml.PrettyPrinter

object XmlTest {

  val name = "RL";
  val dateString = java.text.DateFormat.getDateInstance().format(new java.util.Date())

  def printXmlTemplate {
    val xml_string =
      <dateMsg addressedTo={name}>
        <test>
          Hello, {name}! Today is {dateString}
        </test>
        <test>
          test
        </test>
      </dateMsg>;

    var printer = new PrettyPrinter(80,8) // _note_: 80 is line width, 8 is indent space number
    println(printer.format(xml_string))
  }

  def main(args: Array[String]){
    printXmlTemplate
  }
}
