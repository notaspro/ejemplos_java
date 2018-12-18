package com.developertack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.developertack.dto.MensajeDto;

/**
 * Fuente: https://github.com/sjmf/ng2-stompjs-demo
 * 
 * @author gonzasilve
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/socket")
public class WebSocketController {
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	@PostMapping("/broadcast")
    public ResponseEntity<MensajeDto> broadCast(@RequestBody MensajeDto mensajeDto) throws Exception {
		//String sessionId = headerAccessor.getSessionAttributes().get("sessionId").toString();
		//System.out.println("sessionId: "+sessionId);
		System.out.println(mensajeDto.toString());
		simpMessagingTemplate.convertAndSend("/topic/testSubscribe", mensajeDto);
		return new ResponseEntity<MensajeDto>(mensajeDto, HttpStatus.OK);
    }
	
}
