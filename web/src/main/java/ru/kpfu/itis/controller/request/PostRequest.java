package ru.kpfu.itis.controller.request;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Created by sanekesv on 23.03.16.
 */
@ApiModel("Post")
public class PostRequest {

    @ApiModelProperty(required = true, value = "id существующего поста")
    private Long id;

    @ApiModelProperty(required = true, value = "description")
    private String description;

    @ApiModelProperty(required = true, value = "author id")
    private Long userId;

    @ApiModelProperty(required = true, value = "book id")
    private Long bookId;

    @ApiModelProperty(required = false, value = "location lat")
    private Double lat;

    @ApiModelProperty(required = false, value = "location lng")
    private Double lng;

    @ApiModelProperty(required = false, value = "location name")
    private String locName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }
}
