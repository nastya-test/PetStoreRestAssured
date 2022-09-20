package com.models;

public class Category {

    private Integer id;
    private String name;

    public Category() {
    }

    private Category(Integer id, String name) {
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

    //Пример для статического вложенного класса
    /*
    //повышает инкапсуляцию и способствует более реалистичной абстракции
    //Объект статического класса instruction не хранит ссылку на конкретный экземпляр внешнего класса.
    //Объект статического вложенного класса вполне может существовать сам по себе.
    //В этом плане статические классы более «независимы», чем нестатические.
    //Статический вложенный класс может обращаться только к статическим полям внешнего класса.
    private static int maxCategoryCount = 300;
    public static class Instruction {
        public static int getMaxCategoryCount() {
            return maxCategoryCount;
        }

        //Самих объектов мы можем создать сколько угодно:
        private int id;

        public Instruction(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Instruction{" +
                    "id=" + id +
                    '}';
        }

        public static void main(String[] args) {

            for (int i = 1; i < 4; i++) {
                Category.Instruction instruction = new Category.Instruction(i);
                System.out.println(instruction);
            }
        }
    }*/



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
