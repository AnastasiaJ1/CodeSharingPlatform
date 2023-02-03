package platform.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import platform.models.Code;

import java.util.List;


public interface CodeRepository
        extends JpaRepository<Code, String> {
    @Query(value="select * from Code c where (c.secrettime = 0 and c.secretviews = 0) ORDER BY c.date desc limit 10", nativeQuery = true)
    List<Code> findLast10();

}