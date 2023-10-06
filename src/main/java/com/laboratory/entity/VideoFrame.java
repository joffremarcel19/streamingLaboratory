package com.laboratory.entity;

import lombok.Data;

@Data
public class VideoFrame {
	
	private byte[] frameData; // Datos del frame de video
    private long timestamp;   // Marca de tiempo del frame (puede ser útil para sincronización)
    
    public VideoFrame(){
    	
    }
    
    public VideoFrame(byte[] frameData, long timestamp) {
    	this.frameData=frameData;
    	this.timestamp=timestamp;
    }

}
