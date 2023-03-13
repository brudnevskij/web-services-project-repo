package fi.brudnevskij.camera.model;

import jakarta.persistence.*;

@Entity
@Table(name = "img")
public class Img {
    private int id;
    private String path;
    private String ts;
    private String ip;

    public Img(){}
    public Img(int id, String path, String ts, String ip){
        this.id = id;
        this.path = path;
        this.ts = ts;
        this.ip = ip;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }
}
