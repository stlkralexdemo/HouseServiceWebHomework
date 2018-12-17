package ru.itpark.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {
    private int id;
    private String district;
//    private int rooms;
//    private int area;
    private int price;
//    private boolean newBuilding;
}
