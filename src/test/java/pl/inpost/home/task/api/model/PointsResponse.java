package pl.inpost.home.task.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PointsResponse {
    private List<Point> items;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Point> getItems() {
        return items;
    }

    public void setItems(List<Point> items) {
        this.items = items;
    }

    @JsonProperty("total_pages")
    private int totalPages;
}
