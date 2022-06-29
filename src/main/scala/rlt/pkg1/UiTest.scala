package rlt.pkg1

import scala.swing.{Button, MainFrame, SimpleSwingApplication}

object UiTest extends SimpleSwingApplication {
  def top = new MainFrame {
    title = "Hello, World!"
    contents = new Button {
      text = "Click Me!"
    }
  }
}
