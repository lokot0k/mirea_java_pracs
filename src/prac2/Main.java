package prac2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human(25, "a", "a", LocalDate.of(1992, 5, 15), 70));
        humans.add(new Human(30, "b", "b", LocalDate.of(1991, 9, 20), 65));
        humans.add(new Human(40, "c", "c", LocalDate.of(1980, 12, 1), 80));
        humans.add(new Human(35, "d", "d", LocalDate.of(1989, 3, 10), 60));
        humans.add(new Human(28, "e", "e", LocalDate.of(1987, 7, 25), 75));
        humans.add(new Human(20, "a1", "a1", LocalDate.of(2004, 5, 15), 55));
        humans.add(new Human(19, "b1", "b1", LocalDate.of(2003, 9, 20), 65));
        humans.add(new Human(18, "c1", "c1", LocalDate.of(2002, 12, 1), 120));
        humans.add(new Human(17, "d1", "d1", LocalDate.of(2001, 3, 10), 12));
        humans.add(new Human(16, "e1", "e1", LocalDate.of(2000, 7, 25), 5));

        humans.forEach(human -> System.out.println(human.getFirstName() + " " + human.getLastName()));


        List<Human> filteredHumans = humans.stream()
                .filter(human -> human.getWeight() > human.getAge())
                .toList();

        filteredHumans.forEach(human -> System.out.println(human.getFirstName() + " " + human.getLastName()));


        List<Human> sortedHumans = filteredHumans.stream()
                .sorted(Comparator.comparing(Human::getLastName).reversed())
                .toList();

        sortedHumans.forEach(human -> System.out.println(human.getFirstName() + " " + human.getLastName()));

        int totalWeight = sortedHumans.stream()
                .mapToInt(Human::getWeight)
                .sum();

        System.out.println(totalWeight);
    }
}
