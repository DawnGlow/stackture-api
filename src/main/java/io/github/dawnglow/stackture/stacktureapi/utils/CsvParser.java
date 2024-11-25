package io.github.dawnglow.stackture.stacktureapi.utils;

import io.github.dawnglow.stackture.stacktureapi.domain.TechStack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CsvParser {
    private static final Logger logger = LoggerFactory.getLogger(CsvParser.class);
    private static final String CSV_LOCATION = "tech-stacks.csv";

    /**
     * CSV 파일에서 TechStack 데이터를 읽어 리스트로 반환합니다.
     *
     * @return TechStack 객체 리스트
     */
    public static List<TechStack> getTechStacks() {
        List<TechStack> techStacks = new ArrayList<>();

        ClassLoader classLoader = CsvParser.class.getClassLoader();
        try (InputStream is = classLoader.getResourceAsStream(CSV_LOCATION)) {
            if (is == null) {
                logger.error("CSV 파일을 찾을 수 없습니다: {}", CSV_LOCATION);
                throw new RuntimeException("CSV 파일을 찾을 수 없습니다: " + CSV_LOCATION);
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                String line;
                boolean isHeader = true;

                while ((line = reader.readLine()) != null) {
                    // 헤더 라인 스킵
                    if (isHeader) {
                        isHeader = false;
                        continue;
                    }

                    String[] values = line.split(",");
                    if (values.length < 3) {
                        logger.warn("유효하지 않은 라인을 스킵합니다: {}", line);
                        continue;
                    }

                    String name = values[0].trim();
                    String logoUrl = values[1].trim();
                    // languages 필드는 쉼표로 구분된 문자열로 가정
                    List<String> languages = Arrays.asList(values).subList(2, values.length);
                    // 만약 languages가 단일 항목이라면 아래와 같이 처리할 수 있습니다:
                    // List<String> languages = List.of(values[2].trim());

                    TechStack techStack = new TechStack(name, logoUrl, languages);
                    techStacks.add(techStack);
                }
            }

        } catch (IOException e) {
            logger.error("CSV 파일 읽기 중 오류 발생: {}", CSV_LOCATION, e);
            throw new RuntimeException("CSV 파일 읽기 중 오류 발생: " + CSV_LOCATION, e);
        }

        return techStacks;
    }
}
