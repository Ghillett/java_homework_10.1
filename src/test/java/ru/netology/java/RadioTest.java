package ru.netology.java;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {

    //использовала для проверки метод граничных значений

    @ParameterizedTest
    @CsvSource({
            "8, 8",
            "9, 9",
            "10, 0"
    })
    public void shouldCheckMaxStationSet(int stationNumber, int expected) {

        Radio radio = new Radio();

        radio.setStation(stationNumber);

        int actual = radio.getStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "0, 0",
            "-1, 0"
    })
    public void shouldCheckMinStationSet(int stationNumber, int expected) {

        Radio radio = new Radio();
        radio.setStation(stationNumber);

        int actual = radio.getStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "7, 8",
            "8, 9",
            "9, 0"
    })
    public void shouldCheckMaxStationSwitch(int stationNumber, int expected) {

        Radio radio = new Radio();

        radio.setStation(stationNumber);

        radio.next();

        int actual = radio.getStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 1",
            "1, 0",
            "0, 9"
    })
    public void shouldCheckMinStationSwitch(int stationNumber, int expected) {

        Radio radio = new Radio();

        radio.setStation(stationNumber);

        radio.prev();

        int actual = radio.getStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "9, 9",
            "10, 10",
            "11, 10"
    })
    public void shouldCheckMaxVolume(int clicks, int expected) {

        Radio radio = new Radio();
        for (int i = 0; i < clicks; i++) {
            radio.increaseVolume();
        }

        int actual = radio.getVolume();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 0",
            "3, 0"
    })
    public void shouldCheckMinVolume(int clicks, int expected) {

        Radio radio = new Radio();

        //поднять громкость до 2, чтобы протестировать переход вниз на громкость 1

        radio.increaseVolume();
        radio.increaseVolume();

        for (int i = 0; i < clicks; i++) {
            radio.decreaseVolume();
        }

        int actual = radio.getVolume();

        Assertions.assertEquals(expected, actual);
    }
}