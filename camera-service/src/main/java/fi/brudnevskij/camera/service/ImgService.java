package fi.brudnevskij.camera.service;

import fi.brudnevskij.camera.model.Img;
import fi.brudnevskij.camera.repository.ImgRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ImgService {
    @Autowired
    private ImgRepository imgRepository;
    public List<Img> listAllImg(){
        return imgRepository.findAll();
    }
    public void saveImg(Img img){
        imgRepository.save(img);
    }

    public Img getImg(Integer id){
        return  imgRepository.findById(id).get();
    }

    public void deleteImg(Integer id){
        imgRepository.deleteById(id);
    }
}
