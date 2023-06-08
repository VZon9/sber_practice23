import java.util.List;

public class Pet {
    private String name;
    private Status status;
    private List<Photo> photoList;

    public Pet(String name, Status status, List<Photo> photoList) {
        this.name = name;
        this.status = status;
        this.photoList = photoList;
    }
}
