package testmybatis.pojo;

public class Course {
    private Integer id;
    private String corname;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courname='" + corname + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourname() {
        return corname;
    }

    public void setCourname(String courname) {
        this.corname = courname;
    }
}
