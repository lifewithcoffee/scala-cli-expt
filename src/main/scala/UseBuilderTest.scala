import org.rogach.scallop._

// see: https://github.com/scallop/scallop/wiki/Using-the-builder
object UseBuilderTest extends App{

  val opts = Scallop(List("-d","--num-limbs","1"))
    .version("test 1.2.3 (c) 2012 Mr Placeholder")

    .banner("""Usage: test [OPTION]... [pet-name]
              |test is an awesome program, which does something funny
              |Options:
              |""".stripMargin)
    .footer("\nFor all other tricks, consult the documentation!")

    .opt[Boolean]("donkey", descr = "use donkey mode")
    .opt[Int]("num-limbs", 'k',
      "number of libms", required = true)
    .opt[List[Double]]("params")
    .opt[String]("debug", hidden = true)
    .props[String]('D',"some key-value pairs")

    // you can add parameters a bit later
    .args(List("-Dalpha=1","-D","betta=2","gamma=3", "Pigeon"))
    .trailArg[String]("pet name")

    .verify

  println(opts.help)
}
