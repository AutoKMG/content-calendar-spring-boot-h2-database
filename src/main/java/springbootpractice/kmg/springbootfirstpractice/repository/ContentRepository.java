package springbootpractice.kmg.springbootfirstpractice.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import springbootpractice.kmg.springbootfirstpractice.model.Content;
import springbootpractice.kmg.springbootfirstpractice.model.Status;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
    List<Content> findAllByTitleContains(String keyword);

    @Query("""
        SELECT * FROM Content
        WHERE status =:status
    """)
    List<Content> listByStatus(@Param("status") Status status);
}
