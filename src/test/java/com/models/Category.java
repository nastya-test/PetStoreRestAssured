package com.models;

public class Category {

    private Integer id;
    private String name;

    public Category() {
    }

    public Category(Integer id, String name) {
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
        private Category category;

        private Builder() {
            category = new Category();
        }

        public static Builder createBuilder() {
            return new Builder();
        }

        public Builder withId(int id) {
            category.setId(id);
            return this;
        }

        public Builder withName(String name) {
            category.setName(name);
            return this;
        }

        public Category build() {
            return category;
        }
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
