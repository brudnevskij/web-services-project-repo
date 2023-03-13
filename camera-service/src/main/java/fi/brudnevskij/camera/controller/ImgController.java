package fi.brudnevskij.camera.controller;

import fi.brudnevskij.camera.model.Img;
import fi.brudnevskij.camera.service.ImgService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/files")
public class ImgController {

    @Autowired
    ImgService imgService;
    @GetMapping("")
    public List<Img> getAllImgs(){
        return imgService.listAllImg();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Img> get(@PathVariable Integer id) {
        try {
            Img img = imgService.getImg(id);
            return new ResponseEntity<Img>(img, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Img>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public ResponseEntity<?> add(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        Img img = new Img();
        img.setTs(String.valueOf(new Date().getTime()));
        img.setIp(request.getRemoteAddr());
        img.setPath("/tmp");

        imgService.saveImg(img);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        imgService.deleteImg(id);
    }
}
