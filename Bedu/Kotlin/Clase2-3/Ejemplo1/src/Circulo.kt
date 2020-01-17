import kotlin.math.pow

class Circulo(var radio:Double):Figura() {

    val pi = 3.1416

    override fun calcularArea(): Double {
        return pi.times(radio.pow(2))
    }

    override fun calcularPerimetro(): Double {
        return 2.times(pi).times(radio)
    }
}