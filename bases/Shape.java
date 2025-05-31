package uap.bases;

public abstract class Shape {
    private String name;

    public void setName(String inputName){
        this.name = inputName;
    }
    public String getName(){
        return this.name;
    }
    public abstract void printInfo();
}
