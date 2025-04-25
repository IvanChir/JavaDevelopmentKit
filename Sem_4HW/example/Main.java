package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileDownloader downloader = new FileDownloader();

        System.out.print("Введите URL файла для скачивания: ");
        String fileURL = scanner.nextLine();

        System.out.print("Введите путь для сохранения файла: ");
        String saveDir = scanner.nextLine();

        System.out.print("Введите количество потоков для загрузки: ");
        int numberOfThreads = scanner.nextInt();

        downloader.downloadFile(fileURL, saveDir, numberOfThreads);
    }
}