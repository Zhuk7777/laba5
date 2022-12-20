package laba5;

public class Main {
    public static void main(String[] args) throws Exception
    {
        Injector obj = new Injector();
        String pathDog="src/main/java/laba5/dog.properties";
        String pathCat="src/main/java/laba5/cat.properties";

        System.out.println("reading from the first file");
        Animal animal=(Animal) obj.inject(new Animal(),pathDog);
        animal.infoAnimal();

        System.out.println("reading from the second file");
        animal=(Animal) obj.inject(new Animal(),pathCat);
        animal.infoAnimal();
    }
}
