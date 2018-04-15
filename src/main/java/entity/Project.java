package entity;

public class Project {
    private long projects_id;
    private String projects_Name;
    private  int projects_Uroven;
    private Double cost;

    public long getProjects_id() {
        return projects_id;
    }

    public void setProjects_id(long projects_id) {
        this.projects_id = projects_id;
    }

    public String getProjects_Name() {
        return projects_Name;
    }

    public void setProjects_Name(String projects_Name) {
        this.projects_Name = projects_Name;
    }

    public int getProjects_Uroven() {
        return projects_Uroven;
    }

    public void setProjects_Uroven(int projects_Uroven) {
        this.projects_Uroven = projects_Uroven;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projects_id=" + projects_id +
                ", projects_Name='" + projects_Name + '\'' +
                ", projects_Uroven=" + projects_Uroven +
                ", cost=" + cost +
                '}';
    }
}
