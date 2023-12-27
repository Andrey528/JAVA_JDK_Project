package chat.controllers;

import chat.models.Message;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVWorker {
    private Message message;
    StringBuilder stringBuilder = new StringBuilder();

    public void save(String path, Message message) {
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.append(String.format("%s, ", message.getDate()));
            writer.append(String.format("%s, ", message.getLogin()));
            writer.append(String.format("%s\n", message.getText()));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String load(String path) {
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                message = getRecordFromLine(scanner.nextLine());
                stringBuilder.append(String.format("%s: %s\n", message.getLogin(), message.getText()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public Message getRecordFromLine(String line) {
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(", ");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
            message = new Message(
                LocalDateTime.parse(values.get(0)), values.get(1), values.get(2));
        }
        return message;
    }
}
