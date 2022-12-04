package ru.netology.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {

    //тесты конструкторов

    @Test
    public void shouldCreateDefault() {
        Radio radio = new Radio();

        int expected = 10;
        Assertions.assertEquals(expected, radio.getStationsQuantity());
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 10",
            "0, 10",
            "1, 1"
    })
    public void shouldCreateMinQuantity(int stationsQuantity, int expected) {

        Radio radio = new Radio(stationsQuantity);

        Assertions.assertEquals(expected, radio.getStationsQuantity());
    }

    @ParameterizedTest
    @CsvSource({
            "99, 99",
            "100, 100",
            "101, 10"
    })
    public void shouldCreateMaxQuantity(int stationsQuantity, int expected) {

        Radio radio = new Radio(stationsQuantity);

        Assertions.assertEquals(expected, radio.getStationsQuantity());
    }

    //тест сеттера станций

    @ParameterizedTest
    @CsvSource({
            "-1, 0",
            "0, 0",
            "1, 1"
    })
    public void shouldSetStationsDefaultMin(int stationNumber, int expected) {
        Radio radio = new Radio();

        radio.setStation(stationNumber);

        Assertions.assertEquals(expected, radio.getStationNumber());
    }

    @ParameterizedTest
    @CsvSource({
            "8, 8",
            "9, 9",
            "10, 0"
    })
    public void shouldSetStationsDefaultMax(int stationNumber, int expected) {
        Radio radio = new Radio();

        radio.setStation(stationNumber);

        Assertions.assertEquals(expected, radio.getStationNumber());
    }

    @ParameterizedTest
    @CsvSource({
            "50, -1, 0",
            "50, 0, 0",
            "50, 1, 1"
    })
    public void shouldSetStationsCustomMin(int stationsQuantity, int stationNumber, int expected) {

        Radio radio = new Radio(stationsQuantity);

        radio.setStation(stationNumber);

        Assertions.assertEquals(expected, radio.getStationNumber());
    }

    @ParameterizedTest
    @CsvSource({
            "50, 49, 49",
            "50, 50, 0",
            "50, 51, 0"
    })
    public void shouldSetStationsCustomMax(int stationsQuantity, int stationNumber, int expected) {

        Radio radio = new Radio(stationsQuantity);

        radio.setStation(stationNumber);

        Assertions.assertEquals(expected, radio.getStationNumber());
    }

    //тесты переключения станции

    Radio radio = new Radio();

    @ParameterizedTest
    @CsvSource({
            "8, 8",
            "9, 9",
            "10, 0"
    })
    public void shouldCheckMaxStationSet(int stationNumber, int expected) {

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

        radio.setStation(stationNumber);

        radio.prev();

        int actual = radio.getStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    //тесты переключения громкости

    @ParameterizedTest
    @CsvSource({
            "99, 99",
            "100, 100",
            "101, 100"
    })

    public void shouldCheckMaxVolume(int clicks, int expected) {

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