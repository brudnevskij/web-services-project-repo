package fi.brudnevskij.camera.repository;

import fi.brudnevskij.camera.model.Img;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImgRepository extends JpaRepository<Img, Integer> {

}
