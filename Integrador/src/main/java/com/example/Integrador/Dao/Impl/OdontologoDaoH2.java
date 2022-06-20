package com.example.Integrador.Dao.Impl;

import com.example.Integrador.Dao.IDao;
import com.example.Integrador.Models.Domicilio;
import com.example.Integrador.Models.Odontologo;
import com.example.Integrador.Models.Paciente;
import com.example.Integrador.Util.Util;
import com.example.Integrador.configuration.ConfiguracionJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo>

    {

        private ConfiguracionJDBC conexionBD = new ConfiguracionJDBC();

       // private static final Logger log= Logger.getLogger(OdontologoDaoH2.class);
        private final static String DB_JDBC_DRIVER = "org.h2.Driver";
        //private final static String DB_URL = "jdbc:h2:~/db_odontologos2;";

        private final static String DB_URL = "jdbc:h2:~/db_clinica15;INIT=RUNSCRIPT FROM 'create.sql'";

        private final static String DB_USER ="sa";
        private final static String DB_PASSWORD = "sa";


        @Override
        public Odontologo guardar(Odontologo odontologo) {

            Connection connection = null;
            PreparedStatement preparedStatement = null;

            try {
                //1 Levantar el driver y Conectarnos
                //Class.forName(DB_JDBC_DRIVER);
                //connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

                connection = conexionBD.conectarConBaseDeDatos();


                preparedStatement = connection.prepareStatement("insert into odontologos (matricula, nombre, apellido) VALUES (?,?,?);", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, odontologo.getMatricula());
                preparedStatement.setString(2, odontologo.getNombre());
                preparedStatement.setString(3, odontologo.getApellido());

                preparedStatement.execute();
                ResultSet keys = preparedStatement.getGeneratedKeys();
                if(keys.next())
                    odontologo.setId(keys.getInt(1));

                preparedStatement.close();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return odontologo;
        }




        @Override
        public Odontologo buscar(Integer id) {

            Connection connection = null;
            PreparedStatement preparedStatement = null;
            Odontologo odontologo = null;
            try {
                //1 Levantar el driver y Conectarnos
                Class.forName(DB_JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

                //2 Crear una sentencia
                preparedStatement = connection.prepareStatement("SELECT id,matricula,nombre,apellido FROM odontologos where id = ?");
                preparedStatement.setInt(1,id);

                //3 Ejecutar una sentencia SQL
                ResultSet result = preparedStatement.executeQuery();

                //4 Obtener resultados
                while (result.next()) {
                    int idOdontologo = result.getInt("id");
                    String matricula = result.getString("matricula");
                    String nombre = result.getString("nombre");
                    String apellido = result.getString("apellido");

                    odontologo = new Odontologo(idOdontologo,matricula,nombre,apellido);
                    System.out.println(idOdontologo);
                }

                preparedStatement.close();
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }

            return odontologo;
        }

        @Override
        public void eliminar(Integer id) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            try {
                //1 Levantar el driver y Conectarnos
                Class.forName(DB_JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

                //2 Crear una sentencia
                preparedStatement = connection.prepareStatement("DELETE FROM odontologos where id = ?");
                preparedStatement.setInt(1,id);

                //3 Ejecutar una sentencia SQL
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }


        @Override
        public List<Odontologo> buscarTodos() {

            Connection connection=null;
            PreparedStatement preparedStatement= null;
            List<Odontologo> odontologos = new ArrayList<>();
            Odontologo odontologo = null;

            try {
                Class.forName(DB_JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

                String SQL_SELECT= "SELECT * FROM odontologos";
                preparedStatement= connection.prepareStatement(SQL_SELECT);
                ResultSet result = preparedStatement.executeQuery();

                while(result.next()){
                    int idOdontologo= result.getInt("id");
                    String matricula= result.getString("matricula");
                    String nombre= result.getString("nombre");
                    String apellido= result.getString("apellido");

                    odontologo = new Odontologo(idOdontologo,matricula,nombre,apellido);
                    odontologos.add(odontologo);
                }


                preparedStatement.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

            return odontologos;

        }

        @Override
        public Odontologo actualizar(Odontologo odontologo) {

            Connection connection = null;
            PreparedStatement preparedStatement = null;

            try {
                //1 Levantar el driver y Conectarnos
                Class.forName(DB_JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

                //2 Crear una sentencia especificando que el ID lo auto incrementa la base de datos y que nos devuelva esa Key es decir ID
                preparedStatement = connection.prepareStatement("UPDATE odontologos SET matricula=?, nombre=?, apellido=? WHERE id = ?");
                //No le vamos a pasar el ID ya que hicimos que fuera autoincremental en la base de datos
                //preparedStatement.setInt(1,paciente.getId());
                preparedStatement.setString(1, odontologo.getMatricula());
                preparedStatement.setString(2, odontologo.getNombre());
                preparedStatement.setString(3, odontologo.getApellido());
                preparedStatement.setInt(4, odontologo.getId());

                //3 Ejecutar una sentencia SQL
                preparedStatement.executeUpdate();
                preparedStatement.close();

            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }

            return odontologo;
        }
    }
