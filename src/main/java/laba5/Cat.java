package laba5;

public class Cat implements Sound, Breed, TypeOfAnimal {
    @Override
    public void getSound()
    {
        System.out.println("meow");
    }

    @Override
    public void getBreed()
    {
        System.out.println("Maine Coon");
    }

    @Override
    public void getTypeOfAnimal()
    {
        System.out.println("cat");
    }
}
