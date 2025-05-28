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

    @PostMapping("/sjf")
    public ResponseEntity<String> ejecutarSJF(
            @RequestParam(name = "expulsivo", defaultValue = "false") boolean expulsivo,
            @RequestBody String jsonInput) {
        
        String resultadoJson;
        if (expulsivo) {
            resultadoJson = proceso_SJF.algoritmo_SJF_expulsivo(jsonInput);
        } else {
            resultadoJson = proceso_SJF.algoritmo_SJF_no_expulsivo(jsonInput);
        }
        
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(resultadoJson);
    }
}

}
