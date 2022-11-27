package ru.netology.java;

public class Radio {

    private int stationNumber = 0;
    private int volume = 0;


    public int getStationNumber() {
        return stationNumber;
    }

    public int getVolume() {
        return volume;
    }

    public void setStation(int stationNumber) {
        if (stationNumber >= 0) {
            if (stationNumber <= 9) {
                this.stationNumber = stationNumber;
            }
        }
    }

    public void next() {
        if (stationNumber < 9) {
            stationNumber++;
        } else {
            stationNumber = 0;
        }
    }

    public void prev() {
        if (stationNumber > 0) {
            stationNumber--;
        } else {
            stationNumber = 9;
        }
    }

    public void increaseVolume() {
        if (volume < 10) {
            volume++;
        }
    }

    public void decreaseVolume() {
        if (volume > 0) {
            volume--;
        }
    }
}