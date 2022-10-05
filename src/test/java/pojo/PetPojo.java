package pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

public class PetPojo {
    private int id;
    private String name;
    private List<String> photoUrls;
    private CategoryPojo category;//I am calling from CategoryPojo class + create class + category needs to match in json
    private List<TagsPojo> tags;
    private String status;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<String> getPhotoUrls() {
//        return photoUrls;
//    }
//
//    public void setPhotoUrls(List<String> photoUrls) {
//        this.photoUrls = photoUrls;
//    }
//
//    public CategoryPojo getCategory() {
//        return category;
//    }
//
//    public void setCategory(CategoryPojo category) {
//        this.category = category;
//    }
//
//    public List<TagsPojo> getTags() {
//        return tags;
//    }
//
//    public void setTags(List<TagsPojo> tags) {
//        this.tags = tags;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
    }


