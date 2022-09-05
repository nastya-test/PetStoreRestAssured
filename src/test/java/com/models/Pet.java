package com.models;

import java.util.List;

public class Pet {
    private String id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private Status status;

    private Pet() {
    }

    private Pet(String name, List<String> photoUrls) {
        this.name = name;
        this.photoUrls = photoUrls;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        private Pet pet;

        private Builder() {
            pet = new Pet();
        }

        private static Builder createBuilder() {
            return new Builder();
        }

        public Builder withId(String id) {
            pet.setId(id);
            return this;
        }

        public Builder withCategory(Category category) {
            pet.setCategory(category);
            return this;
        }

        public Builder withName(String name) {
            pet.setName(name);
            return this;
        }

        public Builder withPhotoUrls(List<String> photoUrls) {
            pet.setPhotoUrls(photoUrls);
            return this;
        }

        public Builder withTags(List<Tag> tags) {
            pet.setTags(tags);
            return this;
        }

        public Builder withStatus(Status status) {
            pet.setStatus(status);
            return this;
        }

        public Pet build() {
            return pet;
        }
    }
}
