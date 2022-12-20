package laba5;

public class Dog implements Sound, Breed, TypeOfAnimal {
    @Override
    public void getSound()
    {
        System.out.println("woof");
    }

    @Override
    public void getBreed()
    {
        System.out.println("Sheepdog");
    }

    @Override
    public void getTypeOfAnimal()
    {
        System.out.println("dog");
    }
}
