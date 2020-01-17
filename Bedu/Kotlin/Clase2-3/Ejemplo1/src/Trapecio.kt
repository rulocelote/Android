class Trapecio(var baseMayor:Double, var baseMenor:Double, var lado3:Double, var lado4:Double, var altura:Double):Figura() {
    override fun calcularArea(): Double {
        return altura.times((lado3.plus(lado4)/2))
    }

    override fun calcularPerimetro(): Double {
        return baseMayor.plus(baseMayor).plus(lado3).plus(lado4)
    }
}