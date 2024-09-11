package guarnier.um.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import guarnier.um.domain.User;
import guarnier.um.domain.Authority;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.HashSet;
import org.junit.jupiter.api.Test;

class AdminUserDTOTest {

    private static final String DEFAULT_LOGIN = "johndoe";
    private static final String DEFAULT_FIRSTNAME = "john";
    private static final String DEFAULT_LASTNAME = "doe";
    private static final String DEFAULT_EMAIL = "johndoe@localhost";
    private static final String DEFAULT_IMAGEURL = "http://placehold.it/50x50";
    private static final String DEFAULT_LANGKEY = "en";
    private static final Instant DEFAULT_INSTANT = Instant.ofEpochMilli(0L);


    @Test
    void testConstructor() {
        AdminUserDTO adminUserDTO = new AdminUserDTO();
        assertThat(adminUserDTO).isNotNull();
    }

    @Test
    void testConstructorWithUser() {
        User user = createUser();
        AdminUserDTO adminUserDTO = new AdminUserDTO(user);

        assertThat(adminUserDTO.getId()).isEqualTo(user.getId());
        assertThat(adminUserDTO.getLogin()).isEqualTo(DEFAULT_LOGIN);
        assertThat(adminUserDTO.getFirstName()).isEqualTo(DEFAULT_FIRSTNAME);
        assertThat(adminUserDTO.getLastName()).isEqualTo(DEFAULT_LASTNAME);
        assertThat(adminUserDTO.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(adminUserDTO.isActivated()).isTrue();
        assertThat(adminUserDTO.getImageUrl()).isEqualTo(DEFAULT_IMAGEURL);
        assertThat(adminUserDTO.getLangKey()).isEqualTo(DEFAULT_LANGKEY);
        assertThat(adminUserDTO.getCreatedBy()).isEqualTo(DEFAULT_LOGIN);
        assertThat(adminUserDTO.getCreatedDate()).isEqualTo(DEFAULT_INSTANT);
        assertThat(adminUserDTO.getLastModifiedBy()).isEqualTo(DEFAULT_LOGIN);
        assertThat(adminUserDTO.getLastModifiedDate()).isEqualTo(DEFAULT_INSTANT);
        assertThat(adminUserDTO.getAuthorities()).containsExactly("ROLE_USER");
    }

    @Test
    void testSettersAndGetters() {
        AdminUserDTO adminUserDTO = new AdminUserDTO();

        adminUserDTO.setId(1L);
        adminUserDTO.setLogin(DEFAULT_LOGIN);
        adminUserDTO.setFirstName(DEFAULT_FIRSTNAME);
        adminUserDTO.setLastName(DEFAULT_LASTNAME);
        adminUserDTO.setEmail(DEFAULT_EMAIL);
        adminUserDTO.setActivated(true);
        adminUserDTO.setImageUrl(DEFAULT_IMAGEURL);
        adminUserDTO.setLangKey(DEFAULT_LANGKEY);
        adminUserDTO.setCreatedBy(DEFAULT_LOGIN);
        Instant now = Instant.now();
        adminUserDTO.setCreatedDate(now);
        adminUserDTO.setLastModifiedBy(DEFAULT_LOGIN);
        adminUserDTO.setLastModifiedDate(now);
        Set<String> authorities = new HashSet<>();
        authorities.add("ROLE_USER");
        adminUserDTO.setAuthorities(authorities);

        assertThat(adminUserDTO.getId()).isEqualTo(1L);
        assertThat(adminUserDTO.getLogin()).isEqualTo(DEFAULT_LOGIN);
        assertThat(adminUserDTO.getFirstName()).isEqualTo(DEFAULT_FIRSTNAME);
        assertThat(adminUserDTO.getLastName()).isEqualTo(DEFAULT_LASTNAME);
        assertThat(adminUserDTO.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(adminUserDTO.isActivated()).isTrue();
        assertThat(adminUserDTO.getImageUrl()).isEqualTo(DEFAULT_IMAGEURL);
        assertThat(adminUserDTO.getLangKey()).isEqualTo(DEFAULT_LANGKEY);
        assertThat(adminUserDTO.getCreatedBy()).isEqualTo(DEFAULT_LOGIN);
        assertThat(adminUserDTO.getCreatedDate()).isEqualTo(now);
        assertThat(adminUserDTO.getLastModifiedBy()).isEqualTo(DEFAULT_LOGIN);
        assertThat(adminUserDTO.getLastModifiedDate()).isEqualTo(now);
        assertThat(adminUserDTO.getAuthorities()).containsExactly("ROLE_USER");
    }

    @Test
    void testToString() {
        AdminUserDTO adminUserDTO = new AdminUserDTO();
        adminUserDTO.setLogin(DEFAULT_LOGIN);
        adminUserDTO.setFirstName(DEFAULT_FIRSTNAME);
        adminUserDTO.setLastName(DEFAULT_LASTNAME);
        adminUserDTO.setEmail(DEFAULT_EMAIL);
        adminUserDTO.setActivated(true);
        adminUserDTO.setImageUrl(DEFAULT_IMAGEURL);
        adminUserDTO.setLangKey(DEFAULT_LANGKEY);
        Set<String> authorities = new HashSet<>();
        authorities.add("ROLE_USER");
        adminUserDTO.setAuthorities(authorities);

        String toString = adminUserDTO.toString();

        assertThat(toString).contains("AdminUserDTO");
        assertThat(toString).contains("login='" + DEFAULT_LOGIN + "'");
        assertThat(toString).contains("firstName='" + DEFAULT_FIRSTNAME + "'");
        assertThat(toString).contains("lastName='" + DEFAULT_LASTNAME + "'");
        assertThat(toString).contains("email='" + DEFAULT_EMAIL + "'");
        assertThat(toString).contains("imageUrl='" + DEFAULT_IMAGEURL + "'");
        assertThat(toString).contains("activated=" + true);
        assertThat(toString).contains("langKey='" + DEFAULT_LANGKEY + "'");
        assertThat(toString).contains("authorities=" + authorities);
    }

    private User createUser() {
        User user = new User();
        user.setId(1L);
        user.setLogin(DEFAULT_LOGIN);
        user.setFirstName(DEFAULT_FIRSTNAME);
        user.setLastName(DEFAULT_LASTNAME);
        user.setEmail(DEFAULT_EMAIL);
        user.setActivated(true);
        user.setImageUrl(DEFAULT_IMAGEURL);
        user.setLangKey(DEFAULT_LANGKEY);
        user.setCreatedBy(DEFAULT_LOGIN);
        user.setCreatedDate(DEFAULT_INSTANT);
        user.setLastModifiedBy(DEFAULT_LOGIN);
        user.setLastModifiedDate(DEFAULT_INSTANT);
        Authority authority = new Authority();
        authority.setName("ROLE_USER");
        user.setAuthorities(Set.of(authority));
        return user;
    }
}