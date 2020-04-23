package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Week {
    @XmlElement
    private final int number_of_week;
    @XmlElement
    private final String header;
    @XmlElement
    private ArrayList<Day> days;

    public Week(int number_of_week, String header) {
        this.number_of_week = number_of_week;
        this.header = header;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Week{number_of_week=")
                .append(number_of_week)
                .append(", header='")
                .append(header)
                .append('\'')
                .append(", days=[");
        for (int i = 0, end_ = days.size() - 1; i < end_; ++i) {
            builder.append(days.get(i).toString())
                    .append(", ");
        }
        builder.append(days.get(days.size() - 1))
                .append("]}");

        return builder.toString();
    }
}
