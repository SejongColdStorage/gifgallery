package kr.sadalmelik.gifgallery.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.net.MalformedURLException;
import java.net.URL;

@Data
@NoArgsConstructor
@Entity
public class GifWrapper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private URL imageUrl;
    private int imageWidth;
    private int imageHeight;
    private int imageSize;

    public GifWrapper(String title, String description, String imageUrl, int imageHeight, int imageWidth){
        this.title = title;
        this.description = description;
        try {
            this.imageUrl = new URL(imageUrl);
        } catch (MalformedURLException e) {e.printStackTrace();}
        this.imageHeight = imageHeight;
        this.imageWidth = imageWidth;
    }
}
