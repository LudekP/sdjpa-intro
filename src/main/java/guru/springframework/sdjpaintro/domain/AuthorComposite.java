package guru.springframework.sdjpaintro.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(AuthorComposite.NameId.class)
public class AuthorComposite implements Serializable {

    @Id
    private String firstName;
    @Id
    private String lastName;
    private String country;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class NameId implements Serializable {
        private String firstName;
        private String lastName;
    }

}
