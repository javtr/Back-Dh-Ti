package com.dh.clinica.dao.impl;

import com.dh.clinica.dao.IDao;
import com.dh.clinica.dao.settings.DataBaseSettings;

import com.dh.clinica.model.Domicilio;
import com.dh.clinica.model.Odontologo;
import com.dh.clinica.util.Util;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private final static Logger logger = Logger.getLogger(OdontologoDaoH2.class);

    private DataBaseSettings dataBaseSettings;

    public OdontologoDaoH2(DataBaseSettings dataBaseSettings) {
        this.dataBaseSettings = dataBaseSettings;
    }


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataBaseSettings.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO odontologos (matricula, nombre, apellido) VALUES (?,?,?)");

            preparedStatement.setString(1, odontologo.getNumeroMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.executeUpdate();

            logger.info("Se han insertado datos en la tabla");
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Odontologo> odontologos = new ArrayList();

        try {
            connection = dataBaseSettings.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM odontologos");
            ResultSet result = preparedStatement.executeQuery();

            logger.info("Se está realizando la consulta");

            while (result.next()) {
                int IdOdontologo = result.getInt("id");
                String numeroMatricula = result.getString("matricula");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");

                Odontologo odontologo = new Odontologo(IdOdontologo, numeroMatricula, nombre, apellido);
                odontologos.add(odontologo);
            }
            logger.info("La consulta se realizo con exito");
            preparedStatement.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return odontologos;
    }

    @Override
    public Odontologo buscar(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Odontologo odontologo = null;
    try {
        connection = dataBaseSettings.getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM odontologos WHERE id=?" );
        preparedStatement.setInt(1,id);

        ResultSet result = preparedStatement.executeQuery();
        while (result.next()){
            int idOdontologo = result.getInt("id");
            String numeroMatricula = result.getString("matricula");
            String nombre = result.getString("nombre");
            String apellido = result.getString("apellido");
            odontologo = new Odontologo(idOdontologo,numeroMatricula,nombre,apellido);

        }
    } catch (SQLException | ClassNotFoundException throwables) {
        throwables.printStackTrace();
    }
        return odontologo;
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //1 Levantar el driver y Conectarnos
            connection= dataBaseSettings.getConnection();

            preparedStatement = connection.prepareStatement("UPDATE odontologos SET matricula = ?, nombre = ? ,apellido = ? WHERE id = ?");
            //No le vamos a pasar el ID ya que hicimos que fuera autoincremental en la base de datos
            //preparedStatement.setInt(1,domicilio.getId());
            preparedStatement.setString(1, odontologo.getNumeroMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.setInt(4, odontologo.getId());

            //3 Ejecutar una sentencia SQL y obtener los ID que se autogeneraron en la base de datos
            preparedStatement.executeUpdate();
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
            connection= dataBaseSettings.getConnection();

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
}
