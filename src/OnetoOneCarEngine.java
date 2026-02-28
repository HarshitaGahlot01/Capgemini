class Engine{
    String type;
    Engine(String type){
        this.type=type;
    }
}class Car{
    String model;
    Engine e;
    Car(String model,Engine e){
        this.model=model;
        this.e=e;
    }
    void display(){
        System.out.println("Type:"+e.type);
        System.out.println("Model:"+model);
    }
}

public class OnetoOneCarEngine {
    public static void main(String[] args) {
        Engine e=new Engine("Abc");
        Car c=new Car("wagonar",e);
        c.display();
    }
}
