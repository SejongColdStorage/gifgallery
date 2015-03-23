package kr.sadalmelik.gifgallery.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class GifWrapper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime writeDateTime;

    private URL imageUrl;
    private int imageWidth;
    private int imageHeight;
    private int imageSize;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "tagId")
    private List<Tag> tags;

    public GifWrapper(String title, String description, String imageUrl, int imageHeight, int imageWidth){
        this.title = title;
        this.description = description;
        try {
            this.imageUrl = new URL(imageUrl);
        } catch (MalformedURLException e) {e.printStackTrace();}
        this.imageHeight = imageHeight;
        this.imageWidth = imageWidth;
        //TODO 초기화 부분은 수정할 것.
        this.writeDateTime = new DateTime(new Date());
        this.tags = new ArrayList<Tag>(){{
            add(new Tag("신남"));
            add(new Tag("설렘"));
            add(new Tag("평화"));
        }};
    }

}
