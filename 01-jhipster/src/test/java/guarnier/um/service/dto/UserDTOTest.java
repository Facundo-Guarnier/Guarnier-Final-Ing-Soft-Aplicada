package guarnier.um.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import guarnier.um.domain.User;
import org.junit.jupiter.api.Test;

class UserDTOTest {

    @Test
    void testConstructor() {
        UserDTO userDTO = new UserDTO();
        assertThat(userDTO).isNotNull();
    }

    @Test
    void testConstructorWithUser() {
        User user = new User();
        user.setId(1L);
        user.setLogin("testuser");

        UserDTO userDTO = new UserDTO(user);

        assertThat(userDTO.getId()).isEqualTo(1L);
        assertThat(userDTO.getLogin()).isEqualTo("testuser");
    }

    @Test
    void testSetAndGetId() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        assertThat(userDTO.getId()).isEqualTo(1L);
    }

    @Test
    void testSetAndGetLogin() {
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin("testuser");
        assertThat(userDTO.getLogin()).isEqualTo("testuser");
    }

    @Test
    void testToString() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setLogin("testuser");

        String toString = userDTO.toString();

        assertThat(toString).contains("UserDTO");
        assertThat(toString).contains("id='1'");
        assertThat(toString).contains("login='testuser'");
    }
}