package model;

import java.util.Objects;

public class City {
  private final String name;
  private final String region;
  private final String district;
  private final int population;
  private final String foundation;

  /**
   * Creates an employee with the specified name.
   *
   * @param name       наименование города
   * @param region     регион
   * @param district   федеральный округ
   * @param population количество жителей города
   * @param foundation дата основания или первое упоминание
   */
  public City(String name, String region, String district, int population, String foundation) {
    this.name = name;
    this.region = region;
    this.district = district;
    this.population = population;
    this.foundation = foundation;
  }

  @Override
  public String toString() {
    return "City{" +
      "name='" + name + '\'' +
      ", region='" + region + '\'' +
      ", district='" + district + '\'' +
      ", population=" + population +
      ", foundation='" + foundation + '\'' +
      '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, region, district, population, foundation);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    var city = (City) obj;
    return this.name.equals(city.name) && this.region.equals(city.region)
      && this.district.equals(city.district) && this.population == city.population
      && this.foundation.equals(city.foundation);
  }

  public String getName() {
    return name;
  }

  public String getDistrict() {
    return district;
  }
}
