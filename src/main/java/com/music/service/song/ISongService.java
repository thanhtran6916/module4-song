package com.music.service.song;

import com.music.model.Song;
import com.music.service.IGeneralService;

import java.util.List;

public interface ISongService extends IGeneralService<Song> {
    List<Song> getByName(String name);
}
