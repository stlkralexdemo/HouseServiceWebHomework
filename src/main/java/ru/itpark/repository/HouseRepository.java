package ru.itpark.repository;

import org.springframework.stereotype.Repository;
import ru.itpark.domain.House;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HouseRepository {
    private  final List<House> houses = new ArrayList<>();

    public void add(House house) {
        this.houses.add(house);
    }

    public List<House> getAll() {
        return houses;
    }

    public List<House> getByPriceRange(int min, int max) {
        List<House> result = new ArrayList<>();
        for (House house : houses) {
            if (min < house.getPrice() && house.getPrice() < max) {
                result.add(house);
            }
        }
        return result;
    }

    public List<House> getByDistrict(List<String> districts){
        List<House> result = new ArrayList<>();
        for (House house : houses) {
            if (districts.contains(house.getDistrict())){
                result.add(house);
            }

        }
        return result;
    }
}
