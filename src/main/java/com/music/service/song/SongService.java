package com.music.service.song;

import com.music.model.Song;
import com.music.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository songRepository;


    @Override
    public Page<Song> findAll(Pageable pageable) {
        return songRepository.findAll(pageable);
    }

    @Override
    public Song save(Song song) {
        return songRepository.save(song);
    }

    @Override
    public void delete(Long id) {
        songRepository.deleteById(id);
    }

    @Override
    public Optional<Song> getById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public Page<Song> findSongsByArtistContaining(String artist, Pageable pageable) {
        return songRepository.findSongsByArtistContaining(artist, pageable);
    }
}
