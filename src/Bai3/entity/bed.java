package Bai3.entity;

public class bed {
    private int id;
    private boolean bed_status;
    public bed(){
    }
    public bed(int id, boolean bed_status) {
        this.id = id;
        this.bed_status = bed_status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBed_status() {
        return bed_status;
    }

    public void setBed_status(boolean bed_status) {
        this.bed_status = bed_status;
    }
    @Override
    public String toString() {
        return "bed [id=" + id + ", bed_status=" + bed_status + "]";
    }
}
