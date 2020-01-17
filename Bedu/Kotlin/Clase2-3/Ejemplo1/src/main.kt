fun main(args:Array<String>){
    val cuadrado:Cuadrado = Cuadrado(5.0)
    val cArea = cuadrado.calcularArea()
    val cPerimetro = cuadrado.calcularPerimetro()

    val cuadrado2:Figura = Cuadrado(6.0)

    val circulo = Circulo(10.toDouble())
    var cirPerimetro = circulo.calcularPerimetro()
    var cirArea = Math.round(circulo.calcularArea().times(100)/100)//redondeo de ceros, con truncate le quita todos los decimales

    var triangulo = Triangulo(10.0,10.0,10.0,20.0)
    println("El area del cuadrado es: $cArea y el perimetro $cPerimetro")
    println("El area del circulo es: $cirArea y el perimetro $cirPerimetro")

    //println("El area del cuadrado es: ${cuadrado2.calcularArea()} y el perimetro ${cuadrado2.calcularPerimetro()}")

}