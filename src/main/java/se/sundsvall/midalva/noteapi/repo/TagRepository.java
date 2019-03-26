package se.sundsvall.midalva.noteapi.repo;

import org.springframework.data.repository.CrudRepository;
import se.sundsvall.midalva.noteapi.model.Tag;
import javax.persistence.Id;


public interface TagRepository extends CrudRepository<Tag, Id> {

    public Tag findByTag(String tag);

}
