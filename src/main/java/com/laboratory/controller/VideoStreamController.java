package com.laboratory.controller;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.laboratory.entity.VideoFrame;

@Controller
public class VideoStreamController {
	private final VideoCapture videoCapture;

    @Autowired
    public VideoStreamController(VideoCapture videoCapture) {
        this.videoCapture = videoCapture;
    }

    @MessageMapping("/video")
    @SendTo("/topic/video")
    public VideoFrame videoFrame() {
        Mat frame = new Mat();
        videoCapture.read(frame);

        // Convierte el frame de OpenCV (Mat) a un array de bytes
        byte[] frameData = new byte[(int) (frame.total() * frame.elemSize())];
        frame.data().get(frameData);

        return new VideoFrame(frameData, System.currentTimeMillis());
    }
}
