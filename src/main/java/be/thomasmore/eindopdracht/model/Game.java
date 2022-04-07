package be.thomasmore.eindopdracht.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Game {
    @Id
    private Integer id;
    private String gameName;
    private LocalDate gameReleaseDate;
    private LocalDate crackedDate;
    // why lob = https://stackoverflow.com/questions/24214341/why-is-this-value-too-long-for-my-h2-table
    @Lob
    private String extraInfo;
    private String publisher;
    private String crackedBy;
    private boolean cracked;
    private boolean playstation4;
    private boolean playstation5;
    private boolean xbox;
    private boolean pc;
    private String image;

    public Game() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public LocalDate getGameReleaseDate() {
        return gameReleaseDate;
    }

    public void setGameReleaseDate(LocalDate gameReleaseDate) {
        this.gameReleaseDate = gameReleaseDate;
    }

    public LocalDate getCrackedDate() throws ParseException {
        return crackedDate;
    }

    public void setCrackedDate(LocalDate crackedDate) {
        this.crackedDate = crackedDate;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCrackedBy() {
        return crackedBy;
    }

    public void setCrackedBy(String crackedBy) {
        this.crackedBy = crackedBy;
    }

    public boolean isCracked() {
        return cracked;
    }

    public void setCracked(boolean cracked) {
        this.cracked = cracked;
    }

    public boolean isPlaystation4() {
        return playstation4;
    }

    public void setPlaystation4(boolean playstation4) {
        this.playstation4 = playstation4;
    }

    public boolean isPlaystation5() {
        return playstation5;
    }

    public void setPlaystation5(boolean playstation5) {
        this.playstation5 = playstation5;
    }

    public boolean isXbox() {
        return xbox;
    }

    public void setXbox(boolean xbox) {
        this.xbox = xbox;
    }

    public boolean isPc() {
        return pc;
    }

    public void setPc(boolean pc) {
        this.pc = pc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
