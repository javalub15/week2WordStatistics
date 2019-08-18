package com.cagara.service;

import com.cagara.dto.AlphabetStatistic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AlphabetStatisticServiceImpl implements AlphabetStatisticService {

    @Override
    public List<AlphabetStatistic> findTopTenAlphabetCharacters(String text) {
        Map<Integer, Integer> map = new HashMap<>();
        text.chars()
                .filter(Character::isAlphabetic)
                .forEach(
                        character -> {
                            map.merge(character, 1, Integer::sum);
                        }
                );
        return map.entrySet()
                .stream()
                .sorted((Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) -> e2.getValue()
                        .compareTo(e1.getValue())
                )
                .map(e -> AlphabetStatistic.of(convertToString(e.getKey()), e.getValue()))
                .limit(10)
                .collect(Collectors.toList());
    }

    private String convertToString(Integer value) {
        return Character.toString((char)(int) value);
    }
}
