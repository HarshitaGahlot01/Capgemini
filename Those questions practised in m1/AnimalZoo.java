import java.util.*;
interface IAnimal{
    int getId();
    String getSpecies();
    String getName();
    int getAge();
}
    interface IZoo {
        void addAnimal(IAnimal animal);
        void removeAnimal(int id);
        int countAnimals();
        List<IAnimal> getAnimalsBySpecies(String species);
        List<Map.Entry<Integer,List<IAnimal>>> getAnimalsByAge();
    }
    class Zoo implements IZoo{
        private List<IAnimal> animals = new ArrayList<>();
        public void addAnimal(IAnimal animal){
            animals.add(animal);
        }
        public void removeAnimal(int id){
            animals.removeIf(a->a.getId()==id);
        }
        public int  countAnimals(){
            return animals.size();
        }
        public List<IAnimal> getAnimalsBySpecies(String species){
            List<IAnimal> list = new ArrayList<>();

            for(IAnimal a : animals){
                if(a.getSpecies().equals(species)){
                    list.add(a);
                }
            }
            return list;
        }
        public List<Map.Entry<Integer,List<IAnimal>>> getAnimalsByAge(){

            Map<Integer,List<IAnimal>> m = new TreeMap<>(Collections.reverseOrder());

            for(IAnimal an : animals){
                m.putIfAbsent(an.getAge(), new ArrayList<IAnimal>());
                m.get(an.getAge()).add(an);
            }

            return new ArrayList<Map.Entry<Integer,List<IAnimal>>>(m.entrySet());
        }

}
class Animal implements IAnimal{
    private int id;
    private String species;
    private String name;
    private  int age;

    public Animal(int id, String species, String name, int age) {
        this.id=id;
        this.species=species;
        this.name=name;
        this.age=age;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
public class AnimalZoo {
}
