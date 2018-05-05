package service.filescanner;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileScannerServiceImpl implements FileScannerService {


    @Override
    public List<FileInfo> getFileInfo(String directoryPath) {
        List<FileInfo> fileInfos = new ArrayList();
        try {
            Path dirPath = Paths.get(directoryPath);
            fileInfos =  Files.list(dirPath).map(path -> FileInfoUtils.constructFileInfo(path.toFile())).collect(Collectors.toList());
        } catch (Exception ex) {

        }
        return fileInfos;
    }

    @Override
    public List<File> getFiles(String directoryPath, String mimeType) {
        List<File> filteredFiles = new ArrayList();
        try {
            Path dirPath = Paths.get(directoryPath);
            filteredFiles = Files.list(dirPath).filter(path -> mimeType.equals(FileInfoUtils.getFileMimeType(path.toFile()))).map(path -> path.toFile()).collect(Collectors.toList());
        } catch (Exception ex) {

        }
        filteredFiles.forEach(file -> FileInfoUtils.constructFileInfo(file).toString());
        return filteredFiles;

    }

    //mimeType='text/csv'
    //'application/vnd.ms-excel'

    public static void main(String... args) {
        FileScannerServiceImpl fileScanner = new FileScannerServiceImpl();
        fileScanner.getFileInfo("C:\\Users\\sikwm3\\Downloads").forEach(System.out::println);
        fileScanner.getFiles("C:\\Users\\sikwm3\\Downloads", "text/csv").forEach(System.out::println);
        fileScanner.getFiles("C:\\Users\\sikwm3\\Downloads", "application/vnd.ms-excel").forEach(System.out::println);

    }
}
