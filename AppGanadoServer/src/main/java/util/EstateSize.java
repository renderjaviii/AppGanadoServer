package util;

public class EstateSize {

    private Integer id;
    private String name;
    private Long count;

    public EstateSize(Integer id, String name, Long count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "EstateSize{" + "id=" + id + ", name=" + name + ", count=" + count + '}';
    }

}
