import DatabaseHelper
class Menu () {
    fun opciones(){
        println("OPERACIONES A REALIZAR")
        println("____________________________________")
        println("|1 - Registrar un nuevo usuario    |")
        println("|2 - Consultar usuarios existentes |")
        println("|3 - Borrar un usuario             |")
        println("|4 - Editar un usuario             |")
        println("|0 - Cerrar                        |")
        println("|__________________________________|")
        val eleccion = readlnOrNull()?: 0

        when(eleccion){
            "1" ->  registrar()
            "2" ->  consultar()
            "3" ->  editar()
            "4" ->  cerrar()
            "0" ->  registrar()
        }
    }

    fun registrar (){
        println("NOMBRE:")
        val nombre = readlnOrNull()
        println("EDAD:")
        val edad = readlnOrNull()
        println("SEXO:")
        val sexo = readlnOrNull()
        if (!nombre.isNullOrEmpty() && !edad.isNullOrEmpty() && !sexo.isNullOrEmpty()) {
            val edadInt = edad.toIntOrNull()
            if (edadInt != null){
                val dbHelper = DatabaseHelper()
                dbHelper.registrarUsuario(Usuario(nombre,edadInt,sexo))
            }
        } else {
            println("Error al registar")
        }
    }

    fun consultar (){

    }

    fun editar () {

    }

    fun cerrar(){

    }

}