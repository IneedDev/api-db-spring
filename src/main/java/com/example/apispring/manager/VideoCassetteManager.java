package com.example.apispring.manager;

import com.example.apispring.dao.VideoCassetteRepo;
import com.example.apispring.dao.entity.VideoCassette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VideoCassetteManager {

    private VideoCassetteRepo videoCassetteRepo;

    @Autowired
    public VideoCassetteManager(VideoCassetteRepo videoCassetteRepo) {
        this.videoCassetteRepo = videoCassetteRepo;
    }

    //Optional in case that entity with our id does not exist
    public Optional<VideoCassette> findById(Long id){
        return videoCassetteRepo.findById(id);
    }

    public Iterable<VideoCassette> findAll(){
        return videoCassetteRepo.findAll();
    }

    public VideoCassette save(VideoCassette videoCassette){
        return videoCassetteRepo.save(videoCassette);
    }

    public void deleteById(Long id){
        videoCassetteRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new VideoCassette("Title1", LocalDate.now()));
        save(new VideoCassette("Title2", LocalDate.now()));
    }
}
