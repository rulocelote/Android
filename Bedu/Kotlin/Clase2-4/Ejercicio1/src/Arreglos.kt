lateinit var fila1:IntArray
lateinit var fila2:IntArray
lateinit var matriz:Array<IntArray>

fun main(args: Array<String>){
    fila1 = intArrayOf(1,2,3,4)
    fila2 = intArrayOf(5,6,7,8)
    matriz = arrayOf(fila1,fila2, intArrayOf(7,8,9,10))

    for(i in 0 until matriz.size){
        for(j in 0 until matriz[i].size){
            println("Matriz = ${matriz[i][j]}")
        }
    }
}