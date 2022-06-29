package rlt.pkg1

import scala.xml.PrettyPrinter

object XmlTest {

  val name = "RL";
  val dateString: String = java.text.DateFormat.getDateInstance().format(new java.util.Date())

  def printXmlTemplate(): Unit = {
    val xml_string =
      <dateMsg addressedTo={name}>
        <test1>
          <test2>
            Hello, {name}! Today is {dateString}
          </test2>
          <test2>
            Hello, {name}! Today is {dateString}
          </test2>
        </test1>
        <test1>
          test
        </test1>
      </dateMsg>;

    var printer = new PrettyPrinter(80,4) // _note_: 80 is line width, 4 is indent space number
    println(printer.format(xml_string))
  }

  def main(args: Array[String]): Unit = {
    printXmlTemplate()
  }
}
