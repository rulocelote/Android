package com.sem.empresasappandcmal.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.widget.ImageView
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import java.io.ByteArrayOutputStream
import java.io.File

fun decoder(base64Str: String): Bitmap {
    val imageBytes = android.util.Base64.decode(base64Str, android.util.Base64.DEFAULT)
    return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
}

fun encoder(filePath: String): String{
    val bytes = File(filePath).readBytes()
    return android.util.Base64.encodeToString(bytes, android.util.Base64.DEFAULT)
}

//Funcion encargada de transformar una foto en un bitmap bajandole la resolucion
fun resizeBitmap(photoPath: String?, targetW: Int, targetH: Int): Bitmap? {
    val bmOptions = BitmapFactory.Options()
    bmOptions.inJustDecodeBounds = true
    BitmapFactory.decodeFile(photoPath, bmOptions)
    val photoW = bmOptions.outWidth
    val photoH = bmOptions.outHeight
    var scaleFactor = 1
    if (targetW > 0 || targetH > 0) {
        scaleFactor = Math.min(photoW / targetW, photoH / targetH)
    }
    bmOptions.inJustDecodeBounds = false
    bmOptions.inSampleSize = scaleFactor
    return BitmapFactory.decodeFile(photoPath, bmOptions)
}

//Funcion encargada de convertir un bitmap a un string para poder enviarla
fun BitMapToString(bitmap: Bitmap): String {
    val baos = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos)
    val bytes = baos.toByteArray()
    return android.util.Base64.encodeToString(bytes, android.util.Base64.DEFAULT)
}

//funcion encargada de mostrar en el imageview seleccionado
fun ImageView.setPic(path:String) {
    val targetW: Int = this.width
    val targetH: Int = this.height
    val bmOptions = BitmapFactory.Options().apply {
        inJustDecodeBounds = true
        val photoW = 400
        val photoH = 400
        val scaleFactor: Int = Math.min(photoW / targetW, photoH / targetH)

        inJustDecodeBounds = false
        inSampleSize = scaleFactor
    }

    BitmapFactory.decodeFile(path, bmOptions)?.also { bitmap ->
        val rotation = rotationPhoto(bitmap)
        val roundedDrawable: RoundedBitmapDrawable = RoundedBitmapDrawableFactory.create(resources, rotation)

        roundedDrawable.cornerRadius = rotation.getHeight().toFloat()
        this.setImageDrawable(roundedDrawable);
    }
}

fun rotationPhoto(bitmap: Bitmap, width:Int = 300, height:Int = 300): Bitmap {
    val matrix = Matrix()
    matrix.postRotate(270f)
    val scaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true)
    val rotatedBitmap = Bitmap.createBitmap(
        scaledBitmap,
        0,
        0,
        scaledBitmap.width,
        scaledBitmap.height,
        matrix,
        true
    )
    return rotatedBitmap
}
