package mybatistest.pojo;

public class Emyloyeepojo {
    private String emname;
    private String empid;
    private Double empsalary;

    @Override
    public String toString() {
        return "Emyloyeepojo{" +
                "emname='" + emname + '\'' +
                ", empid='" + empid + '\'' +
                ", empsalary='" + empsalary + '\'' +
                '}';
    }

    public String getEmname() {
        return emname;
    }

    public void setEmname(String emname) {
        this.emname = emname;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public Double getEmpsalary() {
        return empsalary;
    }

    public void setEmpsalary(Double empsalary) {
        this.empsalary = empsalary;
    }
}
