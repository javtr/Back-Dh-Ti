package com.dh.clinica.dao.settings;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseSettings {
    private final static Logger logger = Logger.getLogger(DataBaseSettings.class);

    private String db_driver;
    private String db_url;
    private String db_user;
    private String db_password;

    //constructor para trabajar con otras configuraciones
    public DataBaseSettings(String db_driver, String db_url, String db_user, String DB_PASSWORD) {
        this.db_driver = db_driver;
        this.db_url = db_url;
        this.db_user = db_user;
        this.db_password = DB_PASSWORD;
    }

    //constructor para las configuraciones de este proyecto en particular
    public DataBaseSettings() {
        this.db_driver = "org.h2.Driver";
        this.db_url = "jdbc:h2:~/db_clinica_cesar;INIT=RUNSCRIPT FROM 'create.sql'";
        this.db_user = "sa";
        this.db_password = "sa";
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection;

        Class.forName(db_driver);
        connection = DriverManager.getConnection(db_url, db_user, db_password);
        logger.info("Conexión exitosa");

        return connection;
    }

}
