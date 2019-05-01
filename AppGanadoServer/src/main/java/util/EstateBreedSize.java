package util;


public class EstateBreedSize {

    private String name;
    private Long count;

    public EstateBreedSize(String name, Long count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return "EstateBreedSize{" + "name=" + name + ", count=" + count + '}';
    }

    public String getName() {
        return name;
    }

    public Long getCount() {
        return count;
    }

}
