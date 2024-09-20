package guarnier.um.service.Mi_test;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import guarnier.um.domain.Authority;
import guarnier.um.domain.User;
import guarnier.um.service.dto.UserDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MiTest {
    //! test de la clase User de domain, se verifica si los atributos son correctos para la DB
    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void testUserAttributes() {
        //! Este test virifica si los atributos de la clase User son correctos
        Long id = 1L;
        user.setId(id);
        assertThat(user.getId()).isEqualTo(id);

        String login = "testuser";
        user.setLogin(login);
        assertThat(user.getLogin()).isEqualTo(login.toLowerCase(Locale.ENGLISH));

        String password = "hashedpassword123";
        user.setPassword(password);
        assertThat(user.getPassword()).isEqualTo(password);

        String firstName = "John";
        user.setFirstName(firstName);
        assertThat(user.getFirstName()).isEqualTo(firstName);

        String lastName = "Doe";
        user.setLastName(lastName);
        assertThat(user.getLastName()).isEqualTo(lastName);

        String email = "test@example.com";
        user.setEmail(email);
        assertThat(user.getEmail()).isEqualTo(email);

        user.setActivated(true);
        assertThat(user.isActivated()).isTrue();

        String langKey = "en";
        user.setLangKey(langKey);
        assertThat(user.getLangKey()).isEqualTo(langKey);

        String imageUrl = "http://example.com/image.jpg";
        user.setImageUrl(imageUrl);
        assertThat(user.getImageUrl()).isEqualTo(imageUrl);

        String activationKey = "activation123";
        user.setActivationKey(activationKey);
        assertThat(user.getActivationKey()).isEqualTo(activationKey);

        String resetKey = "reset123";
        user.setResetKey(resetKey);
        assertThat(user.getResetKey()).isEqualTo(resetKey);

        Instant resetDate = Instant.now();
        user.setResetDate(resetDate);
        assertThat(user.getResetDate()).isEqualTo(resetDate);

        Set<Authority> authorities = new HashSet<>();
        Authority authority = new Authority();
        authority.setName("ROLE_USER");
        authorities.add(authority);
        user.setAuthorities(authorities);
        assertThat(user.getAuthorities()).isEqualTo(authorities);
    }

    @Test
    void testEquals() {
        //! Este test verifica si el metodo equal es correcto
        //! equals() compara los objetos por su contenido
        User user1 = new User();
        user1.setId(1L);

        User user2 = new User();
        user2.setId(1L);

        User user3 = new User();
        user3.setId(2L);

        assertThat(user1).isEqualTo(user2);
        assertThat(user1).isNotEqualTo(user3);
    }

    @Test
    void testToString() {
        //! Este test verifica si el metodo toString es correcto
        user.setLogin("testuser");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("test@example.com");
        user.setImageUrl("http://example.com/image.jpg");
        user.setActivated(true);
        user.setLangKey("en");
        user.setActivationKey("activation123");

        String expectedToString = "User{" +
            "login='testuser'," +
            " firstName='John'," +
            " lastName='Doe'," +
            " email='test@example.com'," +
            " imageUrl='http://example.com/image.jpg'," +
            " activated='true'," +
            " langKey='en'," +
            " activationKey='activation123'" +
            "}";

        assertThat(user.toString()).isEqualTo(expectedToString);
    }
}