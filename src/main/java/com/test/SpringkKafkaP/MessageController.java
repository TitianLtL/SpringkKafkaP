package com.test.SpringkKafkaP;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    @GetMapping
    public String hi(){
        return "hi";
    }

    @PostMapping
    public void publish(@RequestBody MessageRequest messageRequest){
        kafkaTemplate.send("firstTopic",messageRequest.message());
    }

//    curl -X POST http://localhost:8080/api/v1/messages/  -d '{"message": "nice"}'
//    # 1. Create the data payload as a native PowerShell object
//    $body = @{   message = "nice" } | ConvertTo-Json

//    Invoke-RestMethod -Uri "http://localhost:8080/api/v1/messages" -Method Post -ContentType "application/json" -Body $body

}
