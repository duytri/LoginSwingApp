package main.scala

import swing._
import scala.swing.BorderPanel.Position._

object LoginSwingApp extends SimpleSwingApplication {
  val ui = new BorderPanel {
    //content
  }

  def top = new MainFrame {
    title = "title"
    contents = ui
  }

  val auth = new LoginDialog().auth.getOrElse(throw new IllegalStateException("You should login!!!"))
}

case class Auth(userName: String, password: String)

class LoginDialog extends Dialog {
  var auth: Option[Auth] = None
  val userName = new TextField
  val password = new PasswordField

  title = "Login"
  modal = true

  contents = new BorderPanel {
    layout(new BoxPanel(Orientation.Vertical) {
      border = Swing.EmptyBorder(5,5,5,5)

      contents += new Label("User Name:")
      contents += userName
      contents += new Label("Password:")
      contents += password
    }) = Center

    layout(new FlowPanel(FlowPanel.Alignment.Right)(
      Button("Login") {
        if (makeLogin()) {
          auth = Some(Auth(userName.text, password.text))
          close()
        } else {
          Dialog.showMessage(this, "Wrong username or password!", "Login Error", Dialog.Message.Error)
        }
      }
    )) = South
  }

  def makeLogin() = true // here comes you login logic

  centerOnScreen()
  open()
}