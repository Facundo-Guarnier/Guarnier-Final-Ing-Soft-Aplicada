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

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void testUserAttributes() {
        // Test ID
        Long id = 1L;
        user.setId(id);
        assertThat(user.getId()).isEqualTo(id);

        // Test login
        String login = "testuser";
        user.setLogin(login);
        assertThat(user.getLogin()).isEqualTo(login.toLowerCase(Locale.ENGLISH));

        // Test password
        String password = "hashedpassword123";
        user.setPassword(password);
        assertThat(user.getPassword()).isEqualTo(password);

        // Test first name
        String firstName = "John";
        user.setFirstName(firstName);
        assertThat(user.getFirstName()).isEqualTo(firstName);

        // Test last name
        String lastName = "Doe";
        user.setLastName(lastName);
        assertThat(user.getLastName()).isEqualTo(lastName);

        // Test email
        String email = "test@example.com";
        user.setEmail(email);
        assertThat(user.getEmail()).isEqualTo(email);

        // Test activated status
        user.setActivated(true);
        assertThat(user.isActivated()).isTrue();

        // Test langKey
        String langKey = "en";
        user.setLangKey(langKey);
        assertThat(user.getLangKey()).isEqualTo(langKey);

        // Test imageUrl
        String imageUrl = "http://example.com/image.jpg";
        user.setImageUrl(imageUrl);
        assertThat(user.getImageUrl()).isEqualTo(imageUrl);

        // Test activationKey
        String activationKey = "activation123";
        user.setActivationKey(activationKey);
        assertThat(user.getActivationKey()).isEqualTo(activationKey);

        // Test resetKey
        String resetKey = "reset123";
        user.setResetKey(resetKey);
        assertThat(user.getResetKey()).isEqualTo(resetKey);

        // Test resetDate
        Instant resetDate = Instant.now();
        user.setResetDate(resetDate);
        assertThat(user.getResetDate()).isEqualTo(resetDate);

        // Test authorities
        Set<Authority> authorities = new HashSet<>();
        Authority authority = new Authority();
        authority.setName("ROLE_USER");
        authorities.add(authority);
        user.setAuthorities(authorities);
        assertThat(user.getAuthorities()).isEqualTo(authorities);
    }

    @Test
    void testEqualsAndHashCode() {
        // Test equals and hashCode
        User user1 = new User();
        user1.setId(1L);

        User user2 = new User();
        user2.setId(1L);

        User user3 = new User();
        user3.setId(2L);

        assertThat(user1).isEqualTo(user2); // Same ID, should be equal
        assertThat(user1).isNotEqualTo(user3); // Different ID, should not be equal
        assertThat(user1.hashCode()).isEqualTo(user2.hashCode()); // Same ID, same hashCode
    }

    @Test
    void testToString() {
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