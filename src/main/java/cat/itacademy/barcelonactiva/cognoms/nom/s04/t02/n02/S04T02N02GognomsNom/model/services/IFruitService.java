package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.S04T02N02GognomsNom.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.S04T02N02GognomsNom.model.domain.Fruit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IFruitService {
    @Transactional
    Fruit addFruit(Fruit fruit);

    @Transactional
    Fruit updateFruit(int id, Fruit fruit);

    @Transactional
    boolean deleteFruit(int id);

    @Transactional(readOnly = true)
    Iterable<Fruit> getAllFruits();

    @Transactional(readOnly = true)
    Optional<Fruit> getFruitById(int id);
}
