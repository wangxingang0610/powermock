package com.powermock.demo12;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import java.io.File;

import static org.junit.Assert.*;

public class FileServiceTest {

    @Test
    public void testWrite() {
        FileService fileService = PowerMockito.mock(FileService.class);

        fileService.write("ddd");
    }


    @Test
    public void testWriteWithSpy() {
        FileService fileService = PowerMockito.spy(new FileService());
        fileService.write("ddd");

        System.out.println(System.getProperty("user.dir"));

        try {
            File file = new File(System.getProperty("user.dir") + "/wangxingang.txt");
            assertTrue(file.exists());
        }catch (Exception e){
            fail("error ");
        }

    }




}