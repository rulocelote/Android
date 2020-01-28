# Uso de RecyclerView, ScrollView y el uso CheckBox y RadioButtons
### Ejemplo del uso de RecyclerView

```kotlin
//ADAPTER
class miAdaptador(var listaCuadros: ArrayList<Cuadros>,val context:Context):RecyclerView.Adapter<miAdaptador.miViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): miViewHolder {
        var vista = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return miViewHolder(vista)
    }

    override fun getItemCount(): Int {
        return listaCuadros.size
    }

    override fun onBindViewHolder(holder: miViewHolder, position: Int) {
        holder.nombre.text = listaCuadros[position].nombre
        holder.descripcion.text = listaCuadros[position].descripcion
        holder.imagen.setImageResource(listaCuadros[position].imagen)
        holder.foto.setImageResource(listaCuadros[position].foto)
        holder.pad.setOnClickListener { Toast.makeText(context,holder.pad.idDescripcion.text,Toast.LENGTH_SHORT).show() 
        }
    }

    class miViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val pad = itemView.padre
        val nombre = itemView.idNombre
        val descripcion = itemView.idDescripcion
        val imagen = itemView.idImagen
        val foto = itemView.idFoto
    }
}
```

```kotlin
//Enlazar
var miManager = LinearLayoutManager(this)
myRecycler.layoutManager = miManager
myRecycler.adapter = miAdaptador(lista,this)
```

![recyclerview](Imagenes/recycler.gif)
### Ejemplo de ScrollView

```kotlin
//Poner el icono en el action bar
supportActionBar!!.setDisplayShowHomeEnabled(true)
supportActionBar!!.setIcon(R.mipmap.ic_launcher_foreground)
```
![scrollview](Imagenes/ScrollView.png)

### Ejemplo de CheckBox y RadioButtons
![check](Imagenes/RadioButtons.png)
En este proyecto se pone a prueba el uso de radiogroups, radiobutons y checkbox
