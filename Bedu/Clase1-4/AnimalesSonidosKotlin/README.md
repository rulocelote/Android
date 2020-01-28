# Uso de MediaPlayer

### Ejemplo de uso de MediaPlayer
```kotlin
//Para agregar sonidos se debe crear la carpeta raw dentro de res
//Funcion encargada de ejecutar el sonido del animal seleccionado

var sonido: MediaPlayer? = null
animalesList["perro"] = R.raw.perro

fun ejecutaSonido(nombreAnimal: String) {
    val ani: Int? = animalesList.get(nombreAnimal)
    if (sonido != null) sonido!!.stop()
    if(ani != null) MediaPlayer.create(applicationContext, ani).start()
}
```

## Imagenes dle proyecot AnimalesSonidos
![sonido](imagenes/sonidos.png)

## Ligas para mas informacion

### MediaPlayer
https://developer.android.com/reference/android/media/MediaPlayer
