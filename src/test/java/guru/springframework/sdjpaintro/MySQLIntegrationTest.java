package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.domain.AuthorComposite;
import guru.springframework.sdjpaintro.domain.AuthorUuid;
import guru.springframework.sdjpaintro.domain.BookNatural;
import guru.springframework.sdjpaintro.domain.BookUuid;
import guru.springframework.sdjpaintro.repositories.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by jt on 7/4/21.
 */
@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"guru.springframework.sdjpaintro.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MySQLIntegrationTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorUuidRepository authorUuidRepository;

    @Autowired
    private BookUuidRepository bookUuidRepository;

    @Autowired
    private BookNaturalRepository bookNaturalRepository;

    @Autowired
    private AuthorCompositeRepository authorCompositeRepository;

    @Test
    void testBookUuid() {
        BookUuid bookUuid = bookUuidRepository.save(new BookUuid());
        assertThat(bookUuid).isNotNull();
        assertThat(bookUuid.getId());

        BookUuid bookUuidFetched = bookUuidRepository.getById(bookUuid.getId());
        assertThat(bookUuidFetched).isNotNull();
    }

    @Test
    void testAuthorUuid() {
        AuthorUuid authorUuid = authorUuidRepository.save(new AuthorUuid());
        assertThat(authorUuid).isNotNull();
        assertThat(authorUuid.getId());

        AuthorUuid authorUuidFetched = authorUuidRepository.getById(authorUuid.getId());
        assertThat(authorUuidFetched).isNotNull();
    }

    @Test
    void testBookNatural() {
        BookNatural bookNatural = new BookNatural();
        bookNatural.setTitle("New Book");
        BookNatural bookNaturalSaved = bookNaturalRepository.save(bookNatural);
        assertThat(bookNaturalSaved).isNotNull();
        assertThat(bookNaturalSaved.getTitle());

        BookNatural bookNaturalFetched = bookNaturalRepository.getById(bookNaturalSaved.getTitle());
        assertThat(bookNaturalFetched).isNotNull();
    }

    @Test
    void testAuthorComposite() {
        AuthorComposite.NameId nameId = new AuthorComposite.NameId("John", "T");
        AuthorComposite authorComposite = new AuthorComposite();
        authorComposite.setFirstName(nameId.getFirstName());
        authorComposite.setLastName(nameId.getLastName());
        authorComposite.setCountry("US");

        AuthorComposite saved = authorCompositeRepository.save(authorComposite);
        assertThat(saved).isNotNull();

        AuthorComposite fetched = authorCompositeRepository.getById(nameId);
        assertThat(fetched).isNotNull();
    }

    @Test
    void testMySQL() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

    }

}


