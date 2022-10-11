package com.test.steps;

import com.test.screen.ScreenLogin;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class LoginSteps {

    ScreenLogin login;

    public LoginSteps() {
        login = new ScreenLogin();
    }
    @Dado("^que eu escreva as informações do usuário$")
    public void que_eu_ecreva_as_informações_do_usuário() {
        login.DadoescreverEmail();
        login.QuandoescreverSenha();
    }
    @Quando("^eu clicar em logar$")
    public void eu_clicar_em_logar() {
        login.EntaoclicarParaLogar();
    }
        @Então("^vou estar logado no app$")
    public void vou_estar_logado_no_app() {
        System.out.println("Validar logado");
    }
}
