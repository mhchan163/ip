public class ToDo extends Task{

    public ToDo(String description) {
        super(description);
    }

    public String toString(){
        return "[T]" + super.toString();
    }
    public String getStatusIcon() {
       return super.getStatusIcon();
    }

}
