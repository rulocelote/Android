# Ejercios realizados durante el curso de Bedu

## Intent
Una Intent es un objeto de mensajería que puedes usar para solicitar una acción de otro componente de una app. Si bien las intents facilitan la comunicación entre componentes de varias formas.

#### Ejemplo de una intent explícita
Una intent explícita es una intent que se usa para iniciar un componente específico de la aplicación, como una actividad o un servicio particular en la aplicación. Para crear una intent explícita, define el nombre de componente del objeto Intent (todas las otras propiedades de la intent son opcionales).
Por ejemplo, si creaste un servicio en tu app denominado DownloadService, diseñado para descargar un archivo de la Web, puedes iniciarlo con el siguiente código:
´´´
// Executed in an Activity, so 'this' is the Context
// The fileUrl is a string URL, such as "http://www.example.com/image.png"
val downloadIntent = Intent(this, DownloadService::class.java).apply {
    data = Uri.parse(fileUrl)
}
startService(downloadIntent)
´´´

#### Ejemplo de una intent implicita
Una intent implícita especifica una acción que puede invocar cualquier aplicación en el dispositivo que puede realizar la acción. El uso de una intent implícita es útil cuando la aplicación no puede realizar la acción, pero otras aplicaciones probablemente sí, y quieres que el usuario elija qué aplicación usar.
Por ejemplo, si tienes contenido que quieres que el usuario comparta con otras personas, crea una intent con la acción ACTION_SEND y agrega extras que especifiquen el contenido para compartir. Cuando llamas a startActivity() con esa intent, el usuario puede elegir una aplicación mediante la cual compartir el contenido.
´´´
// Create the text message with a string
val sendIntent = Intent().apply {
    action = Intent.ACTION_SEND
    putExtra(Intent.EXTRA_TEXT, textMessage)
    type = "text/plain"
}

// Verify that the intent will resolve to an activity
if (sendIntent.resolveActivity(packageManager) != null) {
    startActivity(sendIntent)
}
´´´
