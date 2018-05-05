package exercise.service.filescanner;

import org.junit.Test;
import service.filescanner.FileInfo;
import service.filescanner.FileInfoUtils;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileInfoUtilsTest  {
    @Test
    public void testFileInfoConstruction() {
        File file = mock(File.class);

        when(file.getName()).thenReturn("testFile.csv");
        when(file.length()).thenReturn(2000L);

        FileInfo fileInfo = FileInfoUtils.constructFileInfo(file);
        //assert the file info that's being constructed.
        assertEquals("testFile.csv", fileInfo.getFileName());
        assertEquals(2000L, fileInfo.getFileSize());
        assertEquals("text/csv", fileInfo.getMimeType());
        assertEquals("csv", fileInfo.getFileExtension());
    }

}
