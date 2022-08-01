package com.harmex.deathcube.thirst;

public class ClientThirstData {
    private static int playerThirst;
    private static int playerThirstSaturation;

    public static void set(int thirst, int thirstSaturation) {
        ClientThirstData.playerThirst = thirst;
        ClientThirstData.playerThirstSaturation = thirstSaturation;
    }

    public static int getPlayerThirst() {
        return playerThirst;
    }

    public static int getPlayerThirstSaturation() {
        return playerThirstSaturation;
    }
}
