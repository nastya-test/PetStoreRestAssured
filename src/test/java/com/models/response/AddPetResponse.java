package com.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.models.Category;
import com.models.Status;
import com.models.Tag;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddPetResponse extends ApiResponse {
    private Integer id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private Status status;

    public AddPetResponse() {
    }

    public AddPetResponse
            (Integer id,
             Category category,
             String name,
             List<String> photoUrls,
             List<Tag> tags,
             Status status) {

        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status=" + status +
                '}';
    }

    public static Builder builder() {
        return Builder.createBuilder();
    }

    public static final class Builder {
        private AddPetResponse addPetResponse;

        private Builder() {
            addPetResponse = new AddPetResponse();
        }

        private static Builder createBuilder() {
            return new Builder();
        }

        public Builder withId(Integer id) {
            addPetResponse.setId(id);
            return this;
        }

        public Builder withCategory(Category category) {
            addPetResponse.setCategory(category);
            return this;
        }

        public Builder withName(String name) {
            addPetResponse.setName(name);
            return this;
        }

        public Builder withPhotoUrls(List<String> photoUrls) {
            addPetResponse.setPhotoUrls(photoUrls);
            return this;
        }

        public Builder withTags(List<Tag> tags) {
            addPetResponse.setTags(tags);
            return this;
        }

        public Builder withStatus(Status status) {
            addPetResponse.setStatus(status);
            return this;
        }

        public AddPetResponse build() {
            return addPetResponse;
        }
    }
}
