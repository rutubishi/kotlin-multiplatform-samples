package components

import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.js.onClickFunction
import org.w3c.dom.Node

fun Node.navbar(){
    append {
        nav {
            id = "navigation-bar"
            div {
                id = "navigation-bar"

                a {
                    href = "/"
                    target = "_blank"
                    + "RecipeRoom"
                }

                div {
                    a {
                        href = "/home"
                        + "Home"
                    }

                    a {
                        href = "/home"
                        + "Offer"
                    }

                    a {
                        href = "/service"
                        + "Service"
                    }

                    a {
                        href = "/menu"
                        + "Menu"
                    }

                    a {
                        href = "/about"
                        + "About Us"
                    }
                }

                div {
                    button {
                        id = "login-btn"
                        classes = setOf("btn")
                        onClickFunction = {
                            println("Login: ")
                        }
                        + "Login"
                    }

                    button {
                        id = "signup-btn"
                        classes = setOf("btn")
                        onClickFunction = {
                            println("Sign Up: ")
                        }
                        + "Sign Up"
                    }
                }

            }
        }
    }
}