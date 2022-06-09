package com.dh.clinina.clinica.dao.impl;


import com.dh.clinina.clinica.configuaracion.ConfiguracionJDBC;
import com.dh.clinina.clinica.dao.IDao;
import com.dh.clinina.clinica.model.Domicilio;
import com.dh.clinina.clinica.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class OdontologoDaoH2 implements IDao<Odontologo> {

    private ConfiguracionJDBC conexionBD = new ConfiguracionJDBC();

    private static final Logger log= Logger.getLogger(OdontologoDaoH2.class);
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


            preparedStatement = connection.prepareStatement("insert into odontologos (matricula, nombre, apellido) VALUES (?,?,?);");
            preparedStatement.setString(1, odontologo.getMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return odontologo;
    }

    @Override
    public Odontologo buscar(Integer id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

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
            log.info("Conexión establecida!!");

            String SQL_SELECT= "SELECT * FROM odontologos";
            preparedStatement= connection.prepareStatement(SQL_SELECT);
            ResultSet result = preparedStatement.executeQuery();
            log.info("Sentencia SELECT ejecutada!!");

            while(result.next()){
                int idOdontologo= result.getInt("id");
                String matricula= result.getString("matricula");
                String nombre= result.getString("nombre");
                String apellido= result.getString("apellido");

                odontologo = new Odontologo(idOdontologo,matricula,nombre,apellido);
                odontologos.add(odontologo);
                log.info("Obtenido el profesional: "+ odontologo);
            }


            preparedStatement.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return odontologos;

    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        return null;
    }
}
