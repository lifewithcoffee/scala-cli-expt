import java.util.NoSuchElementException

import org.rogach.scallop._;
import org.rogach.scallop.exceptions.{RequiredOptionNotFound, ScallopException}

object CmdLineTest extends App {

  // test by using arguments:
  // --help
  // -k 3 -p 132.32 -D 111="good" some_pet_name palm -h 30 fancy_name
  object Conf extends ScallopConf(args){
    guessOptionName = true
    version("test 1.2.3 (c) 2012 Mr Placeholder")
    banner("""Usage: test [OPTION]... [pet-name]
             |test is an awesome program, which does something funny
             |Options:
             |""".stripMargin)
    footer("\nFor all other tricks, consult the documentation!")

    // options
    val donkey = opt[Boolean]("donkey", descr = "use donkey mode")
    val monkeys = opt("monkeys", default = Some(2), short = 'm')
    val numberOfLimbs = opt[Int]("num-limbs", 'k', "number of limbs", required = true)
    val params = opt[List[Double]]("params")

    val debug = opt[String]("debug", hidden = true)

    // properties
    val properties = props[String]('D',"some key-value pairs")

    // trail arguments
    val petName = trailArg[String]("pet-name", descr = "pet name", required = false)  // the default "required" is true

    // sub commands
    val tree = new Subcommand("tree") {
      val height = opt[Double](descr = "how tall should the tree be?")
      val name = trailArg[String]("tree name", descr = "tree name")
    }

    val palm = new Subcommand("palm") {
      val height = opt[Double](descr = "how tall should the palm be?")
      val name = trailArg[String]("tree name", descr = "palm name")
    }

    override def onError(e: Throwable) = e match { // check options with "required = true"
      case ScallopException(message) =>
        println("Error: " + message + "\n")
        println("Help information: \n")
        printHelp
        System.exit(1)
      case ex => super.onError(ex)
    }
  }

  println("args: " + args.toSeq + "\n")

  val conf = Conf

  try{
    // won't reach here when the arg is "--help"
    println("Conf.donkey():\t" + conf.donkey())
    println("Conf.monkeys():\t" + conf.monkeys())

    if( !conf.params.get.isEmpty) {
      println("Conf.params():\t" + conf.params())
    }

    println("Conf.numberOfLimbs():\t" + conf.numberOfLimbs())

    if(!conf.petName.isEmpty){
      println("Conf.petName():\t" + conf.petName())
    }

    if(!conf.properties.isEmpty){
      println("Conf.properties(\"111\"):\t" + conf.properties("111"))
    }

    if(!conf.palm.height.get.isEmpty){
      println("Conf.palm.height():\t" + conf.palm.height())
    }

  }catch {
    case RequiredOptionNotFound(optionName) =>
      print("Error: required option not found: " + optionName)

    case e: NoSuchElementException =>
      println(e.printStackTrace())

    case e: Exception =>
      println("Error: " + e.getMessage)
      e.printStackTrace()
  }
}
