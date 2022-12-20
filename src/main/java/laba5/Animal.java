package laba5;

public class Animal {

    @AutoInjectable
    private Sound sound;
    @AutoInjectable
    private Breed breed;
    @AutoInjectable
    private TypeOfAnimal typeOfAnimal;

    public void infoAnimal()
    {
        sound.getSound();
        breed.getBreed();
        typeOfAnimal.getTypeOfAnimal();
    }


}

