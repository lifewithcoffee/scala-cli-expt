package rlt.pkg1

object ImplicitKeyWordTest {

  def asIoCApproach(){
    trait Logger { def log(s: String) }

    class LoggerImpl extends Logger {
      def log(s: String) = println("LOG: " + s)
    }

    def asIoC(s: String)(implicit logger: Logger) {
      logger.log(s)
    }

    implicit val defaultLogger = new LoggerImpl

    asIoC("Hello")  // use "implicit" as IoC approach
  }

  def asExtensionMethod(){
    implicit class AsExtensionMethodForString(val s: String){  // ---> NOTE: implicit class
      def makeChristmasy = println("***" + s + "***")
    }
    "Hello".makeChristmasy  // use "implicit" as extension method
  }

  def asImplicitTypeCasting(){
    def log(s: String) = {
      println(s)
    }

    implicit def int2String(i: Int): String = "value is: " + i.toString  // NOTE: will raise a warning

    log(1)
  }

  def main(args: Array[String]) {
    asIoCApproach
    asExtensionMethod
    asImplicitTypeCasting
  }
}

