# Uso de Splash, Fragments, permisos y variables Map

### Ejemplo del uso de splash con Handler
```kotlin
var handler = Handler()
handler.postDelayed({ abrirMain() }, 3000)
```

### Ejemplo para pedir permisos 
```xml
<!--Para poder perdir permisos es necesario primero escribir los permisos
que necesitamos en el manifest-->
<uses-permission android:name="android.permission.READ_CALENDAR"/>
<uses-permission android:name="android.permission.READ_CONTACTS"/>
<uses-permission android:name="android.permission.CAMERA"/>
<uses-permission android:name="android.permission.READ_SMS"/>
```
```kotlin
fun permisos(tag:String):Boolean{
  var version = Build.VERSION.SDK_INT

  if(version>=Build.VERSION_CODES.M){
      if(ContextCompat.checkSelfPermission(applicationContext, permisos.get(tag).toString()) != PackageManager.PERMISSION_GRANTED){
          ActivityCompat.requestPermissions(this@MainActivity, arrayOf(permisos[tag]), 1000)
          return false
      }else{ return true }
  } else {
      Toast.makeText(applicationContext, "No es necesario pedir permisos", Toast.LENGTH_SHORT).show()
      return true
  }
}
```

### Ejemplo del uso de Fragments
```kotlin
//Variables de tipo Map
    var permisos: Map<String,String>  = mapOf("camara" to  Manifest.permission.CAMERA, "mensaje" to Manifest.permission.READ_SMS, "contactos" to Manifest.permission.READ_CONTACTS, "calendario" to Manifest.permission.READ_CALENDAR)
    var fragment: Map<String,Fragment> = mapOf("camara" to CamaraFragment(), "mensaje" to MensajesFragment(), "contactos" to ContactosFragment(), "calendario" to CalendarioFragment())
```
```kotlin
val fragmentManager = supportFragmentManager
var fragmentTransaction = fragmentManager.beginTransaction()
var tag = view.getTag().toString()
if(permisos(tag)){
    //fragmentTransaction.remove(fragment[tag]!!)
    //fragmentTransaction.add(R.id.contenedor, fragment[tag]!!,"f1")
    fragmentTransaction.replace(R.id.contenedor, fragment[tag]!!,"f1")
    fragmentTransaction.addToBackStack("f1")
    fragmentTransaction.commit()
}
```
