package guru.springframework.sdjpaintro.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by jt on 6/12/21.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookNatural {

    @Id
    private String title;
    private String isbn;
    private String publisher;

}
