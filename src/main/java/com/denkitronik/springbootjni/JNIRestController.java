package com.denkitronik.springbootjni;

import ejemplojni.lib.JavaProceso;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/libProcesos")
public class JNIRestController {
    private JavaProceso proceso_SJF ;

    public JNIRestController() {
        this.proceso_SJF  = new JavaProceso();
    }

    @PostMapping("/sjf/expulsivo")
    public ResponseEntity<String> ejecutarSJFExpulsivo(@RequestBody String jsonInput) {
        String resultadoJson = proceso_SJF.algoritmo_SJF_no_expulsivo(jsonInput);
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(resultadoJson);
    }

    @PostMapping("/sjf/no-expulsivo")
    public ResponseEntity<String> ejecutarSJFNoExpulsivo(@RequestBody String jsonInput) {
        String resultadoJsonNoexpulsivo = proceso_SJF.algoritmo_SJF_no_expulsivo(jsonInput);
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(resultadoJsonNoexpulsivo);
    }

}
