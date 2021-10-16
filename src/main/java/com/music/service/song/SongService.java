package com.music.service.song;

import com.music.model.Song;
import com.music.repository.song.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> getAll() {
        return songRepository.getAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void delete(Long id) {
        songRepository.delete(id);
    }

    @Override
    public Song getById(Long id) {
        return songRepository.getById(id);
    }

    @Override
    public List<Song> getByName(String name) {
        name = "%" + name + "%";
        return songRepository.getByName(name);
    }
}
