import model.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Main {

  private static final String FILE_NAME = "resources/city_ru.csv";
  public static void main(String[] args) {
    var cityList = new ArrayList<City>();
    try (var scanner = new Scanner(new File(FILE_NAME)).useDelimiter("[;]")) {
      scanner.next();
      while (scanner.hasNext()) {
        var name = scanner.next();
        var region = scanner.next();
        var district = scanner.next();
        var population = scanner.nextInt();
        var tempFoundation = scanner.next();
        var foundation = tempFoundation.split("(\\r\\n|\\r|\\n)");
        cityList.add(new City(name, region, district, population, foundation[0]));
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    /**
    * Сортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра;
     */
    cityList.stream().sorted((x, y) -> x.getName().toLowerCase()
            .compareTo(y.getName().toLowerCase()))
            .forEach(System.out::println);

    /**
     * Сортировка списка городов по федеральному округу и наименованию города внутри каждого
     * федерального округа в алфавитном порядке по убыванию с учетом регистра;
     */

    Comparator<City> compareByDistrict = Comparator.comparing( City::getDistrict );
    Comparator<City> compareByName = Comparator.comparing( City::getName );
    Comparator<City> compareByDistrictAndName = compareByDistrict.thenComparing(compareByName);
    cityList.sort(compareByDistrictAndName);
    cityList.forEach(System.out::println);

  }
}