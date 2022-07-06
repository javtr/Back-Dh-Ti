package com.dh.clinica;

import com.dh.clinica.dao.impl.DomicilioDaoH2;
import com.dh.clinica.dao.impl.PacienteDaoH2;
import com.dh.clinica.dao.settings.DataBaseSettings;
import com.dh.clinica.model.Domicilio;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.service.DomicilioService;
import com.dh.clinica.service.PacienteService;
import org.junit.BeforeClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

@SpringBootApplication
public class ClinicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaApplication.class, args);
	}

}
