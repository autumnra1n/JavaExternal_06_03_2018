import controller.Barracks;
import model.dto.AbstractKnightAmmunition;
import model.dto.implementation.Knight;
import model.factories.AbstractAmmunitionFactory;
import model.factories.implementation.HauberkFactory;
import model.factories.implementation.SwordFactory;
import utils.Serializer;

import java.util.Arrays;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        AbstractAmmunitionFactory hauberkFactory = new HauberkFactory();
        AbstractAmmunitionFactory swordFactory = new SwordFactory();
        AbstractKnightAmmunition hauberk1 = hauberkFactory.createNewInstance(12,12,14);
        AbstractKnightAmmunition hauberk2 = hauberkFactory.createNewInstance(15,14,16);
        AbstractKnightAmmunition sword1 = swordFactory.createNewInstance(23,23,34);
        AbstractKnightAmmunition sword2 = swordFactory.createNewInstance(25,27,39);
        Knight knight = new Knight("Vasya");
        Barracks.equip(knight, sword1, hauberk1);
        System.out.println(knight);
        Barracks.equip(knight, sword2, hauberk2);
        System.out.println(knight);
        Serializer.serialize("file.bin",hauberk1,hauberk2,sword1,sword2);
        List<AbstractKnightAmmunition> abstractKnightAmmunition = Arrays.asList(Serializer.deserialize("file.bin"));
        System.out.println(abstractKnightAmmunition.toString());
    }
}
