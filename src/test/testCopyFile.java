package test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class testCopyFile {

	public static void main(String[] args) {
		String sourcePathString = "C:/Users/Hung/Pictures/chieu-da-lat-mong-mo.jpg";
		String[] parts = sourcePathString.split("/");
        Path source = Paths.get(sourcePathString);

        // Đường dẫn của thư mục đích
        String pathString="src/Images/";
        Path destination = Paths.get(pathString);
        String newPath=pathString+parts[parts.length - 1];
        try {
            // Sao chép file từ source đến destination
            Files.copy(source, destination.resolve(source.getFileName()));
        } catch (IOException e) {
            e.printStackTrace();
        }

	}

}
