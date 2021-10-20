package com.music.service.song;

import com.music.model.Song;
import com.music.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ISongService extends IGeneralService<Song> {
    Page<Song> findSongsByArtistContaining(String artist, Pageable pageable);
}
