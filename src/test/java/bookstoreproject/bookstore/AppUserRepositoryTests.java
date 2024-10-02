package bookstoreproject.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import bookstoreproject.bookstore.domain.AppUser;
import bookstoreproject.bookstore.domain.AppUserRepository;

@DataJpaTest
public class AppUserRepositoryTests {

    @Autowired
    private AppUserRepository appUserRepository;

    // Test to create new app users
    @Test
    public void createNewUserTest() {
        appUserRepository.save(new AppUser("testAppUser", "password", "USER"));
        AppUser appUser = appUserRepository.findByUsername("testAppUser");

        assertThat(appUser.getRole()).isEqualTo("USER");
    }

    @Test
    public void deleteUserTest() {
        long repositorySize = appUserRepository.count();
        appUserRepository.save(new AppUser("testAppUser", "password", "USER"));
        long id = (appUserRepository.findByUsername("testAppUser")).getId();
        appUserRepository.deleteById(id);

        assertThat(repositorySize).isEqualTo(appUserRepository.count());
    }

    @Test
    public void findByUsername() {
        
    }
}
