package org.example;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HazelcastSpeedTest {

    private static final Random random = new Random();

    public static void main(String[] args) {
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
        try {
            IMap<Integer, Integer> map = hazelcastInstance.getMap("speedTestMap");

            performOperation(map, 20_000);
            performOperation(map, 100_000);
        } finally {
            hazelcastInstance.shutdown();
        }
    }

    private static void performOperation(IMap<Integer, Integer> map, int operations) {
        Set<Integer> keys = new HashSet<>();

        // insertion
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < operations; i++) {
            int key = random.nextInt();
            keys.add(key);
            map.put(key, random.nextInt());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Hazelcast " + operations + " insertion: " + (endTime - startTime) + " ms");

        // selection
        startTime = System.currentTimeMillis();
        for (Integer key : keys) {
            map.get(key);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Hazelcast " + operations + " selection: " + (endTime - startTime) + " ms");
    }
}