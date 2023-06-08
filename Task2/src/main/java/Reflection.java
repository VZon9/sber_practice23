import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reflection {

    static public Animal mapToProductDto(Pet pet){
        Animal animal = new Animal();
        try {
            //Перекидываем name в title

            Class clazz = pet.getClass();
            Field fieldPet = clazz.getDeclaredField("name");
            fieldPet.setAccessible(true);
            clazz = animal.getClass();
            Field fieldAnimal = clazz.getDeclaredField("title");
            fieldAnimal.setAccessible(true);
            fieldAnimal.set(animal, fieldPet.get(pet));



            //Перекидываем status в булевские переменные

            clazz = pet.getClass();
            fieldPet = clazz.getDeclaredField("status");
            fieldPet.setAccessible(true);
            Status petStatus = (Status) fieldPet.get(pet);
            clazz = animal.getClass();
            if (petStatus == Status.SOLD){
                fieldAnimal = clazz.getDeclaredField("isAvailable");
                fieldAnimal.setAccessible(true);
                fieldAnimal.set(animal, false);
                fieldAnimal = clazz.getDeclaredField("isSold");
                fieldAnimal.setAccessible(true);
                fieldAnimal.set(animal, true);
            }
            else{
                fieldAnimal = clazz.getDeclaredField("isAvailable");
                fieldAnimal.setAccessible(true);
                fieldAnimal.set(animal, true);
                fieldAnimal = clazz.getDeclaredField("isSold");
                fieldAnimal.setAccessible(true);
                fieldAnimal.set(animal, false);
            }


            //Перекидываем List в Map
            Map<String, String> animalPhotoMap= new HashMap<>();
            String key, value;
            clazz = pet.getClass();
            fieldPet = clazz.getDeclaredField("photoList");
            fieldPet.setAccessible(true);
            List petPhotoList = (List) fieldPet.get(pet);
            for(Object object: petPhotoList){
                clazz = object.getClass();
                Method method = clazz.getMethod("getName");
                key = (String) method.invoke(object);
                method = clazz.getMethod("getURL");
                value = (String) method.invoke(object);
                animalPhotoMap.put(key, value);
            }
            clazz = animal.getClass();
            fieldAnimal = clazz.getDeclaredField("photoMap");
            fieldAnimal.setAccessible(true);
            fieldAnimal.set(animal, animalPhotoMap);
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return animal;
    }

    public static void main(String[] args) {
        Pet dog = new Pet("Igor", Status.SOLD, List.of(new Photo("Igor slip", "https://Igorslip.com"),
                                                            new Photo("Igor run", "https://Igorrun.com"),
                                                            new Photo("Igor eat", "https://Igoreat.com")));
        Animal igorDog = mapToProductDto(dog);
        System.out.println(igorDog);
    }

}
