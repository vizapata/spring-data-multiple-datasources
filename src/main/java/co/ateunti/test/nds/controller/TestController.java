package co.ateunti.test.nds.controller;

import co.ateunti.test.nds.domain.Sample;
import co.ateunti.test.nds.service.SampleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("api")
public class TestController {

    private final SampleService sampleService;

    public TestController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("test")
    public ResponseEntity<Sample> test(@RequestParam String doc) {
        return ResponseEntity.of(sampleService.findByDocNumber(doc));
    }

}
