package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.S04T02N02GognomsNom.controllers;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.S04T02N02GognomsNom.model.domain.Fruit;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.S04T02N02GognomsNom.model.services.FruitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    @Autowired
    private FruitServiceImpl fruitServiceImpl;

    @PostMapping("/add")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit) {

            Fruit addedFruit = fruitServiceImpl.addFruit(fruit);
            return new ResponseEntity<>(addedFruit, HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruit> updateFruit(@PathVariable int id, @RequestBody Fruit fruit) {

            Fruit updatedFruit = fruitServiceImpl.updateFruit(id, fruit);

            return new ResponseEntity<>(updatedFruit, HttpStatus.OK);


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Fruit> deleteFruit(@PathVariable int id) {

            boolean isDeleted = fruitServiceImpl.deleteFruit(id);

                return new ResponseEntity<>(HttpStatus.OK);



    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() {

            Iterable<Fruit> fruitIterable = fruitServiceImpl.getAllFruits();
            List<Fruit> fruits = StreamSupport.stream(fruitIterable.spliterator(), false)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(fruits, HttpStatus.OK);


    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable int id) {
        Optional<Fruit> fruit = fruitServiceImpl.getFruitById(id);
        return fruit.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
