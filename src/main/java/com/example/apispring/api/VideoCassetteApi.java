package com.example.apispring.api;

import com.example.apispring.dao.entity.VideoCassette;
import com.example.apispring.manager.VideoCassetteManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cassettes")
public class VideoCassetteApi {

    private VideoCassetteManager videoCassettes;

    @Autowired
    public VideoCassetteApi(VideoCassetteManager videCassettes) {
        this.videoCassettes = videCassettes;
    }

    //    private List<VideoCassette> videoCassetteList;
//
//    public VideoCassetteApi() {
//        videoCassetteList = new ArrayList<>();
//
//        videoCassetteList.add(new VideoCassette(1L,"Title1", LocalDate.now()));
//        videoCassetteList.add(new VideoCassette(2L,"Title2", LocalDate.now()));
//    }

    @GetMapping("/all")
    public Iterable<VideoCassette> getAll(){
        return videoCassettes.findAll();
    }

    @GetMapping
    public Optional<VideoCassette> getByIdRequest(@RequestParam Long index){

        return videoCassettes.findById(index);
    }

    //create object
    @PostMapping
    public VideoCassette addVideo(@RequestBody VideoCassette videoCassette){

        return videoCassettes.save(videoCassette);
    }

    //update object
    @PutMapping
    public VideoCassette updateVideo(@RequestBody VideoCassette videoCassette){

        return videoCassettes.save(videoCassette);
    }

    //delete object
    @DeleteMapping
    public void deleteVideo(@RequestParam Long index){
        videoCassettes.deleteById(index);
    }


}
