package guru.springframework.sdjpaintro.repositories;

import guru.springframework.sdjpaintro.domain.AuthorUuid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by jt on 6/12/21.
 */
public interface AuthorUuidRepository extends JpaRepository<AuthorUuid, UUID> {
}
