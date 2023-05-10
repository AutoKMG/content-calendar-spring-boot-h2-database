package springbootpractice.kmg.springbootfirstpractice.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import springbootpractice.kmg.springbootfirstpractice.model.Content;
import springbootpractice.kmg.springbootfirstpractice.model.Status;
import springbootpractice.kmg.springbootfirstpractice.model.Type;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){

    }
    public List<Content> finalAll(){
        return contentList;
    }
    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }
    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }
    @PostConstruct
    private void init(){
        Content content  = new Content(
                1,
                "This is my first blog post",
                "My first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");
        contentList.add(content);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
