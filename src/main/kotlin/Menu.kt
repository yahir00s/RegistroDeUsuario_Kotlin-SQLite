import DatabaseHelper
class Menu () {
    fun opciones(){
        println("OPERACIONES A REALIZAR")
        println("____________________________________")
        println("|1 - Consultar usuarios existentes |")
        println("|2 - Registrar un nuevo usuario    |")
        println("|3 - Editar un usuario             |")
        println("|4 - Borrar un usuario             |")
        println("|0 - Cerrar                        |")
        println("|__________________________________|")
        val eleccion = readlnOrNull()?: 0

        when(eleccion){
            "1" ->  consultar()
            "2" ->  registrar()
            "3" ->  editar()
            "4" ->  borrar()
            "0" ->  cerrar()
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
        println("Usuarios Registrados")
        val dbHelper = DatabaseHelper()
        dbHelper.consultarUsuarios()
    }

    fun editar () {
        println("USUARIOS EXISTENTES")
        consultar()
        println("~~~~~~~~~~~~~~~~~~~~~~~")
        val dbHelper = DatabaseHelper()
        println("ID DEL USUARIO A EDITAR")
        val id = readlnOrNull()
        println("Nuevo nombre")
        val nombre = readlnOrNull()
        val idInt = id?.toIntOrNull()
        if (!nombre.isNullOrEmpty() && idInt != null) {
            dbHelper.editarUsuarios(nombre, idInt)
        }
        println("~~~~~~~~~~~~~~~~~~~~~~~")
        opciones()
    }
    fun borrar () {
        println("USUARIOS EXISTENTES")
        consultar()
        println("~~~~~~~~~~~~~~~~~~~~~~~")
        println("ID DEL USUARIO A ELIMINAR")
        val id = readlnOrNull()?.toIntOrNull()
        val db = DatabaseHelper()
        if (id != null) {
            db.borrarUsuario(id)
        }


    }

    fun cerrar(){

    }

}