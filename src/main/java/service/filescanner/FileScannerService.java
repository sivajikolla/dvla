package service.filescanner;


import java.io.File;
import java.util.List;

public interface FileScannerService {
    List<FileInfo> getFileInfo(String directoryPath);
    List<File> getFiles(String directoryPath, String mimeType);
}
