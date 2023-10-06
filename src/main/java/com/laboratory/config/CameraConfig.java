package com.laboratory.config;

import org.bytedeco.opencv.opencv_videoio.VideoCapture;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CameraConfig {
	@Bean
    public VideoCapture videoCapture() {
        // Puedes especificar el índice de la cámara web que deseas utilizar.
        // Normalmente, 0 representa la cámara web predeterminada.
        return new VideoCapture(0);
    }
}
