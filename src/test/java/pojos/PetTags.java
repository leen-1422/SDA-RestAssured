package pojos;

public class PetTags {
    private Integer id;
    private String name;

    public PetTags() {
    }

    public PetTags(Integer id, String name) {
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

    @Override
    public String toString() {
        return "PetTags{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
