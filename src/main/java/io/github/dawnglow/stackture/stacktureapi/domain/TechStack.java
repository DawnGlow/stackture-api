package io.github.dawnglow.stackture.stacktureapi.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TechStack {
    private Long id;

    private String name;

    private String imageUrl;

    private List<String> groupNames = new ArrayList<>();

    public TechStack(String name, String imageUrl, List<String> groupNames) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.groupNames = groupNames;
    }
}
