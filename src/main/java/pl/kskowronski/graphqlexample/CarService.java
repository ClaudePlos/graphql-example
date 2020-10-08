package pl.kskowronski.graphqlexample;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.kskowronski.graphqlexample.dao.Car;
import pl.kskowronski.graphqlexample.dao.CarRepo;

import java.util.List;

@Service
public class CarService {

    private CarRepo carRepo;

    public CarService(CarRepo carRepo){
        this.carRepo = carRepo;
    }

    public List<Car> getCars(){
        return carRepo.findAll();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        carRepo.save(new Car("Audi","A3","https://www.otomoto.pl/osobowe/audi/a3/"));
        carRepo.save(new Car("Audi","A4","https://www.audi.pl/pl/web/pl/modele/a4/a4-avant.html?gclid=EAIaIQobChMI_9uxv7Wl7AIVi7t3Ch3WPQBdEAAYASAAEgJrffD_BwE"));
    }

}
