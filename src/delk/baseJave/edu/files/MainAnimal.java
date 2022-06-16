package delk.baseJave.edu.files;

import java.io.*;

public class MainAnimal {
    /**
     * Реализуйте метод, который из переданного массива байт восстановит массив объектов Animal.
     * Массив байт устроен следующим образом. Сначала идет число типа int,
     * записанное при помощи ObjectOutputStream.writeInt(size).
     * Далее подряд записано указанное количество объектов типа Animal,
     * сериализованных при помощи ObjectOutputStream.writeObject(animal).
     *
     * Если вдруг массив байт не является корректным представлением массива экземпляров Animal,
     * то метод должен бросить исключение java.lang.IllegalArgumentException.
     *
     * Причины некорректности могут быть разные. Попробуйте подать на вход методу разные некорректные данные
     * и посмотрите, какие исключения будут возникать. Вот их-то и нужно превратить в IllegalArgumentException
     * и выбросить. Если что-то забудете, то проверяющая система подскажет.
     * Главное не глотать никаких исключений, т.е. не оставлять нигде пустой catch.
     *
     */
    public static byte[] serializeAnimal(Animal [] animals) throws IOException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        ObjectOutputStream objects = new ObjectOutputStream(bytes);
        objects.writeInt (animals.length);
        // objects.writeInt (animals.length);
        for (Animal animal: animals) {
            objects.writeObject(animal);
        }
        return bytes.toByteArray();
    }

    public static Animal[] deserializeAnimalArray(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bytes = new ByteArrayInputStream(data);
        try (ObjectInputStream objects = new ObjectInputStream(bytes)) {
            int size = objects.readInt();
            Animal [] animals = new Animal[size];
            for (int i = 0; i<size; i++) {
                animals[i] = (Animal)objects.readObject();
            }
            return animals;
        }
        catch (IOException|IllegalArgumentException|ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Animal [] theAnimals = new Animal[3];
        theAnimals [0] = new Animal("Snupa");
        theAnimals [1] = new Animal("Barsik");
        theAnimals [2] = new Animal ("Baikal");

        byte[] bytes = serializeAnimal(theAnimals);

        Animal [] readAnimals = deserializeAnimalArray(bytes);
        for (Animal animal: readAnimals) {
            System.out.println(animal.getName());
        }
    }
}
