# Uso de Intent y Toast

## Ejemplos de codigo relevante en la actividad

### Ejemplo de envio de informacion e inicio de otra actividad con Intent

```kotlin
//Enviar datos e iniciar otra actividad
val intent = Intent(this, MayorEdad::class.java).apply {
    putExtra("edad",edad)
}
startActivity(intent)
```

```kotlin
//Recuperar datos enviados en Activity2
var edad = intent.getStringExtra("edad")
txtEdadMayor.setText("Adelante con: \n $edad años")
startActivity(intent)
```
### Mostrar mensajes con Toast
```kotlin
Toast.makeText(this,result,Toast.LENGTH_SHORT).show()
```

### Recuperar datos y tag 
```xml
android:tag="suma"
```
```kotlin
var tag = view.tag
```

## Imagenes del proyecto calculadora

## Imagenes del proyecto IntercambioColores
(https://github.com/charlye917/Android/tree/master/Bedu/kotlin/Clase1-2/cambia_colores1.png)

## Ligas importantes para mas informacion

### Intents y filtros de intents

https://developer.android.com/guide/components/intents-filters?hl=es

### Intents comunes
https://developer.android.com/guide/components/intents-common?hl=es

### Toast
https://developer.android.com/reference/android/widget/Toast


