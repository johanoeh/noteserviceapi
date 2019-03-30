package se.sundsvall.midalva.noteapi.repo;

import org.springframework.data.repository.CrudRepository;
import se.sundsvall.midalva.noteapi.model.db.TagEntity;

import javax.persistence.Id;


public interface TagRepository extends CrudRepository<TagEntity, Id> {

    public TagEntity findByTag(String tag);

}
