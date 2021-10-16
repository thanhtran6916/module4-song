package com.music.controller;

import com.music.model.Song;
import com.music.model.SongForm;
import com.music.service.song.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @Value("${upload-file}")
    private String fileUpload;

    @GetMapping("")
    public String showAll(@RequestParam("q") Optional<String> name, Model model) {
        if (name.isPresent()) {
            String name1 = name.get();
            List<Song> songs = songService.getByName(name1);
            model.addAttribute("songs", songs);
        } else {
            model.addAttribute("songs", songService.getAll());
        }
        return "music/list";
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("/music/create");
        modelAndView.addObject("songForm", new SongForm());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createSong(@ModelAttribute("songForm") SongForm songForm) {
        MultipartFile file = songForm.getFile();
        String fileName = file.getOriginalFilename();
        Song song = new Song(songForm.getId(), songForm.getName(), songForm.getArtist(), songForm.getCategory(), fileName);
        songService.save(song);
        try {
            byte[] bytes = file.getBytes();
            File file1 = new File(fileUpload + fileName);
            FileCopyUtils.copy(bytes, file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/song";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable("id") Long id) {
        Song song = songService.getById(id);
        ModelAndView modelAndView = new ModelAndView("/music/edit");
        modelAndView.addObject("song", song);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String editSong(@ModelAttribute("song") Song song) {
        songService.save(song);
        return "redirect:/song";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable("id") Long id, Model model) {
        Song song = songService.getById(id);
        model.addAttribute("song", song);
        return "/music/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteSong(@PathVariable("id") Long id) {
        songService.delete(id);
        return "redirect:/song";
    }


}
