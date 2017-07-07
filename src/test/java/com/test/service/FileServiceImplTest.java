package com.test.service;

import com.test.model.FileInfo;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class FileServiceImplTest {

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void getFileInfo() throws Exception {
        List<String> unsupportedFileTypes = new ArrayList<>();
        unsupportedFileTypes.add("text/html");
        FileServiceImpl instance = new FileServiceImpl(unsupportedFileTypes);
        List<FileInfo> fileInfo = instance.getFileInfo("target/test-classes/test-files");
        Assert.assertThat(fileInfo.size(), equalTo(5));
        Assert.assertThat(fileInfo, hasItem(new FileInfo("text/plain", "application", "file1.txt", true)));
        Assert.assertThat(fileInfo, hasItem(new FileInfo("text/html", "application", "file3.html", false)));
      
    }

}