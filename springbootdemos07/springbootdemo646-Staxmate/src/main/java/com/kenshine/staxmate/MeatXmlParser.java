package com.kenshine.staxmate;

import com.ctc.wstx.stax.WstxInputFactory;
import com.kenshine.staxmate.model.Animal;
import com.kenshine.staxmate.model.Food;
import com.kenshine.staxmate.model.Meat;
import com.kenshine.staxmate.model.Vegetable;
import org.codehaus.staxmate.SMInputFactory;
import org.codehaus.staxmate.in.SMHierarchicCursor;
import org.codehaus.staxmate.in.SMInputCursor;

import javax.xml.stream.XMLStreamException;
import java.io.InputStream;
import java.util.List;

/**
 * @author xml解析器 staxmate+woodstox
 */
public final class MeatXmlParser {

    private static final SMInputFactory FACTORY = new SMInputFactory(new WstxInputFactory());

    public Food parse(InputStream xml) throws XMLStreamException {
        Food food = new Food();

        SMHierarchicCursor rootC = FACTORY.rootElementCursor(xml);

        try {
            rootC.advance();

            SMInputCursor rootChildCursor = rootC.childElementCursor();

            while (rootChildCursor.getNext() != null) {
                handleRootChildElement(food, rootChildCursor);
            }
        } finally {
            rootC.getStreamReader().closeCompletely();
        }

        return food;
    }

    private void handleRootChildElement(Food food, SMInputCursor rootChildCursor) throws XMLStreamException {

        switch (rootChildCursor.getLocalName()) {
            case "animals":
                handleAnimals(food.getAnimals(), rootChildCursor.childElementCursor());
                break;
            case "vegetables":
                handleVegetables(food.getVegetables(), rootChildCursor.childElementCursor());
                break;
        }
    }

    private void handleVegetables(List<Vegetable> vegetables, SMInputCursor vegetablesCursor) throws
        XMLStreamException {
        while (vegetablesCursor.getNext() != null) {
            vegetables.add(extractVegetable(vegetablesCursor));
        }
    }

    private void handleAnimals(List<Animal> animals, SMInputCursor animalsCursor) throws XMLStreamException {
        while (animalsCursor.getNext() != null) {
            animals.add(extractAnimal(animalsCursor));
        }
    }

    private Animal extractAnimal(SMInputCursor animalsCursor) throws XMLStreamException {
        Animal a = new Animal();
        a.setName(animalsCursor.getAttrValue("name"));

        SMInputCursor meatsCursor = animalsCursor.childElementCursor();

        while (meatsCursor.getNext() != null) {
            Meat m = new Meat();
            SMInputCursor nameCursor = meatsCursor.childElementCursor().advance();
            m.setName(nameCursor.getElemStringValue());
            a.getMeats().add(m);
        }

        return a;
    }

    private Vegetable extractVegetable(SMInputCursor vegetableCursor) throws XMLStreamException {
        Vegetable v = new Vegetable();

        SMInputCursor vegChildCursor = vegetableCursor.childElementCursor();

        while (vegChildCursor.getNext() != null) {
            switch (vegChildCursor.getLocalName()) {
                case "name":
                    v.setName(vegChildCursor.getElemStringValue());
                    break;
                case "preparations":
                    SMInputCursor preparationCursor = vegChildCursor.childElementCursor();
                    while (preparationCursor.getNext() != null) {
                        v.getPreparations().add(preparationCursor.getElemStringValue());
                    }
                    break;
            }
        }

        return v;
    }
}