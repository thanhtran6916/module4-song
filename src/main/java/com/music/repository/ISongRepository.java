package com.music.repository;

import com.music.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ISongRepository extends PagingAndSortingRepository<Song, Long> {

    Page<Song> findSongsByArtistContaining(String artist, Pageable pageable);
}
