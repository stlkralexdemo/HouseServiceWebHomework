package ru.itpark.service;

import org.springframework.stereotype.Service;
import ru.itpark.comparator.HousePriceAscComparator;
import ru.itpark.comparator.HousePriceDescComparator;
import ru.itpark.domain.House;
import ru.itpark.repository.HouseRepository;

import java.util.Comparator;
import java.util.List;

@Service
public class HouseService {
    private final HouseRepository repository;

    public HouseService(HouseRepository repository) {
        this.repository = repository;
    }

    public void add(int id, String district, int price) {
        repository.add(new House(id,district,price));
    }

    public List<House> getAll() {
        return repository.getAll();
    }

    public List<House> getSorted(Comparator<House> comparator) {
        List<House> result = repository.getAll();
        result.sort(comparator);
        return result;
    }

    public List<House> getByPriceRangeAsc(int min, int max) {
        List<House> result = repository.getByPriceRange(min, max);
        result.sort(new HousePriceAscComparator());
        return result;
    }

    public List<House> getByPriceRangeDesc(int min, int max) {
        List<House> result = repository.getByPriceRange(min, max);
        result.sort(new HousePriceDescComparator());
        return result;
    }

    public List<House> getByDistrict(List<String> districts) {
        return repository.getByDistrict(districts);
    }

}
