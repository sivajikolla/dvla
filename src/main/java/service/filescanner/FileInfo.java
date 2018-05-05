package service.filescanner;

public class FileInfo {
    String fileName;
    String mimeType;
    long fileSize; // file size in bytes.
    String fileExtension;

    public FileInfo(String fileName, String mimeType, long fileSize, String fileExtension) {
        this.fileName = fileName;
        this.mimeType = mimeType;
        this.fileSize = fileSize;
        this.fileExtension = fileExtension;
    }

    public String getFileName() {
        return fileName;
    }

    public String getMimeType() {
        return mimeType;
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "fileName='" + fileName + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                ", fileExtension='" + fileExtension + '\'' +
                '}';
    }
}
