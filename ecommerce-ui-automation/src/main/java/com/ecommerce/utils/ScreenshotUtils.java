package com.ecommerce.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public final class ScreenshotUtils {
    private ScreenshotUtils() {}

    public static Path capture(WebDriver driver, String fileName) throws IOException {
        Path directory = Paths.get("screenshots");
        Files.createDirectories(directory);

        String safeName = fileName.replaceAll("[^a-zA-Z0-9._-]", "_");
        Path destination = directory.resolve(safeName + ".png");
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

        return Files.write(destination, screenshot);
    }
}
