class Triangulo(var base:Double, var lado2:Double, var lado3:Double,var altura:Double):Figura(){
    override fun calcularArea(): Double {
        return (base.times(altura)).div(2)
    }

    override fun calcularPerimetro(): Double {
        return base.plus(lado2).plus(lado3)
    }
}