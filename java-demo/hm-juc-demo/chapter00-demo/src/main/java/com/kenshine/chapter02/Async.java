package com.kenshine.chapter02;


import com.kenshine.Constants;
import com.kenshine.chapter02.util.FileReader;
import lombok.extern.slf4j.Slf4j;


@Slf4j(topic = "c.Async")
public class Async {

    public static void main(String[] args) {
        new Thread(() -> FileReader.read(Constants.MP4_FULL_PATH)).start();
        log.debug("do other things ...");
    }

}
