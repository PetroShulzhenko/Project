package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Day {
    @XmlElement
    private final int number_of_day;
    @XmlElement
    private ArrayList<String> exercises;

    public Day(int number_of_day) {
        this.number_of_day = number_of_day;
    }

    public void addExercise(String exercise) {
        exercises.add(exercise);
    }

    public int size() {
        return exercises.size();
    }

    public int getNumberOfDay() {
        return number_of_day;
    }

    public ArrayList<String> getExercises() {
        return exercises;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Day{number_od_day=")
                .append(number_of_day)
                .append(", exercises=['");
        for (int i = 0, end_ = exercises.size() - 1; i < end_; ++i) {
            builder.append(exercises.get(i))
                    .append('\'')
                    .append(", '");
        }
        builder.append(exercises.get(exercises.size() - 1))
                .append('\'')
                .append("]}");

        return builder.toString();
    }
}
