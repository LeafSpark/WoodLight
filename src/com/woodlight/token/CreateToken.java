package com.woodlight.token;

import com.woodlight.Color;
import com.woodlight.annotation.Buggy;
import com.woodlight.annotation.Test;
import com.woodlight.annotation.Uncompleted;
import jdk.jfr.Experimental;

import java.util.UUID;

@Buggy
@Test
@Uncompleted
@Experimental
public class CreateToken {
    public void tokenGenerate(int amount) {
        for (int i = 0; i <= amount; i++) {
            System.out.println(Color.GREEN + "UUID (" + i + "): " + UUID.randomUUID() + Color.RESET);
        }
    }
    public void tokenArray(int amount) {
        UUID[] uuids = {UUID.fromString("00000000-0000-0000-0000-000000000000")};
        for (int i = 0; i <= amount; i++) {
            uuids[i] = UUID.randomUUID();
        }
    }
}
