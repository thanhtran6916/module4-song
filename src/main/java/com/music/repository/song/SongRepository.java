package com.music.repository.song;

import com.music.model.Song;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class SongRepository implements ISongRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Song> getAll() {
        TypedQuery<Song> query = entityManager.createQuery("select s from Song as s", Song.class);
        return query.getResultList();
    }

    @Override
    public void save(Song song) {
        if (song.getId() == null) {
            entityManager.persist(song);
        } else {
            entityManager.merge(song);
        }
    }

    @Override
    public void delete(Long id) {
        Song song = this.getById(id);
        entityManager.remove(song);
    }

    @Override
    public Song getById(Long id) {
        TypedQuery<Song> query = entityManager.createQuery("select s from Song as s where s.id = :id", Song.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Song> getByName(String name) {
        TypedQuery<Song> query = entityManager.createQuery("select s from Song as s where s.name like :name", Song.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
