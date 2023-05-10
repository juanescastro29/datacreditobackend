package com.datacredito.datacreditosystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/datacredito")
public class DataCreditoController {

    @GetMapping("/consultaDatacredito/{puntaje}")
    public String consultaDatacredito(@PathVariable Integer puntaje) {
        String respuesta = "";
        if (puntaje >= 591) {
            respuesta = "El puntaje del cliente es valido para solicitar el prestamo.";
        }else {
            respuesta = "El puntaje del cliente no es valido para solicitar el prestamo.";
        }

        return respuesta;
    }

    @PostMapping("/iniciarSesion")
    public String iniciarSesion(@RequestBody Map<String, String> datosCliente) throws IOException {
        String response = "";
        String json = new ObjectMapper().writeValueAsString(datosCliente);
        StringBuilder resultado = new StringBuilder();
        String direccion = "http://localhost:8080/banco/validarCliente";
        URL url = new URL(direccion);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("POST");
        conexion.setRequestProperty("Content-Type", "application/json");
        conexion.setDoOutput(true);

        OutputStream output = conexion.getOutputStream();
        output.write(json.getBytes("UTF-8"));
        output.close();

        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;
        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }
        rd.close();

        if (resultado.toString().equals("Datos validos")) {
            response = "Inicio de sesion concedido.";
        }else if(resultado.toString().equals("Cliente")) {
            response = "Cliente con id " + datosCliente.get("idCliente") + " no registrado.";
        }else {
            response = "Contraseña incorrecta.";
        }
        return response;
    }


}
