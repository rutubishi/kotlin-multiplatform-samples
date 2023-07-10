package pages

import components.navbar
import kotlinx.html.dom.append
import org.w3c.dom.Node

fun Node.mainApp(){
    append {
        navbar()
    }
}