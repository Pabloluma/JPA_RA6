package com.hlc.usuario_uno_a_uno.config;

import com.hlc.usuario_uno_a_uno.entidad.enumerado.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.hlc.usuario_uno_a_uno.entidad.InformacionUsuario;
import com.hlc.usuario_uno_a_uno.entidad.Usuario;
import com.hlc.usuario_uno_a_uno.repositorio.UsuarioRepositorio;

import jakarta.transaction.Transactional;

import java.util.Arrays;
import java.util.Random;

@Component
public class InicializarDatos implements CommandLineRunner {

    private final UsuarioRepositorio usuarioRepositorio;
    private final Faker faker = new Faker();

    public InicializarDatos(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
    	int TOTAL = 30;
        Random random = new Random();
        for (int i = 1; i <= TOTAL; i++) { // Generar 10 usuarios de prueba
            String email = faker.internet().emailAddress();
            String telefono = faker.number().digits(8); // Genera un teléfono de 8 dígitos
            String username = faker.name().username();
            String password = faker.internet().password(8, 12);

            int numero = random.nextInt(3);
            Rol[] indice = Rol.values();
            Rol valor = indice[numero];


            InformacionUsuario info = new InformacionUsuario(email, telefono);
            Usuario usuario = new Usuario(username, password, info, valor);
            info.setUsuario(usuario);

            usuarioRepositorio.save(usuario);
        }

        System.out.println("📌 Se generaron "+TOTAL+" usuarios de prueba con Faker.");
    }
}
