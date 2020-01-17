class Cuadrado(var lado:Double): Figura(){

    override fun calcularArea(): Double {
        return lado.times(lado)
    }

    override fun calcularPerimetro(): Double {
        return lado.plus(lado).plus(lado).plus(lado)
    }
}