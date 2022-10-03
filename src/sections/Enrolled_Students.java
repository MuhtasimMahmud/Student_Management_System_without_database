package sections;

public class Enrolled_Students {

    private String name;
    private String id;
    private int section;

    public Enrolled_Students(String name, String id, int section) {
        this.name = name;
        this.id = id;
        this.section = section;
    }


    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getSection() {
        return section;
    }
}
