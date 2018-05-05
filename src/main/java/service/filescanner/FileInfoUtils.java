package service.filescanner;


import javax.activation.FileTypeMap;
import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.nio.file.Path;

public final class FileInfoUtils {
    private static final MimetypesFileTypeMap mimeTypeMap = new MimetypesFileTypeMap();

    public static FileInfo constructFileInfo(File file) {
        return new FileInfo(file.getName(), mimeTypeMap.getContentType(file), file.length(), getFileExtension(file.getName()));
    }

    public static String getFileMimeType(File file) {
        return mimeTypeMap.getContentType(file);
    }

    public static String getFileExtension(String fileName) {
        int i = fileName.lastIndexOf('.');
        int p = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));
        String extension = "";
        if (i > p) {
            extension = fileName.substring(i + 1);
        }
        return extension;
    }
}
