import org.rogach.scallop._

object Main extends App{

  val opts =  new ScallopConf(args) {
    banner("""
NDE/SCEP Certificate enrollment prototype

Example: java -jar demo.jar --dn CN=Test --nde-url http://www.example.com --password password

For usage see below:
           """)

    val ndeUrl = opt[String]("nde-url")
    val password = opt[String]("password", descr = "set the password")
    val capi = toggle("capi", prefix = "no-", descrYes = "enable adding to Windows key-store", descrNo = "disable adding to Windows key-store")
    val version = opt[Boolean]("version", noshort = true, descr = "Print version")
    val help = opt[Boolean]("help", noshort = true, descr = "Show this message")
  }

  println(opts.password)
}
