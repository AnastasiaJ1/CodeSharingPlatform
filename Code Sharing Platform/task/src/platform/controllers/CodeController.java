package platform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import platform.models.Code;
import platform.models.CodeDTO;
import platform.models.EmptyJsonResponse;
import platform.models.IdResponse;
import platform.services.impl.CodeServiceImpl;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class CodeController {
    @Autowired
    private final CodeServiceImpl service;

    public CodeController(CodeServiceImpl service) {
        this.service = service;
    }


    @GetMapping("/api/code/{id}")
    public ResponseEntity<?> getAPICode(@PathVariable(value = "id") String id) {
        if(service.isExists(id) != null){
            System.out.println("/api/code/{id}" + id);
            Code code = service.getById(id);
            return ResponseEntity.status(200).body(service.getCodeResponse(code));
        } else {
            return ResponseEntity.status(404).body(new EmptyJsonResponse());
        }


    }

    @PostMapping("/api/code/new")
    public ResponseEntity<?> postCode(@RequestBody CodeDTO newCode){
        Code code = new Code(newCode.getCode(), newCode.getTime(), newCode.getViews());
        System.out.println("/api/code/new" + code.toString());
        service.save(code);
        return ResponseEntity.status(200).body(new IdResponse(code.getId()));
    }

    @GetMapping(value = "/code/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public String getCode(HttpServletResponse response, @PathVariable(value = "id") String id, Model model) {
        response.addHeader("Content-Type", "text/html");
        if (service.isExists(id) == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found");
        }

        Code code = service.getById(id);
        model.addAttribute("code", code.getCode());
        model.addAttribute("date", code.getDate());
        model.addAttribute("time", code.getTime());
        model.addAttribute("views", code.getViews());
        model.addAttribute("timerest", code.getSecretTime());
        model.addAttribute("viewsrest", code.getSecretViews());
        return "code3";
    }
    @GetMapping(value = "/code/new", produces = MediaType.TEXT_HTML_VALUE)
    public String getCodeNew() {
        return "code_new";
    }


    @GetMapping(value = "/api/code/latest")
    public ResponseEntity<?> getApiCodeLatest() {
        List<Code> result = service.findLast10();
        System.out.println("/api/code/latest");
        return ResponseEntity.status(200).body(result);
    }

    @GetMapping(value = "/code/latest")
    public String getCodeLatest(Model model) {
        System.out.println("/code/latest");

        List<Code> curCodeList = service.findLast10();
        model.addAttribute("codes", curCodeList);
        System.out.println("bla");
        return "code2";
    }

    @GetMapping (value = "/deleteAll")
    public ResponseEntity<?> deleteAll(){
        service.deleteAll();
        return ResponseEntity.status(200).build();
    }
}

