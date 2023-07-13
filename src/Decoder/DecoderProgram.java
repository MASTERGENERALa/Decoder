package Decoder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class DecoderProgram {
    public static void main(String[] args) {
        String fileName = "D:\\project\\Decoder\\src\\Decoder\\input.txt"; // Ім'я вхідного текстового файлу
        String textToAdd = "Це новий текст, який буде доданий до файлу."; // Текст для додавання

        try {
            // Додавання тексту до вхідного файлу
            Path filePath = Paths.get(fileName);
            Files.write(filePath, textToAdd.getBytes(), StandardOpenOption.APPEND);

            // Зчитування вмісту файлу
            String content = new String(Files.readAllBytes(filePath));

            // Заміна прийменників на слово "Java"
            String replacedContent = content.replaceAll("\\b[а-яА-Яa-zA-Z]+\\b", "Java");

            // Запис зміненого вмісту у вихідний файл
            Path outputFilePath = Paths.get("output.txt");
            Files.write(outputFilePath, replacedContent.getBytes());

            System.out.println("Текст успішно додано до вхідного файлу та замінено вміст, а потім записано до файлу output.txt");
        } catch (IOException e) {
            System.err.println("Помилка читання або запису до файлу: " + e.getMessage());
        }
    }
}



