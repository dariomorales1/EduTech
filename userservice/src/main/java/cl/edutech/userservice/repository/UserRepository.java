package cl.edutech.userservice.repository;

import cl.edutech.userservice.domain.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRepository {

    private static final List<User> users = new ArrayList<>();

    static {
        users.addAll(
                List.of(
                        User.builder()
                                .username("juanperez")
                                .password("P@ssw0rd1")
                                .email("juan.perez@example.com")
                                .firstName("Juan")
                                .lastName("Pérez")
                                .build(),
                        User.builder()
                                .username("maria_lopez")
                                .password("L0pezM@ria2")
                                .email("maria.lopez@example.com")
                                .firstName("María")
                                .lastName("López")
                                .build(),
                        User.builder()
                                .username("carlosramirez")
                                .password("Cr@123456")
                                .email("carlos.ramirez@example.com")
                                .firstName("Carlos")
                                .lastName("Ramírez")
                                .build(),
                        User.builder()
                                .username("ana_garcia")
                                .password("Garci@Ana3")
                                .email("ana.garcia@example.com")
                                .firstName("Ana")
                                .lastName("García")
                                .build(),
                        User.builder()
                                .username("luishernandez")
                                .password("H3rn@ndez4")
                                .email("luis.hernandez@example.com")
                                .firstName("Luis")
                                .lastName("Hernández")
                                .build(),
                        User.builder()
                                .username("sofia_martinez")
                                .password("M@rtinez5")
                                .email("sofia.martinez@example.com")
                                .firstName("Sofía")
                                .lastName("Martínez")
                                .build(),
                        User.builder()
                                .username("pedro_gomez")
                                .password("G0mezP3dro")
                                .email("pedro.gomez@example.com")
                                .firstName("Pedro")
                                .lastName("Gómez")
                                .build(),
                        User.builder()
                                .username("laura_rodriguez")
                                .password("Rodr!guez6")
                                .email("laura.rodriguez@example.com")
                                .firstName("Laura")
                                .lastName("Rodríguez")
                                .build(),
                        User.builder()
                                .username("andres_sanchez")
                                .password("S@nchez7")
                                .email("andres.sanchez@example.com")
                                .firstName("Andrés")
                                .lastName("Sánchez")
                                .build(),
                        User.builder()
                                .username("valeria_torres")
                                .password("T0rr3s8!")
                                .email("valeria.torres@example.com")
                                .firstName("Valeria")
                                .lastName("Torres")
                                .build()));


        }

    public static List<User> findAll() {
        return users;
    }
}