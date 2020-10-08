package pl.kskowronski.graphqlexample.ql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import pl.kskowronski.graphqlexample.CarService;
import pl.kskowronski.graphqlexample.dao.Car;

import java.util.List;

@Component
public class CarQuery  implements GraphQLQueryResolver {

    private CarService carService;

    public CarQuery(CarService carService){
        this.carService = carService;
    }

    public List<Car> getCars(){
        return carService.getCars();
    }


}
