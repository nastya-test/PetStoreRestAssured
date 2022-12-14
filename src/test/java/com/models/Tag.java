package com.models;

public class Tag {

    private Integer id;
    private String name;

    public Tag() {
    }

    private Tag(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Builder builder() {
        return Builder.createBuilder();
    }

    public static final class Builder {
        private Tag tag;

        private Builder() {
            tag = new Tag();
        }

        public static Builder createBuilder() {
            return new Builder();
        }

        public Builder withId(int id) {
            tag.setId(id);
            return this;
        }

        public Builder withName(String name) {
            tag.setName(name);
            return this;
        }

        public Tag build() {
            return tag;
        }
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
