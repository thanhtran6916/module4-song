package com.music.repository.song;

import com.music.model.Song;
import com.music.repository.IGeneralRepository;

import java.util.List;

public interface ISongRepository extends IGeneralRepository<Song> {
    List<Song> getByName(String name);
}
