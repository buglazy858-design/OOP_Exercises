package Exercise2;
public class DogMain {

    private String name;
    private String breed;

    DogMain(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public static void main (String[] args) {

        DogMain dog1 = new DogMain("Brownie", "Shitzu");
        DogMain dog2 = new DogMain("Blacky", "Golden Retriever");

        dog1.setName("Cookie");
        dog1.setBreed("Bulldog");

        dog2.setName("Cream");
        dog2.setBreed("Poodle");

        System.out.println("Dog1: " + dog1.name + " is a " + dog1.breed + " breed");
        System.out.println("Dog2: " + dog2.name + " is a " + dog2.breed + " breed");
    }
}
