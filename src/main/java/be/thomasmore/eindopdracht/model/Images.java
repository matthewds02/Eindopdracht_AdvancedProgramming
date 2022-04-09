package be.thomasmore.eindopdracht.model;

import javax.persistence.*;
import java.text.ParseException;
import java.time.LocalDate;

@Entity
public class Images {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "images_generator")
    @SequenceGenerator(name = "images_generator", sequenceName = "images_seq", allocationSize = 1)
    @Id
    private Integer imageId;
    private String imageName;
    private String image;

    public Images() {
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
