package chat.models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private LocalDateTime date;
    private String login;
    private String text;

    @Override
    public String toString() {
        return String.format("%s | %s | %s", date, login, text);
    }
}
