import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement


data class Usuario(val nombre: String, val edad: Int, val sexo: String)

class DatabaseHelper {
    private val connection: Connection

    init {
            connection = DriverManager.getConnection("jdbc:sqlite:usuarios.db")
            createTableIfNotExists()
    }

    private fun createTableIfNotExists() {
            val stmt: Statement = connection.createStatement()
            val createTableSQL = """
            CREATE TABLE IF NOT EXISTS usuarios (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT,
                edad INTEGER,
                sexo TEXT
            );
        """.trimIndent()
            stmt.executeUpdate(createTableSQL)
    }

    fun registrarUsuario(usuario: Usuario) {
            val stmt: Statement = connection.createStatement()
            val insertSQL = """
            INSERT INTO usuarios (nombre, edad, sexo)
            VALUES ('${usuario.nombre}', ${usuario.edad}, '${usuario.sexo}');
        """.trimIndent()
            stmt.executeUpdate(insertSQL)
            println("Usuario registrado correctamente")
    }

    fun consultarUsuarios() {
            val stmt: Statement = connection.createStatement()
            val resultSet: ResultSet = stmt.executeQuery("SELECT * FROM usuarios")

            while (resultSet.next()) {
                val id = resultSet.getInt("id")
                val nombre = resultSet.getString("nombre")
                val edad = resultSet.getInt("edad")
                val sexo = resultSet.getString("sexo")
                println("ID: $id, Nombre: $nombre, Edad: $edad, Sexo: $sexo")
            }
    }

    fun editarUsuarios(nombre: String, id: Int) {
        val stmt: Statement = connection.createStatement()
        val editar = """
            UPDATE usuarios SET nombre = '${nombre}' 
            WHERE id = '${id}'
        """.trimIndent()
        stmt.executeUpdate(editar)



    }

    fun close() {
        connection.close()
    }
    }

