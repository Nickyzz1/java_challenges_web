package com.example.demo.controllers;


import java.util.InputMismatchException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Importação para trabalhar com JSON
import com.google.gson.Gson;
import java.util.regex.Pattern;

import com.example.demo.controllers.dto.ValidatorDto;

@RestController
@RequestMapping("validar")
public class CuritibaRegisterController {

    @GetMapping("/{cpf}/{cep}")
    public ValidatorDto validarCpfCep(@PathVariable String cpf, @PathVariable String cep) {

        boolean isValidCpf = isValidCpf(cpf);
        boolean isValidCep = isValidCep(cep);

        if (isValidCpf && isValidCep) {
            
            if(isCuritibaCep(cep))
                return new ValidatorDto("cpf válido e cep de curitiba");
            return new ValidatorDto("cpf valido e cep não é de curitiba");
        }
        else if (isValidCpf && isValidCep == false) {
            return new ValidatorDto("cpf válido e cep invalido");
        }
        else if(isValidCpf == false && isValidCep) {

            if(isCuritibaCep(cep))
                return new ValidatorDto("cpf inválido e cep de curitiba");

            return new ValidatorDto("cpf inválido e cep não é de curitiba");

        } else {
            return new ValidatorDto ("ambos dados inválidos");
        }
    }


    public boolean isValidCpf (String CPF) {

            if (CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11)) {
                return false;
            }
        
            String dig10, dig11;
            Integer sm, i, r, num, peso;
        
            try {
                // Cálculo do 1º Dígito Verificador
                sm = 0;
                peso = 10;
                for (i = 0; i < 9; i++) {
                    num = Character.getNumericValue(CPF.charAt(i));
                    sm += (num * peso);
                    peso--;
                }
        
                r = 11 - (sm % 11);
                dig10 = (r == 10 || r == 11) ? "0" : String.valueOf(r);
        
                // Cálculo do 2º Dígito Verificador
                sm = 0;
                peso = 11;
                for (i = 0; i < 10; i++) {
                    num = Character.getNumericValue(CPF.charAt(i));
                    sm += (num * peso);
                    peso--;
                }
        
                r = 11 - (sm % 11);
                dig11 = (r == 10 || r == 11) ? "0" : String.valueOf(r);
        
                // Verifica se os dígitos calculados conferem com os dígitos informados
                return dig10.equals(String.valueOf(CPF.charAt(9))) && dig11.equals(String.valueOf(CPF.charAt(10)));
            } catch (InputMismatchException erro) {
                return false;
            }
        
        }
    
      public static boolean isValidCep(String cep) {
        if (!Pattern.matches("\\d{5}-\\d{3}", cep) && !Pattern.matches("\\d{8}", cep)) {
            return false; // \d(0 a 9) de 5 digiitos
        }
        
        if (cep.length() == 10) {
            cep = cep.replace("-", "");
        }

        return true;
    }

    public static boolean isCuritibaCep(String cep) {
        cep = cep.replace("-", "");
        String urlString = "https://viacep.com.br/ws/" + cep + "/json/?callback=callback_name";
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .build();
    
        final CepInfo[] cepInfo = {null};
    
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(response -> {
                    // Remove o nome do callback
                    String jsonResponse = response.replaceAll("^callback_name\\(", "").replaceAll("\\);$", "");
                    Gson gson = new Gson();
                    cepInfo[0] = gson.fromJson(jsonResponse, CepInfo.class);
                })
                .join();
        
        return cepInfo[0] != null && "Curitiba".equals(cepInfo[0].getLocalidade());
    }
    
}


   

