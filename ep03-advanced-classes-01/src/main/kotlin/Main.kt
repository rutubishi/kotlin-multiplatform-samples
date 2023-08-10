fun main(args: Array<String>) {
    val crane = Bird(age = 13, weight = 8.5, name = "Crane")
    crane.breed("1 month")
    println("Original Crane: ${crane.gestation}")
    val falcon = Falcon
    falcon.breed("5 months")
    println("Falcon: $falcon")
    falcon.age = 50
    println("Falcon: $falcon")
    println("Equals: ${eagle == falcon}")
    val reptile = Reptile.create()
    val turtle = Reptile()
    turtle.name = "Turtle"
    turtle.lifespan = 100
    println("$reptile")
    println("Turtle ==== \n $turtle")
    println(Reptile.move("east"))
}

data class Bird(
    val age: Int,
    val weight: Double,
    var name: String
){
    var homeReared: Boolean = true
        get() = if(field) age < 10 else field
        set(value) {
           field = if (value) age < 10 else field
        }

    lateinit var gestation: String

    fun breed(period: String){
        gestation = period
    }

}


data object Falcon {
    var age: Int = 10
    lateinit var gestation: String

    fun breed(period: String){
        gestation = period
    }

    override fun toString(): String {
        return "Age: $age"
    }

}

val eagle = object {
    val age: Int = 50
    override fun toString(): String {
        return "Age: $age"
    }

    override fun equals(other: Any?): Boolean {
        return if(other == null)
            false
        else if (other.toString() == this.toString())
            true
        else
            false
    }
}

interface Animal {
    fun move(direction: String): String
}

class Reptile {
    var name: String = ""
    var lifespan: Int = 0
    private val coldBlooded: Boolean = false
    private val hasScales: Boolean = true

    override fun toString(): String {
        return """
            name: $name
            lifespan: $lifespan
            cold blooded: $coldBlooded
            has scales: $hasScales
        """.trimIndent()}

    companion object : Animal {

        @JvmStatic val croc = Reptile()

        override fun move(direction: String): String {
            return "This Crocodile is swimming to the $direction"
        }

        @JvmStatic
        fun create(): Reptile {
            croc.name = "Crocodile"
            croc.lifespan = 60
            return croc
        }
    }

}






